import java.util.List;

public class Solution {

//PROBLEM
//longest palindromic substring: Given a string, find the longest substring which is palindrome.
//
//Input: abac
//output: aba
//
//Input: tacag
//output:  aca
//
//Input: wegeeksskeegyuwe,
//Output: "geeksskeeg"

    public static void main(String[] args) {
         List.of("abac", "tacag", "geeksskeeg")
             .stream().forEach(input -> System.out.println(getLongestPalindromic(input)));
    }

    private static String getLongestPalindromic(String word) {
        if (word.length() <= 1) //if size if one or less return itself.
            return word;

        String longestPalindromic = "";

        for (int i = 1; i < word.length(); i++) {

            // check when is odd
            int start = i;
            int end = i;
            while(isEquals(word, start, end)) {
                start--;
                end++;

                //check achieve limit of string
                if (start == -1 || end == word.length())
                    break;
            }

            String palindrome = word.substring(start+1, end);
            if (palindrome.length() > longestPalindromic.length()) {
                longestPalindromic = palindrome;
            }

            // check when is even
            start = i-1;
            end = i;
            while(isEquals(word, start, end)) {
                start--;
                end++;

                //check achieve limit of string
                if (start == -1 || end == word.length())
                    break;
            }

            palindrome = word.substring(start+1, end);

            //get the longest one
            if (palindrome.length() > longestPalindromic.length()) {
                longestPalindromic = palindrome;
            }
        }

        return longestPalindromic;
    }

    private static boolean isEquals(String word, int start, int end) {
        return word.charAt(start) == word.charAt(end);
    }
}
