package BinarySearch;

class Search01BinarySearch {

    public static void main(String[] args) {

        int[] arr = {3, 4, 6, 7, 9, 13, 16, 17};

        System.out.println(searchIterative(arr, 9));

        System.out.println(searchRecursive(arr, 17, 0, arr.length-1));

    }

    public static int searchIterative(int[] nums, int target){

        int n = nums.length;
        int low = 0;
        int high = n-1;

        while(low<=high){

            int mid = low + (high-low)/2;

            if(nums[mid] == target){
                return mid;
            } else if(nums[mid] > target) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return -1;
    }

    public static int searchRecursive(int[] nums, int target, int low, int high){

        if(low > high) return -1;

        int mid = low + (high-low)/2;

        if(nums[mid] == target) return mid;

        else if( nums[mid] > target) return searchRecursive(nums, target, low, mid-1);

        return searchRecursive(nums, target, mid+1, high);
    }
}