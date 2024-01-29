package ExtendedEnigma;

public class Rotor {
    int[] offsets;
    int turnover;
    int ring;

    public Rotor(int[] l, int turn, int ringSetting) {
        offsets = l;
        turnover = turn;
        ring = ringSetting;
    }

    public int forward(int i, int rot) {
        //System.out.println("Forward: " + (char)('a'+i) + " -> " + (char)('a'+normalize(i + offsets[normalize(i+rot-ring)])) +
        //        " (rot = " + rot + ", ring = " + ring + ", off = " + offsets[normalize(i+rot-ring)] + ")");
        return normalize(i + offsets[normalize(i+rot-ring)]);
    }

    public int backward(int i, int rot) {
        int in = normalize(i+rot);
        for (int j = 0; j < offsets.length; j++) {
            if(normalize(j+offsets[normalize(j-ring)]) == in) {
                //System.out.println("Backward: " + (char)('a'+i) + " -> " + (char)('a'+normalize(j - rot)));
                return normalize(j - rot);
            }
        }
        System.out.println("An error occurred");
        return -1;
    }

    private int normalize(int i) {
        return (i + offsets.length*2) % offsets.length;
    }

}
