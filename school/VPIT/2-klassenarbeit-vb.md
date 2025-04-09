# Vorbereitung auf die 2. Klassenarbeit (IPv6)

---

## 1. IPv6-Adressaufbau & -Darstellung

### Struktur einer IPv6-Adresse

- **Länge:**  
  Eine IPv6-Adresse hat eine Länge von 128 Bit. Das bedeutet, dass eine vollständige IPv6-Adresse 128 binäre Zahlen (Bits) enthält.

- **Aufteilung:**  
  Diese 128 Bits sind in **8 Blöcke** zu je **16 Bit** unterteilt. Jeder Block ist eine Gruppe von 4 Hexadezimalziffern (also insgesamt 32 Hexadezimalzeichen für eine vollständige IPv6-Adresse).

- **Darstellung:**  
  Die Adresse wird als **Hexadezimalzahl** dargestellt und durch **Doppelpunkte** `:` getrennt. Zum Beispiel:  
  - `2001:0db8:0000:0000:0000:ff00:0042:8329`
- **Aufbau Komponente:**
  IPv6-Adressen haben oft eine bestimmte Struktur, z. B.:
  - **Präfix (Netz-ID)** – z. B. die ersten 64 Bit
  - **Interface Identifier (Host-ID)** – die letzten 64 Bit

#### Beispiel (voll ausgeschrieben):  
`2001:0db8:0000:0000:0000:ff00:0042:8329`

- Der Adressraum ist durch die Hexadezimaldarstellung kompakter und lesbarer, da 16 Bits pro Block auf eine Hexadezimalzahl (2 Hexadezimalziffern) abgebildet werden.

  Zum Beispiel:  
  - `2001:0db8:0000:0000:0000:ff00:0042:8329`  
  wird zu  
  - `2001:db8:0:0:0:ff00:42:8329`.

#### Verkürzungsregeln für IPv6-Adressen

1. **Führende Nullen weglassen:**  
   - Beispiel: `0042` wird zu `42`.
  
2. **Längste Null-Blöcke mit `::` ersetzen:**  
   - Ein Block von aufeinander folgenden Nullen kann durch `::` ersetzt werden. Dies darf **nur einmal** pro Adresse erfolgen, da sonst die genaue Position der Nullen nicht mehr erkennbar wäre.
     - Beispiel:  
       `2001:0db8:0000:0000:0000:0000:0000:0001`  
       wird zu  
       `2001:db8::1`.

---

## 2. Subnetting mit IPv6 – Adressplanung

### Aufbau einer IPv6-Adresse

1. **Globales Präfix**  
   Dies ist der Teil der Adresse, der den globalen Bereich beschreibt, z.B. `2001::/3`. Dies bedeutet, dass die ersten 3 Bits der Adresse festgelegt sind und die restlichen Bits für das Subnetz und die Interface-ID verwendet werden.

2. **Subnetz-ID**  
   Die Subnetz-ID beschreibt den spezifischen Bereich innerhalb des globalen Adressraums, der einem bestimmten Netzwerk zugewiesen ist. Dies ist typischerweise der zweite Teil der IPv6-Adresse. 

3. **Interface-ID**  
   Die Interface-ID ist der spezifische Teil einer Adresse, der einem einzelnen Gerät innerhalb des Netzwerks zugeordnet ist. Diese ID ist in der Regel 64 Bit lang und kann aus der MAC-Adresse des Geräts generiert werden.

---

### Beispiel: 100 Subnetze

#### Ausgangsnetz:  
`2001:0db8:1234::/48`

- **Subnetzbedarf:**  
  Um **100 Subnetze** zu erstellen, benötigen wir mindestens **7 zusätzliche Bits**, weil `2^7 = 128` Subnetze möglich sind. (100 Subnetze benötigen also 7 Bits, da `2^7` für mehr als genug Subnetze sorgt).  
  Dies führt zu einem neuen Präfix von **/55**.

