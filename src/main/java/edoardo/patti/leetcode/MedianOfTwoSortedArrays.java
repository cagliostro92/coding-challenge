package edoardo.patti.leetcode;

/**
 * <a href="https://leetcode.com/problems/median-of-two-sorted-arrays/description/">Median of two sorted arrays</a>
 */
public class MedianOfTwoSortedArrays {

  /**
   * Given two sorted arrays nums1 and nums2 of size m and n respectively, return the median of the two sorted arrays.
   * The overall run time complexity should be O(log (m+n)).
   * complexity=O(log(m+n)) This means complexity grows at most logarithmically in m+n.
   * @param nums1 first sorted array
   * @param nums2 second sorted array
   * @return the median of the two sorted arrays
   */
  public static double findMedianSortedArrays(int[] nums1, int[] nums2) {

    var totalLength = nums1.length + nums2.length;
    var isEven = totalLength %2 == 0;
    var firstAddendIndex = 0;
    var firstAddend = 0;
    var secondAddendIndex = 0;
    var secondAddend = 0;
    if(!isEven)
      firstAddendIndex = totalLength / 2;
    else {
      firstAddendIndex = (totalLength / 2) - 1;
      secondAddendIndex = totalLength / 2;
    }

    for(int i = 0, j = 0, x = 0; ;){
      var n1 = i < nums1.length ? nums1[i] : Integer.MAX_VALUE;
      var n2 = j < nums2.length ? nums2[j] : Integer.MAX_VALUE;

      if(x == firstAddendIndex) {
        firstAddend = Math.min(n1, n2);
        if(!isEven)
          break;
      }
      if(x == secondAddendIndex && isEven) {
        secondAddend = Math.min(n1, n2);
        break;
      }
      if(n1 < n2) {
        i++;
        x++;
      }
      else if(n2 < n1) {
        j++;
        x++;

      }
      else {
        i++;
        j++;
        x++;
        if(x == firstAddendIndex) {
          firstAddend = n1;
          if(!isEven)
            break;
        }
        if(x == secondAddendIndex) {
          secondAddend = n1;
          break;
        }
        x++;
      }
    }
    return isEven ? (double) ((firstAddend) + (secondAddend)) / 2 : firstAddend;

  }
}
