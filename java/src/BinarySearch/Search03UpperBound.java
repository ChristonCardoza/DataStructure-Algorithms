package BinarySearch;

public class Search03UpperBound {
    /*
        Upper Bound is small index such that arr[index] > X

        arr[] = { 2, 3, 6, 7, 8, 8, 11, 11, 11, 12 }
                  0  1  2  3  4  5   6   7   8   9

          X = 6   X = 11   X = 13  X = 0
          lb = 3  lb = 9  lb = 10  lb = 0
    */

    public static void main(String[] args) {

        int[] arr = { 2, 3, 6, 7, 8, 8, 11, 11, 11, 12 };
        int target = 0;

        System.out.println(getUpperBound(arr, target));
    }

    public static int getUpperBound(int[] nums, int target){

        int low = 0, high = nums.length - 1;
        int ans = nums.length;

        while( low <= high){

            int mid = low + (high-low)/2;

            if(nums[mid] > target) {
                ans = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return ans;
    }
}
