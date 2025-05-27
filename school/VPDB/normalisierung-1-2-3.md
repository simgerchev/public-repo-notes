
# Lernzettel: 1., 2. und 3. Normalform (1NF, 2NF, 3NF)

## Was ist Normalisierung?
Normalisierung ist ein Prozess in der Datenbankmodellierung, um **Redundanzen zu vermeiden** und **Dateninkonsistenz** zu reduzieren. Es wird in mehreren Stufen durchgeführt, sogenannte **Normalformen (NF)**.

---

## 1. Normalform (1NF)

### ➤ Definition
Eine Relation befindet sich in der **1NF**, wenn **alle Attributwerte atomar** sind (d.h. **nicht weiter zerlegbar**).

### ➤ Beispiel: Nicht in 1NF
| KundeID | Name     | Telefonnummer         |
|---------|----------|------------------------|
| 1       | Müller   | 0123, 0456             |
| 2       | Schmidt  | 0789                   |

**Problem:** Mehrere Telefonnummern in einer Zelle.

### In 1NF überführt:
| KundeID | Name     | Telefonnummer |
|---------|----------|---------------|
| 1       | Müller   | 0123          |
| 1       | Müller   | 0456          |
| 2       | Schmidt  | 0789          |

---

## 2. Normalform (2NF)

### ➤ Definition
Eine Relation ist in der **2NF**, wenn sie in **1NF** ist **und** **alle Nichtschlüsselattribute vom gesamten Primärschlüssel funktional abhängig sind** (gilt nur bei zusammengesetzten Schlüsseln).

### ➤ Beispiel: Nicht in 2NF
| MatrikelNr | KursID | Kursname       | Note |
|------------|--------|----------------|------|
| 1001       | A1     | Mathe          | 2.0  |
| 1001       | B1     | Deutsch        | 1.7  |

**Primärschlüssel:** (MatrikelNr, KursID)  
**Problem:** `Kursname` hängt **nur von KursID** ab, nicht vom gesamten Schlüssel.

### In 2NF überführt:

**Tabelle: Belegung**
| MatrikelNr | KursID | Note |
|------------|--------|------|
| 1001       | A1     | 2.0  |

**Tabelle: Kurs**
| KursID | Kursname |
|--------|----------|
| A1     | Mathe    |
| B1     | Deutsch  |

---

## 3. Normalform (3NF)

### ➤ Definition
Eine Relation ist in der **3NF**, wenn sie in **2NF** ist und **kein Nichtschlüsselattribut transitiv vom Primärschlüssel abhängig ist**.

### ➤ Beispiel: Nicht in 3NF
| PersonalNr | Name     | AbteilungsNr | Abteilungsname |
|------------|----------|--------------|----------------|
| 1          | Meier    | 10           | Buchhaltung    |

**Problem:** `Abteilungsname` hängt nicht direkt von `PersonalNr` ab, sondern von `AbteilungsNr` → **transitive Abhängigkeit**.

### In 3NF überführt:

**Tabelle: Mitarbeiter**
| PersonalNr | Name   | AbteilungsNr |
|------------|--------|---------------|
| 1          | Meier  | 10            |

**Tabelle: Abteilung**
| AbteilungsNr | Abteilungsname |
|--------------|----------------|
| 10           | Buchhaltung    |

---

## Zusammenfassung der Normalformen

| Normalform | Bedingung                                                                 |
|------------|---------------------------------------------------------------------------|
| 1NF        | Nur atomare Werte in jeder Zelle                                          |
| 2NF        | 1NF + jedes Nichtschlüsselattribut hängt vom gesamten (zusammengesetzten) Schlüssel ab |
| 3NF        | 2NF + keine transitive Abhängigkeit von Nichtschlüsselattributen          |
