package ExtendedEnigmaPlus;

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

    public void setRings(int[] rings) {
        for(int i = 0; i < rings.length; i++) {
            rotors.get(i).ring = rings[i];
        }
    }

    public int encode(int i) {
        rotate(0);
        //System.out.println("Input: " + (char)('a'+i));
        return encode(i, 0);
    }

    private void rotate(int r) {
        if(r == rotors.size()) return;
        if(rotors.get(r).turnover == rotations.get(r)) rotate(r+1);
        rotations.set(r, rotations.get(r)+1);
        if(rotations.get(r) == rotorSize) rotations.set(r, 0);
    }

    private int encode(int i, int pos) {
        if(pos == rotors.size()) return reflector.reflect(i);
        Rotor current = rotors.get(pos);
        int rot = rotations.get(pos);
        return current.backward(encode(current.forward(i, rot), pos+1), rot);
    }
}