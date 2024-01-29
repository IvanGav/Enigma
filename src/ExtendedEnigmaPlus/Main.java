package ExtendedEnigmaPlus;

public class Main {
    static String charsExtendedPlus = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz,.?!()[]{}1234567890-_=+@#$%^&*\\|/<>`~;:'\" ";
    static String charsExtended = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz,.?!";
    static String chars = "abcdefghijklmnopqrstuvwxyz";

    static int[] rotor1path = new int[]{4, 9, 10, 2, 7, 1, -3, 9, 13, 16, 3, 8, 2, 9, 10, -8, 7, 3, 0, -4, -20, -13, -21, -6, -22, -16};
    static int[] rotor2path = new int[]{0, 8, 1, 7, 14, 3, 11, 13, 15, -8, 1, -4, 10, 6, -2, -13, 0, -11, 7, -6, -5, 3, -17, -2, -10, -21};
    static int[] rotor3path = new int[]{1, 2, 3, 4, 5, 6, -4, 8, 9, 10, 13, 10, 13, 0, 10, -11, -8, 5, -12, -19, -10, -9, -2, -5, -8, -11};
    static int[] reflectorApath = new int[]{4, 8, 10, 22, -4, 6, 18, 16, 13, -8, 12, -6, -10, 4, 2, 5, -2, -4, 1, -1, -5, -13, -12, -16, -18, -22};
    static int[] reflectorBpath = new int[]{24, 16, 18, 4, 12, 13, 5, -4, 7, 14, 3, -5, 2, -3, -2, -7, -12, -16, -13, 6, -18, 1, -1, -14, -24, -6};
    static int[] reflectorCpath = new int[]{5, 20, 13, 6, 4, -5, 8, 17, -4, -6, 7, 14, 11, 9, -8, -13, 3, -7, 2, -3, -2, -20, -9, -11, -17, -14};

    static Rotor rotor1 = new Rotor(rotor1path, 16, 0);
    static Rotor rotor2 = new Rotor(rotor2path, 4, 0);
    static Rotor rotor3 = new Rotor(rotor3path, 21, 0);

    public static void main(String[] args) {
        Enigma e = new Enigma(
                chars,
                "",
                reflectorBpath,
                new Rotor[] {rotor3, rotor2, rotor1},
                new int[]{0, 0, 0}
        );
        Enigma ie = new Enigma(
                charsExtendedPlus,
                "ab Fh Jr (g ke tG n* %. oO",
                new Reflector(RotorGenerator.generateReflector(charsExtendedPlus.length(), 10485715)),
                new Rotor[] {
                        new Rotor(RotorGenerator.generateRotor(charsExtendedPlus.length(), 48664105), 31, 4),
                        new Rotor(RotorGenerator.generateRotor(charsExtendedPlus.length(), 574185068), 2, 8),
                        new Rotor(RotorGenerator.generateRotor(charsExtendedPlus.length(), 47583051), 19, 31)},
                new int[]{5, 41, 2}
        );
        test(ie, "Why, hello world? I mean, this is just a phrase I'm writing on the go so it will not have any real meaning.");
    }

    public static void test(Enigma e, String str) {
        e.setRotorsRotation(new int[]{0,0,0});
        String encoded = e.encode(str);
        e.setRotorsRotation(new int[]{0,0,0});
        String decoded = e.encode(encoded);
        System.out.println("\"" + decoded + "\" -> \"" + encoded + "\"");
    }
}