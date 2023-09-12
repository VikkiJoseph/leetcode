import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Minimum Deletions to make character frequencies unique.
 * A string s is called good if there are no two different characters in s that have the same frequency.
 * Given a string s, return the minimum number of characters you need to delete to make s good.
 * The frequency of a character in a string is the number of times it appears in the string. For example, in the string "aab", the frequency of 'a' is 2, while the frequency of 'b' is 1.
 * @author JosephMiriyala
 */
public class LeetCode1647 {
    public static void main(String[] args) {
        System.out.println(minDeletions("aab"));
        System.out.println(minDeletions("aaabbbcc"));
        System.out.println(minDeletions("ceabaacb"));
    }

    /**
     * Finds the minimum deletions to be for the string.
     * @param s
     * @return
     */
    public static int minDeletions(String s) {
        Map<Character, Integer> frequencyMap = new HashMap<>();
        for(char c : s.toCharArray()) {
            frequencyMap.put(c, frequencyMap.getOrDefault(c, 0) + 1);
        }
        Set<Integer> seen = new HashSet<>();
        int deletions = 0;
        for(int freq : frequencyMap.values()) {
            while(seen.contains(freq)) {
                freq--;
                deletions++;
            }
            // Don't add zero frequencies to the seen set.
            if (freq != 0) {
                seen.add(freq);
            }
        }
        return deletions;
    }
}
