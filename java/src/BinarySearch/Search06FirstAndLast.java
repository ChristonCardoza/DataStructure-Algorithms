package BinarySearch;

public class Search06FirstAndLast {
/*
    arr[] = { 2, 4, 6, 8, 8, 8, 11, 13 }
              0  1  2  3  4  5   6   7

    X = 8    X = 10    X = 11
    {3, 5}   {-1, -1}  {6, 6}
*/
    public static void main(String[] args) {

        int[] arr = {2, 4, 6, 8, 8, 8, 11, 13};
        int target = 10;

        int [] brute = bruteforce(arr, target);
        System.out.printf("Bruteforce Approach: {%d, %d}%n", brute[0], brute[1]);

        int [] firstLast = getFirstLast(arr, target);
        System.out.printf("BinarySearch Approach: {%d, %d}", firstLast[0], firstLast[1]);
    }

    public static int[] bruteforce(int[] nums, int target) {

        int first = -1, last = -1;

        for(int i=0; i<nums.length; i++){

            if(nums[i] == target){

                if(first == -1) first = i;

                last = i;
            }
        }

        return new int[]{first, last};
    }

    public static int[] getFirstLast(int[] nums, int target){

        int n = nums.length;
        int lb = getLowerBound(nums, target);

        if(lb == n || nums[lb] != target){
            return new int[]{-1, -1};
        }

        int up = getUpperBound(nums, target);

        return new int[]{lb, up-1};
    }

    public static int getUpperBound(int[] nums, int target){

        int ub = nums.length;
        int low=0, high = nums.length-1;

        while(low<=high){

            int mid = low + (high-low)/2;

            if(nums[mid] > target){
                ub = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return ub;
    }

    public static int getLowerBound(int[] nums, int target){

        int lb = nums.length;
        int low=0, high = nums.length-1;

        while(low<=high){

            int mid = low + (high-low)/2;

            if(nums[mid] >= target){
                lb = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return lb;
    }
}
