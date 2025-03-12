public class Raum {
    private Lehrstuhl lehrstuhl;
    private Gebaeude gebaeude;
    private int raumnummer;

    public Raum(Gebaeude gebaeude, int raumnummer) {
        this.gebaeude = gebaeude;
        this.raumnummer = raumnummer;
    }

    public Gebaeude getGebaeude() {
        return gebaeude;
    }

    public int getRaumnummer() {
        return raumnummer;
    }

    public void setLehrstuhl(Lehrstuhl lehrstuhl) {
        this.lehrstuhl = lehrstuhl;
    }

    public void unsetLehrstuhl() {
        this.lehrstuhl = null;
    }
}
