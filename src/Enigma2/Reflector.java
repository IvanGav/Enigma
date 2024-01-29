package Enigma2;

public class Reflector {
    int[] offsets;
    public Reflector(int[] l) {
        offsets = l;
    }

    public int reflect(int i) {
        return (i + offsets[i] + offsets.length)%offsets.length;
    }
}
