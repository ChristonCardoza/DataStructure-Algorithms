package BinarySearch;

public class Search07NoOccurrences {
/*
    arr[] = { 2, 4, 6, 8, 8, 8, 11, 13 }
              0  1  2  3  4  5   6   7

    X = 8   {3, 5} 5-3+1 = 3
*/

    public static void main(String[] args) {

        int[] arr = {2, 4, 6, 8, 8, 8, 11, 13};
        int target = 11;

        int first = getFirst(arr, target);
        int last = getLast(arr, target);

        System.out.println(last - first + 1);
    }

    public static int getFirst(int[] nums, int target){

        int first = -1;
        int low = 0, high = nums.length - 1;

        while(low<=high){

            int mid = low + (high-low)/2;

            if(nums[mid] == target){
                first = mid;
                high = mid - 1;
            } else if(nums[mid] > target){
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return first;
    }

    public static int getLast(int[] nums, int target){

        int last = -1;
        int low = 0, high = nums.length - 1;

        while(low<=high){

            int mid = low + (high-low)/2;

            if(nums[mid] == target){
                last = mid;
                low = mid + 1;
            } else if(nums[mid] > target){
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return last;
    }
}
