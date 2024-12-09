package StackQueue;

public class SQ13TappingRainWater {

    public static void main(String[] args) {

        int[] arr = { 0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
        System.out.println("Bruteforce Solution  O(2n): " + bruteforce(arr));
        System.out.println("Optimal Solution  O(n): " + trapTwoPointers(arr));
    }

    static int bruteforce(int[] arr){

        int total = 0;

        int[] prefixMax = getPrefixMax(arr);
        int[] suffixMax = getSuffixMax(arr);

        for (int i=0; i<arr.length; i++){
            total = total + Math.min(prefixMax[i], suffixMax[i]) - arr[i];
        }

        return total;
    }

    private static int[] getSuffixMax(int[] arr) {

        int[] suffixMax = new int[arr.length];
        suffixMax[arr.length-1] = arr[arr.length-1];

        for(int i=arr.length-2; i>=0; i--){
            suffixMax[i] = Math.max(suffixMax[i+1], arr[i]);
        }

        return suffixMax;
    }

    private static int[] getPrefixMax(int[] arr) {

        int[] prefixMax = new int[arr.length];

        prefixMax[0] = arr[0];

        for(int i=1; i<arr.length; i++){

            prefixMax[i] = Math.max(prefixMax[i-1], arr[i]);
        }

        return prefixMax;
    }

    public static int trapTwoPointers(int[] height) {
        int n = height.length;
        if (n == 0) return 0;

        int left = 0, right = n - 1;
        int leftMax = 0, rightMax = 0;
        int totalWater = 0;

        while (left < right) {

            if (height[left] < height[right]) {

                if (height[left] >= leftMax) {
                    leftMax = height[left];
                } else {
                    totalWater += leftMax - height[left];
                }

                left++;
            } else {

                if (height[right] >= rightMax) {
                    rightMax = height[right];
                } else {
                    totalWater += rightMax - height[right];
                }

                right--;
            }
        }

        return totalWater;
    }


}
