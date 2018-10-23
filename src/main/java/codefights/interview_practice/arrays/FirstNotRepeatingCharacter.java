package codefights.interview_practice.arrays;

import java.util.Arrays;

public class FirstNotRepeatingCharacter {
    public static void main(String[] args) {
        System.out.println(firstNotRepeatingCharacter("ngrhhqbhnsipkcoqjyviikvxbxyphsnjpdxkhtadltsuxbfbrkof"));
    }

    public static char firstNotRepeatingCharacter(String s) {
        //use the busket sort method
        Integer[] busket = new Integer[26];
        Arrays.fill(busket, 0);
        for (char c : s.toCharArray()) {
            busket[c - 'a']++;
        }

        //loop as the string order
        //1.get char
        //2.get char's value in busket
        //3.equals(1) output else continue
        for (char c : s.toCharArray()) {
            if (busket[(int) (c - 'a')].equals(1)) {
                return c;
            }
        }

        return '_';
    }

    public static void my() {
        Character result = ' ';
        String input = "abacabaabacaba";
        for (int i = 0; i < input.length(); i++) {
            Character index = input.charAt(i);
            //use the index of char represent it's value
            if (input.lastIndexOf(index) == i) {
                result = index;
                break;
            }
        }
        if (result.equals(new Character(' '))) {
            result = '_';
        }
        System.out.println(result);
    }
}
