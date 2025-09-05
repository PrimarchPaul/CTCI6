/*

Implement an algorithm to determine if a string has all unique characters. What if you
could not use additional data structures?

*/

class CTCI61a{
    
    public static void main(String[] args){
        if(args.length.isEmpty() || (args[0].equals("CTCI61a") && args[1].equals("-h"))){
            system.out.print("Format: CTCI61a -functionName -string")
        }

        if(args.length > 3){
            system.out.print("Too many arguments. Format: CTCI61a -functionName -string");
        }

        if(args.length < 3){
            system.out.print("Too few arguments. Format: CTCI61a -functionName -word");
        }

        if(!args[0].equals("CTCI61a")){
            system.out.print("Could not find " + args[0] + " in this directory");
        }

        
    }

    //using a hashmap (HM), we can confirm uniquesness within a string by checking if a character in a string existed before
    //lookup time in a HM is o(1), memory is o(n) which is the length of the array, overall run time is average o(n)
    public static boolean isUniqueHM(string word){

        HashMap<Character, Integer> hm = new HashMap<>();

        for(int i = 0; i < word.length(); i++){
            if(hm.containsKey(word.charAt(i))){
                return false;
            }

            hm.put(word.charAt(i), 1);
        }

        return true;
    }

    //characters in a string relate to a number, called ASCII
    //We can check for uniquess by just referencing an array the size of 26 (the amt of letters in the english language) for a previous existence
    //time is o(n), space is o(26), which is the number of letters in the english alphabet
    public static boolean isUniqueArray(string word){
        int[] letters = new int[26];

        for(int i = 0; i < word.length(); i++){

            int letter = word.charAt(i).toLowerCase() - 'a';

            if(letters[letter] == 1){
                return false;
            }

            letters[letter] = 1;
        }

        return true;
    }

    //the slowest response but most memory efficient. Take one letter, compare it to the rest of the letters
    //time is o(n^2), space is o(1)
    public static boolean isUniqueNoDs(string word){

        for(int i = 0; i < word.length(); i++){
            for(int j = i+1; j < word.length(); j++){
                if(word[i] == word[j]){
                    return false;
                }
            }
        }

        return true;
    }

    //an optimized approach for memory efficiency. Sort the letters, then compare the letters side by side
    //time is o(nlogn), space is o(1)
    public static boolean isUniqueSorting(string word){
        if(word.length() == 1){
            return true;
        }
        char[] wordArray = word.toCharArray();
        Arrays.sort(wordArray);

        for(int i = 1; i < word.length(); i++){
            if(wordArray[i] == wordArray[i-1]){
                return false;
            }
        }

        return true;
    }
}