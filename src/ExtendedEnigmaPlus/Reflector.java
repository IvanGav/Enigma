package ExtendedEnigmaPlus;

public class Reflector {
    int[] offsets;
    public Reflector(int[] l) {
        offsets = l;
    }

    public int reflect(int i) {
        //System.out.println("Reflector: " + (char)('a'+i) + " -> " + (char)('a'+normalize(i + offsets[i])));
        return normalize(i + offsets[i]);
    }

    private int normalize(int i) {
        return (i + offsets.length) % offsets.length;
    }
}