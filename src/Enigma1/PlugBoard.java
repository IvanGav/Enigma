package Enigma1;

import java.util.HashMap;

public class PlugBoard {
    HashMap<Character, Character> swap;
    public PlugBoard() {
        swap = new HashMap<>();
    }
    public char translate(char c) {
        if(swap.containsKey(c)) {
            //System.out.println("- Swap of " + c + " for " + swap.get(c));
            return swap.get(c);
        }
        return c;
    }
    public void addSwap(char c1, char c2) {
        swap.put(c1,c2);
        swap.put(c2,c1);
    }
}
