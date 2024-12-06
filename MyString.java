/**
 * A library of string functions.
 */
public class MyString {
    public static void main(String args[]) {
        // System.out.println(MyString.subsetOf("sap", "space"));
        // System.out.println(MyString.subsetOf("spa", "space"));
        // System.out.println(MyString.subsetOf("pass", "space"));
        // System.out.println(MyString.subsetOf("c", "space"));
        // System.out.println("..." + MyString.spacedString("foobar") + "...");
        // System.out.println(MyString.randomStringOfLetters(3));
        System.out.println(MyString.remove("meet", "committee"));
        // Put more tests of your own here.
    }

    /**
     * Returns the number of times the given character appears in the given string.
     * 
     * @param str - a string
     * @param c   - a character
     * @return the number of times c appears in str
     */
    public static int countChar(String str, char c) {
        int counter = 0;

        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == c) {
                counter++;
            }
        }
        return counter;
    }

    /**
     * Returns true if str1 is a subset string str2, false otherwise
     * Examples:
     * subsetOf("sap","space") returns true
     * subsetOf("spa","space") returns true
     * subsetOf("pass","space") returns false
     * subsetOf("c","space") returns true
     *
     * @param str1 - a string
     * @param str2 - a string
     * @return true is str1 is a subset of str2, false otherwise
     */
    public static boolean subsetOf(String str1, String str2) {
        for (int i = 0; i < str1.length(); i++) {
            char currentChar = str1.charAt(i);
            if (countChar(str1, currentChar) > countChar(str2, currentChar)) {
                return false;
            }
        }
        return true;
    }

    /**
     * Returns a string which is the same as the given string, with a space
     * character inserted after each character in the given string, except
     * for last character of the string, that has no space after it.
     * Example: if str is "silent", returns "s i l e n t".
     * 
     * @param str - a string
     * @return a string consisting of the characters of str, separated by spaces.
     */
    public static String spacedString(String str) {
        String newString = "";
        for (int i = 0; i < str.length(); i++) {
            newString += str.charAt(i);
            if (i < str.length() - 1) {
                newString += " ";
            }
        }
        return newString;
    }

    /**
     * Returns a string of n lowercase letters, selected randomly from
     * the English alphabet 'a', 'b', 'c', ..., 'z'. Note that the same
     * letter can be selected more than once.
     * 
     * Example: randomStringOfLetters(3) can return "zoo"
     * 
     * @param n - the number of letter to select
     * @return a randomly generated string, consisting of 'n' lowercase letters
     */
    public static String randomStringOfLetters(int n) {
        String newString = "";
        for (int i = 0; i < n; i++) {
            char rendomChar = (char) (Math.random() * 26 + 97);
            newString += rendomChar;
        }
        return newString;
    }

    /**
     * Returns a string consisting of the string str1, minus all the characters in
     * the
     * string str2. Assumes (without checking) that str2 is a subset of str1.
     * Example: remove("meet","committee") returns "comit"
     * 
     * @param str1 - a string
     * @param str2 - a string
     * @return a string consisting of str1 minus all the characters of str2
     */
    public static String remove(String str1, String str2) {
        String result = "";
        String helper = "";
        for (int i = 0; i < str1.length(); i++) {
            char c = str1.charAt(i);
            int totalToRemove = countChar(str2, c);
            int totalSkipped = countChar(helper, c);
            if (str2.indexOf(c) == -1 || totalSkipped == totalToRemove) {
                result += c;
            }
            helper += c;
        }
        return result;
    }
}
