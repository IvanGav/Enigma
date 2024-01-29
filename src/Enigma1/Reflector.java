package Enigma1;

public class Reflector extends Rotor {
    public Reflector(int[] l) {
        super(l,0,null);
    }

    @Override
    public int encode(int c) {
        return (c + offsets[c] + rotation + offsets.length)%offsets.length;
    }

    @Override
    public void rotate() { }
}
