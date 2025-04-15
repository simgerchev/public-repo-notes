# Vorbereitung auf die 2. Klassenarbeit (IPv6)

---

## 1. IPv6-Adressaufbau & -Darstellung

### Struktur einer IPv6-Adresse

- **Länge:**  
  Eine IPv6-Adresse ist 128 Bit lang, bestehend aus 8 Blöcken zu je 16 Bit.

- **Darstellung:**  
  Jeder 16-Bit-Block wird in Hexadezimal dargestellt und durch Doppelpunkte `:` getrennt.  
  Beispiel: `2001:0db8:0000:0000:0000:ff00:0042:8329`

### Verkürzungsregeln für IPv6-Adressen

1. **Führende Nullen weglassen:**  
   `0042` → `42`

2. **Längste zusammenhängende Null-Blöcke mit `::` ersetzen (nur einmal pro Adresse):**  
   `2001:0db8:0000:0000:0000:0000:0000:0001` → `2001:db8::1`

---

## 2. Subnetting mit IPv6 – Adressplanung

### Aufbau einer IPv6-Adresse

1. **Globales Präfix** (z. B. `2001::/3`) – identifiziert den Adressbereich.
2. **Subnetz-ID** – beschreibt ein bestimmtes Subnetz.
3. **Interface-ID** – identifiziert das Gerät im Subnetz (meist 64 Bit).

---

### Beispiel: 100 Subnetze

#### Ausgangsnetz:  
`2001:0db8:1234::/48`

- **Subnetzbedarf:**  
  Für 100 Subnetze werden mindestens 7 Bits benötigt, da `2^7 = 128`.

- **Neuer Präfix:** `/48 + 7 = /55`

#### Subnetzadressen (Beispiele):

| Subnetz-Nr | Adresse                  |
|------------|---------------------------|
| 0          | `2001:db8:1234:0000::/55` |
| 1          | `2001:db8:1234:0020::/55` |
| 2          | `2001:db8:1234:0040::/55` |
| ...        | ...                       |
| 127        | `2001:db8:1234:00fe::/55` |

---

## 3. Automatische Adresskonfiguration (SLAAC)

### Was ist SLAAC?

- SLAAC (Stateless Address Autoconfiguration) erlaubt Geräten, ihre IPv6-Adresse selbst zu konfigurieren – **ohne DHCPv6-Server**.
- Die Adresse setzt sich zusammen aus:
  1. **Prefix vom Router** (z. B. `2001:db8:abcd:1::/64`)
  2. **Interface-ID**, erzeugt aus der MAC-Adresse (via EUI-64) oder zufällig.

### EUI-64-Verfahren zur Interface-ID-Erzeugung

**Gegeben: MAC-Adresse `00:25:96:12:34:56`**

1. Aufteilen in zwei Hälften:  
   - `00:25:96` und `12:34:56`

2. Einfügen von `FF:FE`:  
   - `00:25:96:FF:FE:12:34:56`

3. Invertieren des 7. Bits (U/L-Bit) des ersten Bytes:  
   - `00` → `02`

4. **Interface-ID:** `0225:96ff:fe12:3456`

5. **Vollständige IPv6-Adresse (mit Prefix):**  
   `2001:db8:abcd:1:0225:96ff:fe12:3456`

---

## 4. Beispielaufgabe: IPv6 Subnetting + Interface-ID

### Aufgabenstellung

- Ausgangspräfix: `/48`
- Gewünschte Subnetze: 100
- Benötigte Bits: `log2(100) ≈ 7`
- Neuer Präfix: `/55`

### Subnetze (Bereich):

| Subnetz-Nr | Adresse                  |
|------------|---------------------------|
| 0          | `2001:db8:1234:0000::/55` |
| 1          | `2001:db8:1234:0020::/55` |
| 2          | `2001:db8:1234:0040::/55` |
| ...        | ...                       |
| 127        | `2001:db8:1234:00fe::/55` |

### Beispiel – vollständige Adresse eines Hosts:

- **Subnetz:** `2001:db8:1234:0040::/55`
- **MAC-Adresse:** `00:25:96:12:34:56`
- → **IPv6-Adresse:**  
  `2001:db8:1234:0040:0225:96ff:fe12:3456`

---

## 5. IPv6-Adresstypen – Übersicht

### 1. Unicast

| Typ                    | Beschreibung                                                | Präfix / Bereich       |
|------------------------|-------------------------------------------------------------|------------------------|
| Global Unicast         | Öffentlich erreichbare Adressen                             | `2000::/3`             |
| Link-Local             | Nur im lokalen Netz gültig, nicht routbar                   | `fe80::/10`            |
| Unique Local (ULA)     | Privat, vergleichbar mit `192.168.x.x`                      | `fc00::/7`, meist `fd` |
| Loopback               | Kommunikation mit sich selbst                               | `::1`                  |
| Unspecified            | Gerät hat noch keine Adresse                                | `::`                   |
| IPv4-Mapped IPv6       | Für IPv4-Kompatibilität                                      | `::ffff:192.0.2.128`   |

---

### 2. Multicast

| Adresse             | Beschreibung                                  |
|---------------------|-----------------------------------------------|
| `ff00::/8`          | Alle Multicast-Adressen                       |
| `ff02::1`           | Alle Geräte im lokalen Link                   |
| `ff02::2`           | Alle Router im lokalen Link                   |
| `ff02::1:ffXX:XXXX` | Solicited-Node (wird für NDP verwendet)       |

> Hinweis: IPv6 **verwendet Multicast statt Broadcast**.

---

### 3. Anycast

- **Sieht aus wie Unicast**, wird aber mehreren Geräten zugewiesen.
- Paket wird an das **nächstgelegene** (topologisch) Gerät geschickt.
- Verwendet z. B. bei DNS, CDNs, Load Balancing.
- Keine eigene Adressklasse – manuell konfiguriert.

---

## 6. Kein Broadcast in IPv6

> IPv6 kennt **keinen Broadcast**. Stattdessen wird **Multicast** verwendet.

---

## 7. DHCPv4 – Zusammenfassung

### Was ist DHCPv4?

DHCPv4 (Dynamic Host Configuration Protocol for IPv4) weist automatisch:

- IPv4-Adressen
- Standardgateway
- DNS-Server

zu.

---

### Ablauf (DORA-Prozess):

1. **Discover:** Client sendet DHCPDISCOVER (Broadcast)
2. **Offer:** Server bietet eine IP-Adresse an (DHCPOFFER)
3. **Request:** Client nimmt Angebot an (DHCPREQUEST)
4. **Acknowledge:** Server bestätigt (DHCPACK)

---

### Weitere Infos:

- **Lease Time:** Dauer der Zuweisung
- **Erneuerung:** Vor Ablauf wird Adresse erneuert
- **Fallback:** Wenn kein Server → APIPA-Adresse (`169.254.x.x`)

---

### Beispiel aus dem Alltag:

Laptop verbindet sich mit WLAN → DHCP weist automatisch IP zu → Verbindung steht.

---

