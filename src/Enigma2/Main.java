package Enigma2;

public class Main {
    public static void main(String[] args) {
        Enigma e = new Enigma();
        System.out.println(e.encode("hello world!"));
    }
}
