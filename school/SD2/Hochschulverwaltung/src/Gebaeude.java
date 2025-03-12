import java.util.ArrayList;
import java.util.List;

public class Gebaeude {
    private String adresse;
    private String bezeichnung;
    private int anzahlEtagen;
    private List<Raum> raeume;

    public Gebaeude(String adresse, String bezeichnung, int anzahlEtagen) {
        this.adresse = adresse;
        this.bezeichnung = bezeichnung;
        this.anzahlEtagen = anzahlEtagen;
        this.raeume = new ArrayList<>();
    }

    public String getAdresse() {
        return adresse;
    }

    public String getBezeichnung() {
        return bezeichnung;
    }

    public int getAnzahlEtagen() {
        return anzahlEtagen;
    }

    public void addRaum(Raum raum) {
        raeume.add(raum);
    }

    public void addRaeume(List<Raum> raeume) {
        this.raeume.addAll(raeume);
    }

    public List<Raum> getRaeume() {
        return raeume;
    }
}
