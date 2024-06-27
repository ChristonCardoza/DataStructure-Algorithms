package BinarySearch;

public class Search05FloorAndCeil {
/*
    arr[] = { 10, 20, 30, 40, 50 }

    X = 25, Floor = 20, Ceil = 30
*/
    public static void main(String[] args) {
        int[] arr = { 10, 20, 30, 40, 50};
        int target = 25;

        System.out.println("Floor is: "+ getFloor(arr, target));
        System.out.println("Ceil is: "+ getCeil(arr, target));
    }

    public static int getFloor(int[] nums, int target){

        int floor = nums.length;
        int low = 0, high = nums.length-1;

        while(low<=high){

            int mid = low +(high-low)/2;

            if(nums[mid] <= target){
                floor = nums[mid];
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return floor;
    }

    public static int getCeil(int[] nums, int target){

        int ceil = nums.length;
        int low = 0, high = nums.length-1;

        while(low<=high){

            int mid = low + (high-low)/2;

            if(nums[mid] >= target){
                ceil = nums[mid];
                high = mid -1;
            } else {
                low = mid + 1;
            }
        }

        return ceil;
    }
}
