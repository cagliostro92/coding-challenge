package edoardo.patti.leetcode;

/**
 * <a href="https://leetcode.com/problems/longest-palindromic-substring/description/">Longest palindromic substring</a>

 * constant time information:
 * s.length
 * s[i]
 *
 * constraints:
 * result must be as long as possible
 *
 * edge cases:
 * s.length == 1 in this case result = s
 * result starts at s[0] and ends at s[length-1]
 *
 * remaining cases:
 * result[start] = s[0] && result[finish] = s[n]
 * result[start] = s[m] && result[finish] = s[n]
 * result[start] = s[n] && result[finish] = s[s.length-1]
 *
 * visualization:
 * b a b a d -> result starts at s[0] and ends at s[n]
 * x a a b d -> result starts at s[m] and ends at s[n]
 * c c b b b d d d d -> result starts at s[n] and ends at s[length-1]
 *
 * steps:
 * 1) looking for the central part of a palindromic substring (aBBa or AbA)
 * 2) add chars to right and to left until possible and until is still palindromic
 * 3) return the longest substring found
 */
public class LongestPalindromicSubstring {

  public static String longestPalindrome(String s) {

    var result = "";
    //edge cases
    if(s.length() == 1) return s.charAt(0)+"";
    if(s.length() == 2) return isPalindrome(s) ? s : s.charAt(0)+"";
    if(shouldCheck(s) && isPalindrome(s)) return s;

    for(int i = 0; i < s.length(); i++) {
      var substring = "";
      if(i > 0){
        //check two equal consecutive chars pattern
        if(s.charAt(i-1) == s.charAt(i)) {
          int ii = i-2;
          int j = i+1;
          substring = s.substring(i - 1, i + 1);
          var shouldContinue = true;
          //add chars until is possible and until is still palindrome
          while(shouldContinue) {
            if(ii >= 0 && j < s.length()) {
              var x = s.charAt(ii) + substring + s.charAt(j);
              if(isPalindrome(x)) {
                substring = x;
                ii--;
                j++;
              } else shouldContinue = false;
            } else{
              shouldContinue = false;
            }
          }
        }
      }
      if(result.length() < substring.length())
        result = substring;
      if(i+2 < s.length()) {
        // check two equals chars divided by exactly one char pattern
        if(s.charAt(i) == s.charAt(i+2)){
          int ii = i-1;
          int j = i+3;
          substring = s.substring(i, i + 3);
          var shouldContinue = true;
          //add chars until is possible and until is still palindrome
          while(shouldContinue) {
            if(ii >= 0 && j < s.length()) {
              var x = s.charAt(ii) + substring + s.charAt(j);
              if(isPalindrome(x)) {
                substring = x;
                ii--;
                j++;
              } else shouldContinue = false;
            } else{
              shouldContinue = false;
            }
          }
        }
      }
      if(result.length() < substring.length())
        result = substring;
    }
    return result.isBlank() ? s.charAt(0)+"" : result;
  }

  // avoid useless loop
  private static boolean shouldCheck(String s) {
    if(s.length()<2) return false;
    if(s.length() == 2) return s.charAt(0) == s.charAt(1);
    if(s.length()>200 && !isPalindrome(s.substring(0,50)+s.substring(s.length()-50))){
      return false;
    }
    if(s.length() % 2 == 0) {
      return s.charAt((s.length()/2) -1)  == s.charAt(s.length()/2);
    }
    return s.charAt((s.length()/2) -1) == s.charAt((s.length()/2) + 1);
  }

  private static boolean isPalindrome(String s) {
    if(s.length() < 2) return false;
    for(int i = 0, j = s.length()-1; i<s.length() && j > 0; i++, j-- ) {
      if(s.charAt(i) != s.charAt(j)) return false;
    }
    return true;
  }

}