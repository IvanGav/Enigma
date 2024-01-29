package ExtendedEnigma;

public class Main {
    static String charsExtended = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz,.?! ";
    static String chars = "abcdefghijklmnopqrstuvwxyz";

    static int[] rotor1 = new int[]{4, 9, 10, 2, 7, 1, -3, 9, 13, 16, 3, 8, 2, 9, 10, -8, 7, 3, 0, -4, -20, -13, -21, -6, -22, -16};
    static int[] rotor2 = new int[]{0, 8, 1, 7, 14, 3, 11, 13, 15, -8, 1, -4, 10, 6, -2, -13, 0, -11, 7, -6, -5, 3, -17, -2, -10, -21};
    static int[] rotor3 = new int[]{1, 2, 3, 4, 5, 6, -4, 8, 9, 10, 13, 10, 13, 0, 10, -11, -8, 5, -12, -19, -10, -9, -2, -5, -8, -11};
    static int[] reflectorA = new int[]{4, 8, 10, 22, -4, 6, 18, 16, 13, -8, 12, -6, -10, 4, 2, 5, -2, -4, 1, -1, -5, -13, -12, -16, -18, -22};
    static int[] reflectorB = new int[]{24, 16, 18, 4, 12, 13, 5, -4, 7, 14, 3, -5, 2, -3, -2, -7, -12, -16, -13, 6, -18, 1, -1, -14, -24, -6};
    static int[] reflectorC = new int[]{5, 20, 13, 6, 4, -5, 8, 17, -4, -6, 7, 14, 11, 9, -8, -13, 3, -7, 2, -3, -2, -20, -9, -11, -17, -14};
    static int[] reflectorUKW = new int[]{16, 23, 5, 11, 2, 8, -2, -5, 13, 6, 10, 14, 7, -8, -11, -6, -16, 6, 4, -7, -10, -13, -4, -6, -23, -14};

    static Rotor r1 = new Rotor(rotor1, 16, 0);
    static Rotor r2 = new Rotor(rotor2, 4, 0);
    static Rotor r3 = new Rotor(rotor3, 21, 0);

    public static void main(String[] args) {
        RotorGenerator g = new RotorGenerator(chars.length());

        Enigma e = new Enigma(
                chars,
                "",
                reflectorB,
                new Rotor[] {r3, r2, r1},
                new int[]{0, 0, 0}
        );
        test(e, "Hello World, This is a Wonderful Day!");
        test(e, "hello world, this is a wonderful day!");
        test(e, "aaaaaaaaaaaaaaaaaaaaaaaaaAAAAAAAAAAAAAAAAAAAAAA");
        test(e, "(UwU)");
        test(e, "GCDSE AHUGW TQGRK VLFGX UCALX VYMIG MMNMF DXTGN VHVRM MEVOU YFZSL RHDRR XFJWC FHUHM UNZEF RDISI KBGPM YVXUZ".toLowerCase());
    }

    public static void test(Enigma e, String str) {
        e.setRotorsRotation(new int[]{0,0,0});
        String encoded = e.encode(str);
        e.setRotorsRotation(new int[]{0,0,0});
        String decoded = e.encode(encoded);
        System.out.println("\"" + decoded + "\" -> \"" + encoded + "\"");
    }
}
