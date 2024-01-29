package Enigma2;

public class Rotor {
    int[] offsets;
    public Rotor(int[] l) {
        offsets = l;
    }

    public int forward(int i, int rot) {
        return normalize(i + offsets[normalize(i-rot)]);
    }

    public int backward(int i, int rot) {
        int in = normalize(i-rot);
        for (int j = 0; j < offsets.length; j++) {
            if(j+offsets[j] == in) return normalize(j + rot);
        }
        System.out.println("An error occurred");
        return -1;
    }

    private int normalize(int i) {
        return (i + offsets.length) % offsets.length;
    }

}
