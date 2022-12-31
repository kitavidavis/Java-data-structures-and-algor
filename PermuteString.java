package strings;

/*
 * Backtracking algorithm used in the program:-
 * >> Fix a character in the first position and swap the rest of the character with the
 * first character.
 * Like in ABC, in the first iteration three strings are formed: ABC, BAC and CBA by swapping A with
 * A, B and C respectively.
 * >> Repeat step 1 for the rest of the characters like fixing second character B and so on.
 * >> Now swap again to go back to the previous position e.g from ABC, we formed ABC by fixing B again,
 * and we backtrack to the previous position and swap B with C. So, now we got ABC and ACB.
 * >> Repat these steps for BAC and CBA to get all the permutations. 
 */

public class PermuteString {
    public static String swapString(String a, int i, int j) {
        char[] b = a.toCharArray();
        char ch;
        ch = b[i];
        b[i] = b[j];
        b[j] = ch;

        return String.valueOf(b);
    }

    public static void main(String[] args){
        String str = "ABC";
        int len = str.length();
        System.out.println("All the permutations of the string are:");
        generatePermutation(str, 0, len);
    }

    public static void generatePermutation(String str, int start, int end) {
        if(start == end - 1){
            System.out.println(str);
        } else {
            for(int i=start; i< end; i++){
                str = swapString(str, start, i);
                generatePermutation(str, start + 1, end);
                str = swapString(str, start, i);
            }
        }
    }
}
