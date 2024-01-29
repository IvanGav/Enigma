package ExtendedEnigma;

public class Test {
    public static void main(String[] args) {
        RotorGenerator g = new RotorGenerator(50);
        for (int i = 0; i < 100; i++) {
            int key = (int)(Math.random()*1000000);
            RotorGenerator.print(key, g.generateRotor(key));
        }
    }
}
