package BinarySearch;

public class Search02lowerBound {

/*
    Lower Bound is small index such that arr[index] >= X

    arr[] = { 3, 5, 8, 15, 19 }
              0  1  2   3   4

      X = 8   X = 9   X = 16  X = 20
      lb = 2  lb = 3  lb = 4  lb = Least HypotheticalIndex ie 5
*/

    public static void main(String[] args) {

        int [] arr = { 3, 5, 8, 15, 19 };

        int x = 20;

        System.out.println("Bruteforce Approach: " + bruteforce(arr, x));

        System.out.println("BinarySearch Approach: " + getLowerBound(arr, x));

    }

    public static int bruteforce(int[] nums, int target){

        int n = nums.length -1;
        int ans = n + 1;

        for(int i =0; i<=n; i++){

            if(nums[i] >= target){
                ans = i;
                break;
            }
        }

        return ans;
    }

    public static int getLowerBound(int[] nums, int target){

        int ans = nums.length;

        int low = 0, high = nums.length-1;

        while(low <= high){

            int mid = low + (high-low)/2;

            if(nums[mid] >= target){
                ans = mid;
                high = mid-1;
            } else {
                low = mid + 1;
            }
        }

        return ans;

    }
}
