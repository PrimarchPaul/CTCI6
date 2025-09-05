import java.util.HashMap;
/*
 

    Check Permutation: Given two strings, write a method to decide if one is a permutation of the other
    Assuming the 


 */


 class CTCI61b{


    //Space oriented design. Using a hashmap to determine if the two strings are permutations
    //time is o(m+n), space is o(n);
    public static boolean permutationHm(String word1, String word2){
        if(word1.length() != word2.length()){
            return false;
        }

        HashMap<Character, Integer> hm = new HashMap<>();

        char[] word1Arr = word1.toCharArray();
        char[] word2Arr = word2.toCharArray();

        for(char letter : word1Arr){
            hm.put(letter, hm.getOrDefault(letter, 0) + 1);
        }

        for(char letter2 : word2Arr){
            if(!hm.containsKey(letter2)){
                return false;
            }else if(hm.get(letter2) == 0){
                return false;
            }

            hm.put(letter2, hm.get(letter2)-1);
        }

        return true;
    }

    //optimized space oriented design, using a char array to determine if the two strings are permutations
    //time is o(m+n), space is o(26)
    //this is assuming that the words are only containing lowercase letters
    //symbols, digits, and Uppercase letters must be handled with a bigger array

    public static boolean permutationArr(String word1, String word2){

        if(word1.length() != word2.length()){
            return false;
        }

        int[] letters = new int[26];

        char[] word1Arr = word1.toCharArray();
        char[] word2Arr = word2.toCharArray();

        for(char letter : word1Arr){
            letters[letter-'a']++;
        }

        for(char letter2 : word2Arr){
            if(letters[letter2-'a'] == 0){
                return false;
            }

            letters[letter2-'a']--;
        }

        return true;
    }

}