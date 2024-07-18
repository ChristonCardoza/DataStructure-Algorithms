package BinarySearch;

public class Search22PainterPartition {
/*
     Painter's Partition Problem:

         Given an array/list of length ‘N’, where the array/list represents the boards and each element of the given array/list represents the length of each board.
         Some ‘K’ numbers of painters are available to paint these boards. Consider that each unit of a board takes 1 unit of time to paint.
         You are supposed to return the area of the minimum time to get this job done of painting all the ‘N’ boards under the constraint that any painter will only paint the continuous sections of boards.


    Split Array - Largest Sum:

       Given an integer array ‘A’ of size ‘N’ and an integer ‘K'. Split the array ‘A’ into ‘K’ non-empty subarrays such that the largest sum of any subarray is minimized.
       Your task is to return the minimized largest sum of the split.A subarray is a contiguous part of the array.


    arr[] = {10, 20, 30, 40} k =2
    {10}, {20, 30, 40} => 10 - 90 :=> 90
    {10, 20}, {30, 40} => 30 - 70 :=> 70
    {10, 20, 30}, {40} => 60 - 40 :=> 60

    Ans 60
 */

    public static void main(String[] args) {

        int[] board = {10, 20, 30, 40};
        int painters = 2;

        System.out.println(painterPartition(board, painters));
    }

    public static int[] findMaxAndSum(int[] arr){

        int max = Integer.MIN_VALUE;
        int sum = 0;

        for(int ele: arr){
            max = Math.max(ele, max);
            sum += ele;
        }

        return new int[] {max, sum};
    }

    public static int countPainters(int[] board, int time){

        int painter = 1, boardCount = 0;

        for(int i=0; i<board.length; i++){

            if(boardCount + board[i] <= time){
                boardCount += board[i];
            } else {
                painter ++;
                boardCount = board[i];
            }
        }

        return painter;
    }


    public static int painterPartition(int[] board, int painter){

        if(painter > board.length) return  -1;

        int[] maxAndSum = findMaxAndSum(board);

        int low = maxAndSum[0], high=maxAndSum[1];

        while(low<=high){

            int mid = low + (high-low)/2;

            int paintersCount = countPainters(board, mid);

            if(paintersCount > painter){
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return low;
    }
}
