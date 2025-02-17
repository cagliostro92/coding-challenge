package edoardo.patti.leetcode;

import java.util.HashMap;

/**
 * <a href="https://leetcode.com/problems/two-sum/description/">Two sum</a>
 */
public class TwoSum {

  public static int[] twoSum(int[] nums, int target) {

    var dictionary = new HashMap<Integer, Integer>();

    for(int i = 0; i<nums.length; i++) {
      int complement = (target) - (nums[i]);
      if(dictionary.containsKey(complement)) {
        return new int[] {dictionary.get(complement), i};
      }
      dictionary.put(nums[i], i);
    }

    return new int[] {};
  }
}
