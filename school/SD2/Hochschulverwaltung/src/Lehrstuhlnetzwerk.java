public class Lehrstuhlnetzwerk extends Netzwerk {
    private Lehrstuhl lehrstuhl;

    public Lehrstuhlnetzwerk(String ipBereich, int[] ports, Lehrstuhl lehrstuhl) {
        super(ipBereich, ports);
        this.lehrstuhl = lehrstuhl;
    }

    public Lehrstuhl getLehrstuhl() {
        return lehrstuhl;
    }
}