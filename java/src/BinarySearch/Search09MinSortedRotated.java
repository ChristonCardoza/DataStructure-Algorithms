package BinarySearch;

public class Search09MinSortedRotated {
/*
  arr[] = {4, 5, 6, 7, 0, 1, 2} => 0
  arr[] = {7, 8, 1, 2, 3, 4, 5, 6} => 1
  arr[] = {3, 1, 2, 3, 3 ,3, 3} => 1
*/
    public static void main(String[] args) {

        int[] arr1 = {4, 5, 6, 7, 0, 1, 2};
        int[] arr2 = {7, 8, 1, 2, 3, 4, 5, 6};
        int[] arr3 = {3, 1, 2, 3, 3 ,3, 3};

        System.out.println(getMin(arr1));
        System.out.println(getMin(arr2));
        System.out.println(getMin(arr3));
    }

    public static int getMin(int[] nums) {

        int min = Integer.MAX_VALUE;
        int low = 0, high = nums.length-1;

        while(low<=high){

            // if search space is already sorted then nums[low] is min
            if(nums[low]<nums[high]){
                min = Math.min(min, nums[low]);
                break;
            }

            int mid = low + (high-low)/2;
            min = Math.min(min, nums[mid]);

            if(nums[low] == nums[mid] && nums[mid] == nums[high]){
                // shrink
                low++;
                high--;
                continue;
            }

            if(nums[low]<=nums[mid]){
                // if left is sorted
                low = mid + 1;
            }else {
                // right is sorted
                high = mid - 1;
            }
        }

        return min;
    }
}
