package ExtendedEnigmaPlus;

public class RotorGenerator {
    public static int[] generateRotor(int size, int key) {
        int[] l = new int[size];
        for (int i = 0; i < size; i++) {
            int temp = l[i%size];
            int val = getVal(size, key, i);
            l[i%size] = val + l[val] - i%size;
            l[val] = i%size + temp - val;
        }
        return l;
    }

    public static int[] generateReflector(int size, int key) {
        int[] l = new int[size];
        for (int i = 0; i < size; i++) {
            if(l[i] == 0) { //if a space is not rerouted
                for (int j = 0; j < 3; j++) { //check 3 times if a place to swap is rerouted
                    int swap = getVal(size, key,i + size * j);
                    if(l[swap] == 0) { //reroute
                        l[i] = swap - i;
                        l[swap] = i - swap;
                        break; //break the inner loop
                    }
                }
            }
        }
        return l;
    }

    private static int getVal(int size, int key, int i) {
        return (key/(i+1))%size;
    }

    //print a key and list
    public static void print(int key, int[] rot) {
        System.out.print(key + ": ");
        for(int i: rot) {
            System.out.print(i + ", ");
        }
        System.out.println();
    }

    //check if Rotor is valid
    public static boolean validateRotor(int[] list) {
        boolean[] check = new boolean[list.length];
        for (int i = 0; i < list.length; i++) {
            if(check[i + list[i]]) return false;
            else check[i + list[i]] = true;
        }
        for(boolean bool: check) {
            if(!bool) return false;
        }
        return true;
    }

    //check if Reflector is valid
    public static boolean validateReflector(int[] list) {
        boolean[] check = new boolean[list.length];
        for (int i = 0; i < list.length; i++) {
            if(!check[i]) {
                if(check[i + list[i]]) return false;
                else {
                    check[i] = true;
                    check[i + list[i]] = true;
                }
            }
        }
        for(boolean bool: check) {
            if(!bool) return false;
        }
        return true;
    }
}