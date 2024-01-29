package Enigma1;

public class Enigma {
    /*
    This is my first take on enigma. It stores first rotor and just tells it to encode a letter. No option to configure yet implemented.
     */
    String extendedChars = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz ,.?!";
    String chars = "abcdefghijklmnopqrstuvwxyz";
    PlugBoard l;
    Rotor r;
    int[] rotor1 = new int[]{4, 9, 10, 2, 7, 1, -3, 9, 13, 16, 3, 8, 2, 9, 10, -8, 7, 3, 0, -4, -20, -13, -21, -6, -22, -16};
    int[] rotor2 = new int[]{0, 8, 1, 7, 14, 3, 11, 13, 15, -8, 1, -4, 10, 6, -2, -13, 0, -11, 7, -6, -5, 3, -17, -2, -10, -21};
    int[] rotor3 = new int[]{1, 2, 3, 4, 5, 6, -4, 8, 9, 10, 13, 10, 13, 0, 10, -11, -8, 5, -12, -19, -10, -9, -2, -5, -8, -11};
    int[] reflectorA = new int[]{4, 8, 10, 22, -4, 6, 18, 16, 13, -8, 12, -6, -10, 4, 2, 5, -2, -4, 1, -1, -5, -13, -12, -16, -18, -22};
    int[] reflectorB = new int[]{24, 16, 18, 4, 12, 13, 5, -4, 7, 14, 3, -5, 2, -3, -2, -7, -12, -16, -13, 6, -18, 1, -1, -14, -24, -6};
    int[] reflectorC = new int[]{5, 20, 13, 6, 4, -5, 8, 17, -4, -6, 7, 14, 11, 9, -8, -13, 3, -7, 2, -3, -2, -20, -9, -11, -17, -14};
    int[] reflectorUKW = new int[]{16, 23, 5, 11, 2, 8, -2, -5, 13, 6, 10, 14, 7, -8, -11, -6, -16, 6, 4, -7, -10, -13, -4, -6, -23, -14};

    public Enigma() {
        l = new PlugBoard();
        r = new Rotor(rotor1,0, new Rotor(rotor2, 0, new Rotor(rotor3, 0, new Reflector(reflectorB))));
        l.addSwap('o','c');
    }

    public int encode(int i) {
        return r.start(i);
    }

    public char encode(char c) {
        int i = chars.indexOf(l.translate(c)); //get a number corresponding to a (translated through plugboard) value
        return l.translate(chars.charAt(encode(i))); //return (through plugboard) character at number encoded for i
    }
    public String encode(String s) {
        s = s.toLowerCase();
        String encoded = "";
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if(chars.contains(Character.toString(c))) encoded += encode(c);
            else encoded += c;
        }
        return encoded;
    }
}
