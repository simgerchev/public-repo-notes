import java.util.ArrayList;
import java.util.List;

public class Lehrstuhl {
    private String name;
    private String dozent;
    private List<Raum> raeume;
    private List<Lehrstuhlnetzwerk> netzwerke;

    public Lehrstuhl(String name) {
        this.name = name;
        this.raeume = new ArrayList<>();
        this.netzwerke = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void addLehrstuhlnetzwerk(Lehrstuhlnetzwerk lehrstuhlnetzwerk) {
        netzwerke.add(lehrstuhlnetzwerk);
    }

    public void removeLehrstuhlnetzwerk(Lehrstuhlnetzwerk lehrstuhlnetzwerk) {
        netzwerke.remove(lehrstuhlnetzwerk);
    }

    public void addRaum(Raum raum) {
        raeume.add(raum);
    }

    public void removeRaum(Raum raum) {
        raeume.remove(raum);
    }

    public List<Raum> getRaeume() {
        return raeume;
    }

    public List<Lehrstuhlnetzwerk> getNetzwerke() {
        return netzwerke;
    }
}
