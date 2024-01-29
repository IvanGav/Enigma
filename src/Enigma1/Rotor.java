package Enigma1;

public class Rotor {
    Rotor next;
    int rotation;
    int[] offsets;
    public Rotor(int[] l, int rot, Rotor n) {
        rotation = rot;
        offsets = l;
        next = n;
    }

    public int start(int c) {
        rotate();
        return encode(c);
    }

    public int encode(int c) {
        if(next == null) return backward(forward(c)+offsets.length/2); //reflector imitation if none added
        return backward(next.encode(forward(c)));
    }

    public void rotate() {
        rotation++;
        if(rotation == offsets.length) {
            rotation = 0;
            if(next != null) next.rotate();
        }
    }

    private int forward(int c) {
        return normalize(c + offsets[relativePosition(c)]);
    }

    private int backward(int c) {
        int in = relativePosition(c);
        for (int i = 0; i < offsets.length; i++) {
            if(i+offsets[i] == in) return normalize(i + rotation);
        }
        System.out.println("An error occurred");
        return -1;
    }

    private int relativePosition(int c) {
        return normalize(c-rotation);
    }

    private int normalize(int c) {
        return (c+offsets.length)%offsets.length;
    }
}
