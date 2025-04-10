
### Was ist SLAAC?

- **SLAAC** (Stateless Address Autoconfiguration) ermöglicht es einem Gerät, seine IPv6-Adresse **selbstständig** zu generieren – **ohne** DHCP-Server.
  
  **Bestandteile von SLAAC:**
  1. **Prefix vom Router** → z. B. `2001:db8:abcd:1::/64`
  2. **Interface-ID** → automatisch generiert (z. B. über MAC-Adresse mit **EUI-64**)

---

### EUI-64-Verfahren zur Interface-ID-Erzeugung

1. **MAC-Adresse (Beispielgerät):**
   ```
   00:25:96:12:34:56
   ```

2. **Teilen der MAC-Adresse in zwei Hälften:**
   ```
   Erste Hälfte: 00:25:96  
   Zweite Hälfte: 12:34:56
   ```

3. **Einfügen von `FF:FE` in der Mitte:**
   ```
   00:25:96:FF:FE:12:34:56
   ```

4. **Invertieren des 7. Bits im ersten Byte (U/L-Bit):**
   - Erstes Byte: `00` = `00000000` (binär)  
   - 7. Bit invertieren → ergibt: `00000010` = `02`
   - Neue erste Byte: `02`

   → Ergebnis:  
   ```
   Interface-ID: 0225:96ff:fe12:3456
   ```

---

### Vollständige SLAAC-Adresse

Wenn der Router das Präfix `2001:db8:abcd:1::/64` bekannt gibt, ergibt sich durch SLAAC folgende vollständige IPv6-Adresse:

```
2001:db8:abcd:1:0225:96ff:fe12:3456
```
