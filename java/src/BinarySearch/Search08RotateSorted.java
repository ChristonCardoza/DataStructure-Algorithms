package BinarySearch;

public class Search08RotateSorted {
/*
    arr[] = {7, 8, 9, 1, 2, 3, 4, 5, 6}
             0  1  2  3  4  5  6  7  8

     X = 1
     i = 3

     1) Identify the sorted part
     2) If not able to identify which part is sorted then shrink the array both side
     3) Apply BST
 */
    public static void main(String[] args) {

        int target = 1;

        int[] uniqueArr = {7, 8, 9, 1, 2, 3, 4, 5, 6};

        System.out.println(search(uniqueArr, target));

        int[] duplicateArr = {3, 1, 2, 3, 3 ,3, 3};

        System.out.println(search(duplicateArr, target));
    }

    public static int search(int[] nums, int target){

        int low = 0, high = nums.length-1;

        while(low <= high){

            int mid = low + (high-low)/2;

            if(nums[mid] == target) return mid;

            // Identify the sorted part

            if(nums[low] == nums[mid] && nums[mid] == nums[high]){
                // not possible to identify the sorted part, so shrinking

                low = low + 1;
                high = high - 1;

            }else if(nums[low]<= nums[mid]){
                // Left is sorted

                if(nums[low] <= target && nums[mid] >= target){
                    high = mid-1;
                } else {
                    low = mid + 1;
                }
            } else {
                // Right is sorted

                if(nums[mid] <= target && nums[high] >= target){
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            }
        }

        return -1;
    }
}
