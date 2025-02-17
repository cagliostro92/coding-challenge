package edoardo.patti.leetcode;

/**
 * <a href="https://leetcode.com/problems/longest-substring-without-repeating-characters/description/">Longest substring without repeating characters</a>
 */
public class LongestSubstringWithoutRepeatingCharacters {

  public static int lengthOfLongestSubstring(String s) {

    var sb = new StringBuilder();
    int previousCounter = 0;

    for(int i = 0; i<s.length(); i++) {
      if(sb.indexOf(String.valueOf(s.charAt(i))) != -1) {
        if(sb.length() > previousCounter)
          previousCounter = sb.length();
        sb.delete(0, sb.indexOf(String.valueOf(s.charAt(i)))+1);
      }
      sb.append(s.charAt(i));
    }
    return Math.max(sb.length(), previousCounter);
  }
}
