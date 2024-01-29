package Enigma2;

import java.util.HashMap;

public class PlugBoard {
    HashMap<Character, Character> swap;

    public PlugBoard() {
        swap = new HashMap<>();
    }

    public char translate(char c) {
        if(swap.containsKey(c)) {
            return swap.get(c);
        }
        return c;
    }

    public void addSwap(char c1, char c2) {
        swap.put(c1,c2);
        swap.put(c2,c1);
    }

    public void addSwap(String s) {
        if(s.equals("")) return;
        String[] swaps = s.split(" ");
        for(String swap: swaps) {
            addSwap(swap.charAt(0), swap.charAt(1));
        }
    }
}
