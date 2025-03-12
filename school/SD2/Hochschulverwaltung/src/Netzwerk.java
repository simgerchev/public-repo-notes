import java.util.Arrays;

public class Netzwerk {
    private String ipBereich;
    private int[] ports;

    public Netzwerk(String ipBereich, int[] ports) {
        this.ipBereich = ipBereich;
        this.ports = ports;
    }

    public String getIpBereich() {
        return ipBereich;
    }

    public int[] getPorts() {
        return ports;
    }
}