#### Subnetzadressen:

| Subnetz-Nr | Adresse                  |
|------------|---------------------------|
| 0          | `2001:db8:1234:0000::/64` |
| 1          | `2001:db8:1234:0001::/64` |
| 2          | `2001:db8:1234:0002::/64` |
| ...        | ...                       |
| 127        | `2001:db8:1234:007f::/64` |

### Erklärung:
- **Subnetzbedarf:** Um 100 Subnetze zu erstellen, sind **7 Bits** erforderlich, da `2^7 = 128` Subnetze möglich sind, was für 100 Subnetze mehr als ausreichend ist.
- Daher ergibt sich ein neuer Präfix von **/55** (also `/48 + 7` = `/55`).
- Die Subnetze werden fortlaufend von `2001:db8:1234:0000::/64` bis `2001:db8:1234:007f::/64` reichen.

---

## 3. Automatische Adresskonfiguration (SLAAC)


### Was ist SLAAC?

- **SLAAC** (Stateless Address Autoconfiguration) ermöglicht es einem Gerät, seine IPv6-Adresse ohne die Notwendigkeit eines DHCP-Servers selbst zu generieren.

  **Bestandteile von SLAAC:**
  1. **Prefix vom Router** (z.B. `2001:db8:abcd:1::/64`).
  2. **Interface-ID**, die entweder aus der MAC-Adresse des Geräts oder zufällig generiert wird.

### EUI-64-Verfahren zur Interface-ID-Erzeugung

1. **MAC-Adresse:** `00:1A:2B:3C:4D:5E`

2. **Teilen der MAC-Adresse in zwei Hälften:**  
   - `00:25:96` + `12:34:56`
   
3. **Einfügen von `FF:FE`:**  
   - `00:25:96:FF:FE:12:34:56`
   
4. **Invertieren des 7. Bits (U/L-Bit):**  
   - Das 7. Bit im ersten Byte (`00 = 00000000`) wird invertiert zu `02 = 00000010`.
   
   - Dadurch wird die **Interface-ID:** `0225:96ff:fe3c:4d5e`.

### Zusammenfassung

1. **Prefix vom Router:** `2001:db8:abcd:1::/64`
2. **MAC-Adresse:** `00:1A:2B:3C:4D:5E`
3. **Teilen und Einfügen von `FF:FE`:** `00:1A:2B:FF:FE:3C:4D:5E`
4. **Invertieren des 7. Bits (U/L-Bit):** `02:1A:2B:FF:FE:3C:4D:5E`
5. **Interface-ID:** `021A:2BFF:FE3C:4D5E`
6. **Vollständige IPv6-Adresse:** `2001:db8:abcd:1:021A:2BFF:FE3C:4D5E`

### Vorteile von SLAAC:

- **Kein DHCP-Server** erforderlich.
- Geräte können ihre IPv6-Adressen **selbstständig** generieren.
- **Automatische Netzwerkkonfiguration** ohne zusätzliche Server-Ressourcen.


---

### Beispielaufgabe: IPv6 Subnetting

#### 1. Anzahl benötigter Bits berechnen

- Aktueller Präfix: `/48`
- Benötigte Subnetze: **100** → log₂(100) ≈ 6,64 → **7 Bits** erforderlich.
- Neuer Präfix: `/48 + 7 = /55`
  
  **Subnetze im /55-Bereich:**  
  `2^7 = 128` → ausreichend für 100 Subnetze.

#### 2. Subnetz-Adressen berechnen

Die Subnetze im Bereich `/55` gehen von `2001:db8:1234:0000::/55` bis `2001:db8:1234:007f::/55`.

| Subnetz-Nr | Adresse                  |
|------------|---------------------------|
| 0          | `2001:db8:1234:0000::/55` |
| 1          | `2001:db8:1234:0001::/55` |
| 2          | `2001:db8:1234:0002::/55` |
| ...        | ...                       |
| 127        | `2001:db8:1234:007f::/55` |

