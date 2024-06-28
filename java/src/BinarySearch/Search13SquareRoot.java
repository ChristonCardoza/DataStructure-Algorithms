package BinarySearch;

public class Search13SquareRoot {
    /*
        n= 25 => 5
        n= 30 => 5
        n= 35 => 5
     */

    public static void main(String[] args) {

        System.out.println("Bruteforce Approach: ");
        System.out.println(bruteforce(25));
        System.out.println(bruteforce(30));
        System.out.println(bruteforce(35));

        System.out.println("BinarySearch Approach: ");
        System.out.println(getSquareRoot(25));
        System.out.println(getSquareRoot(30));
        System.out.println(getSquareRoot(35));

    }

    public static int bruteforce(int num){

        int i = 1;

        while(i*i <= num) {
            i++;
        }

        return i-1;
    }

    public static int getSquareRoot(int num){

        int ans = Integer.MAX_VALUE;

        int low=1, high = num;

        while(low<=high){

            int mid = low + (high-low)/2;

            if( mid * mid <= num){
                ans = mid;
                low = mid + 1;
            } else {
                high = mid-1;
            }
        }
        return ans;
    }
}
