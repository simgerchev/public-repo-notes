
# Lernzettel: Abstrakte Klassen und Interfaces in Java & UML

## Abstrakte Klassen (abstract class)

### ➤ Definition
- Eine Klasse, die nicht instanziiert werden kann.
- Kann abstrakte **und** konkrete Methoden enthalten.
- Dient als Basisklasse für Spezialisierungen.

### ➤ Java-Syntax
```java

public abstract class Fahrzeug {
    protected String name;

    public Fahrzeug(String name) {
        this.name = name;
    }

    public void starten() {
        System.out.println(name + " startet.");
    }

    public abstract void fahren(); // Muss überschrieben werden
}

public class Auto extends Fahrzeug implements Beweglich {

    public Auto(String name) {
        super(name); // Konstruktor von Fahrzeug aufrufen
    }

    @Override
    public void fahren() {
        System.out.println(name + " fährt auf der Straße.");
    }

    @Override
    public void bewegen() {
        System.out.println(name + " bewegt sich vorwärts.");
    }
}

```

### ➤ Merkmale
- Kann Konstruktoren, Felder und Methoden enthalten.
- Abstrakte Methoden haben **keinen Methodenkörper**.
- Eine Unterklasse muss alle abstrakten Methoden implementieren oder selbst abstrakt sein.

### ➤ UML-Darstellung
```plaintext
 _______________________
| <<abstract>>          |
| Fahrzeug              |
|-----------------------|
| - name: String        |
|-----------------------|
| + starten(): void     |
| + fahren(): void      |  <-- kursiv oder abstrakt markieren
 -----------------------
```

---

## Interface

### ➤ Definition
- Eine Schnittstelle mit nur Methodensignaturen (ab Java 8 auch `default` und `static` Methoden möglich).
- Dient zur Definition von Fähigkeiten, die Klassen implementieren können.

### ➤ Java-Syntax
```java

public interface Beweglich {
    void bewegen(); // public abstract ist implizit
}

public class Auto implements Beweglich {

    @Override
    public void bewegen() {
        System.out.println("Das Auto fährt.");
    }
}

```

### ➤ Merkmale
- Keine Konstruktoren oder Instanzvariablen (nur Konstanten).
- Eine Klasse kann mehrere Interfaces implementieren (Mehrfachvererbung).
- Methoden sind automatisch `public` und `abstract` (außer `default` oder `static`).

### ➤ UML-Darstellung
```plaintext
 _______________________
| <<interface>>         |
| Beweglich             |
|-----------------------|
| + bewegen(): void     |
 -----------------------
```

---

## Unterschiede: Abstrakte Klasse vs Interface

| Merkmal                  | Abstrakte Klasse         | Interface                 |
|--------------------------|--------------------------|---------------------------|
| Vererbung                | Nur einfache Vererbung   | Mehrfachvererbung möglich |
| Methoden mit Code        | Ja                       | Nur `default` oder `static` |
| Konstruktoren erlaubt    | Ja                       | Nein                      |
| Felder                   | Instanzvariablen erlaubt | Nur `public static final` |
| Verwendungszweck         | "ist ein" Beziehung      | "kann" Beziehung          |

---

## Wann was verwenden?
- **Abstrakte Klassen**: Wenn Klassen eine gemeinsame Basisklasse mit gemeinsamem Verhalten brauchen.
- **Interfaces**: Wenn verschiedene Klassen eine gemeinsame Fähigkeit haben sollen, unabhängig von ihrer Vererbung.
