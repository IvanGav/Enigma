package ExtendedEnigma;

public class Enigma {
    /*
    Third generation of my Enigma. Finally works like an actual Enigma. Can be easily configured and more flexibility with rotors, characters encoded, etc.
    */

    private String chars;
    private PlugBoard pb;
    private RotorBoard rb;

    public Enigma(String charList, String swaps, int[] reflectorConfig, int[][] rotorsConfig, int[] rotorsTurnover, int[] rotorRings, int[] rotorsRot) {
        chars = charList;
        pb = new PlugBoard();
        pb.addSwap(swaps);
        rb = new RotorBoard(chars.length());
        rb.setReflector(new Reflector(reflectorConfig));
        for(int i = 0; i < rotorsConfig.length; i++) {
            rb.addRotor(new Rotor(rotorsConfig[i], rotorsTurnover[i], rotorRings[i]));
        }
        setRotorsRotation(rotorsRot);
    }

    public Enigma(String charList, String swaps, int[] reflectorConfig, Rotor[] rotors, int[] rotorsRot) {
        chars = charList;
        pb = new PlugBoard();
        pb.addSwap(swaps);
        rb = new RotorBoard(chars.length());
        rb.setReflector(new Reflector(reflectorConfig));
        for(Rotor r: rotors) {
            rb.addRotor(r);
        }
        setRotorsRotation(rotorsRot);
    }

    //rotate the Rotors to the specified position
    public void setRotorsRotation(int[] rotations) {
        rb.configure(rotations);
    }

    //set ring setting of all rotors to specified
    public void setRotorRings(int[] rings) {
        rb.setRings(rings);
    }

    //reset letter swaps to specified
    public void setSwaps(String swaps) {
        pb.clearSwaps();
        pb.addSwap(swaps);
    }

    //encode a String
    public String encode(String s) {
        String encoded = "";
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if(chars.contains(Character.toString(c))) encoded += encode(c);
            else encoded += c;
        }
        return encoded;
    }

    //encode a letter and pass through the PlugBoard
    private char encode(char c) {
        int i = chars.indexOf(pb.translate(c)); //get a number corresponding to a (translated through plugboard) value
        return pb.translate(chars.charAt(encode(i))); //return (through plugboard) character at number encoded for i
    }

    //encode a number through RotorBoard
    private int encode(int i) {
        return rb.encode(i);
    }
}
