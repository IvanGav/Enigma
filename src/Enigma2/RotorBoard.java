package Enigma2;

import java.util.ArrayList;

public class RotorBoard {
    int rotorSize;
    ArrayList<Rotor> rotors;
    ArrayList<Integer> rotations;
    Reflector reflector;

    public RotorBoard(int rotorSize) {
        this.rotorSize = rotorSize;
        rotors = new ArrayList<>();
        rotations = new ArrayList<>();
    }

    public void setReflector(Reflector r) {
        reflector = r;
    }

    public void addRotor(Rotor r) {
        rotors.add(r);
        rotations.add(0);
    }

    public void configure(int[] rots){
        rotations.clear();
        for(int r: rots) {
            rotations.add(r);
        }
    }

    public int encode(int i) {
        rotate(0);
        return encode(i, 0);
    }

    private void rotate(int r) {
        if(r == rotors.size()) return;
        rotations.set(r, rotations.get(r)+1);
        if(rotations.get(r) < rotorSize) return;
        rotations.set(r, 0);
        rotate(r+1);
    }

    private int encode(int i, int pos) {
        if(pos == rotors.size()) return reflector.reflect(i);
        Rotor current = rotors.get(pos);
        int rot = rotations.get(pos);
        return current.backward(encode(current.forward(i, rot), pos+1), rot);
    }
}
