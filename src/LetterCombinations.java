import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

/**
 * Given a string containing digits from 2-9 inclusive,
 * return all possible letter combinations that the number could represent.
 * Return the answer in any order.

 * Example1:
 *      Input: digits = "23"
 *      Output: ["ad","ae","af","bd","be","bf","cd","ce","cf"]

 * Example 2:
 *      Input: digits = ""
 *      Output: []

 * Example 3:
 *      Input: digits = "2"
 *      Output: ["a","b","c"]
 */
public class LetterCombinations {
    /**
     * A mapping of a digit to their letters in a phone.
     */
    static HashMap<Character, String> letters = new HashMap<>();

    static HashMap<String, List<String>> memo = new HashMap<>();

    static {
        letters.put('2', "abc");
        letters.put('3', "def");
        letters.put('4', "ghi");
        letters.put('5', "jkl");
        letters.put('6', "mno");
        letters.put('7', "pqrs");
        letters.put('8', "tuv");
        letters.put('9', "wxyz");
    }

    public List<String> letterCombinations(String digits) {
        return letterCombinations(digits, 0, digits.length() - 1);
    }

    private List<String> letterCombinations(String digits, int start, int end) {
        if (digits.isEmpty())
            return new LinkedList<>();

        if (start == end) {
            String mapping = letters.get(digits.charAt(start));
            List<String> result = new LinkedList<>();
            for (int i = 0; i < mapping.length(); i++) {
                result.add(String.valueOf(mapping.charAt(i)));
            }
            return result;
        }

        String substr = digits.substring(start, end + 1);
        if (memo.containsKey(substr))
            return memo.get(substr);

        int mid = (start + end) / 2;
        List<String> leftSubstr = letterCombinations(digits, start, mid);
        List<String> rightSubstr = letterCombinations(digits, mid + 1, end);
        List<String> result = combineSubstring(leftSubstr, rightSubstr);
        memo.put(substr, result);
        return result;
    }

    private List<String> combineSubstring(List<String> str1, List<String> str2) {
        List<String> result = new LinkedList<>();
        for (int i = 0; i < str1.size(); i++) {
            for (int j = 0; j < str2.size(); j++) {
                String sub = str1.get(i) + str2.get(j);
                result.add(sub);
            }
        }
        return result;
    }


    public static void main(String[] args) {
        LetterCombinations lcm = new LetterCombinations();
        System.out.println(letters.get('2'));
        System.out.println(lcm.letterCombinations("23456"));
        System.out.println(memo);
    }
}