#### 3. Vollständige IPv6-Adresse eines Geräts

**Subnetz 2:** `2001:db8:1234:0002::/55`  
**MAC-Adresse:** `00-25-96-12-34-56`

**Schritte zur Interface-ID:**
1. Aufteilen der MAC-Adresse:  
   `00:25:96` + `12:34:56`
2. Einfügen von `FF:FE`:  
   `00:25:96:FF:FE:12:34:56`
3. Invertieren des 7. Bits:  
   `00` → `02`

**Interface-ID:** `0225:96ff:fe12:3456`

**Vollständige IPv6-Adresse:**  
`2001:db8:1234:0002:0225:96ff:fe12:3456`

---

### Arten von IPv6 Adressen

#### Loopback-Adresse

| Typ       | Adresse | Beschreibung                                       |
|-----------|---------|----------------------------------------------------|
| Loopback  | `::1`   | Selbsttest-Adresse, wie `127.0.0.1` bei IPv4      |

---

#### Unicast-Adressen

| Typ               | Bereich        | Beschreibung                                                       | Beispiel                     |
|-------------------|----------------|--------------------------------------------------------------------|------------------------------|
| Global Unicast    | `2000::/3`     | Weltweit eindeutige, öffentliche Adressen                         | `2001:db8::1`                |
| Link-Local        | `fe80::/10`    | Automatisch im lokalen Netzwerk generiert, nicht routbar          | `fe80::1ff:fe23:4567:890a`   |
| Unique Local (ULA)| `fd00::/8`     | Lokale, private Adressen (vergleichbar mit IPv4 `192.168.x.x`)    | `fd12:3456:789a::1`          |

---

#### Multicast-Adressen

| Bereich      | Bedeutung             | Beispiel     |
|--------------|------------------------|--------------|
| `ff01::`     | Interface-local        |              |
| `ff02::`     | Link-local             | `ff02::1` (alle Nodes im LAN) |
| `ff05::`     | Site-local             |              |

---

#### Anycast-Adressen

| Typ     | Beschreibung                                                                 |
|---------|------------------------------------------------------------------------------|
| Anycast | Eine Adresse auf mehreren Geräten – Pakete werden zum „nächsten“ Knoten gesendet |

> Hinweis: Keine speziellen Adressbereiche – normale Unicast-Adresse wird mehrfach vergeben.

---

#### Spezielle / Reservierte Adressen

| Bereich              | Beschreibung                                          |
|----------------------|-------------------------------------------------------|
| `::/128`             | Unbestimmte Adresse (z. B. bei DHCPv6-Start)          |
| `::1/128`            | Loopback-Adresse                                      |
| `::FFFF:0:0/96`      | IPv4-Mapped IPv6-Adressen                             |
| `100::/64`           | Discard-Only-Adresse (für zukünftige Nutzung)         |
| `2001:db8::/32`      | Dokumentationsnetz – für Beispiele in Dokus und Büchern |

---

#### Zusammenfassung

- **Unicast** = Eine Zieladresse
- **Multicast** = Mehrere Empfänger gleichzeitig
- **Anycast** = Nächster Empfänger aus einer Gruppe
- **Loopback** = Kommunikation mit sich selbst
- **Link-Local** = Nur im lokalen Netz gültig
- **ULA** = Private IPv6-Adressen

## Zusammenfassung (ALLES) 

| Teilaufgabe              | Ergebnis                                       |
|--------------------------|------------------------------------------------|
| Benötigte Bits           | 7 Bits → ergibt Präfix `/55`                   |
| Subnetz 0                | `2001:db8:1234:0000::/64`                      |
| Subnetz 1                | `2001:db8:1234:0001::/64`                      |
| Subnetz 127              | `2001:db8:1234:007f::/64`                      |
| Beispielgerät Subnetz 2  | `2001:db8:1234:0002:0225:96ff:fe12:3456`       |
