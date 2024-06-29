package BinarySearch;

public class Search14NthRoot {
/*
        n = 3   m = 27   3√27 => 3   3^3
        n = 4   m = 69   4√69 => -1
        n = 4   m = 64   4√64 => -1
        n = 2   m = 9    2√9  => 3  3^2
*/

    public static void main(String[] args) {

        System.out.println("Bruteforce Approach: ");
        System.out.println(bruteforce(3, 27));
        System.out.println(bruteforce(4, 69));
        System.out.println(bruteforce(4, 64));
        System.out.println(bruteforce(2, 9));

        System.out.println("BinarySearch Approach: ");
        System.out.println(getNthRoot(3, 27));
        System.out.println(getNthRoot(4, 69));
        System.out.println(getNthRoot(4, 64));
        System.out.println(getNthRoot(2, 9));

    }

    public static int power(int x, int n) {

        if(n==0) return 1;

        int pow = power(x, n/2);

        if(n%2 == 0){
            return pow * pow;
        } else {
            return pow * pow * x;
        }
    }

    public static int bruteforce(int n, int m){

       for(int i=1; i<m; i++){

           if(power(i,n) == m){
               return i;
           }

           if(power(i, n) > m) {
               break;
           }

       }

        return -1;

    }

    public static  int getRoot(int mid, int n, int m) {

        int ans = 1;

        for(int i=1; i<=n; i++ ){

            ans = ans * mid;

            if(ans > m){
                return 2;
            }
        }

        if(ans == m) return 1;

        return 0;
    }

    public static int getNthRoot(int n, int m){

        int low = 1, high = m;

        while(low<= high){

            int mid = low + (high-low)/2;

            // for larger power this is inefficient
//            int midN = power(mid, n);
//
//            if(midN == m) {
//                return mid;
//            } else if(midN < m){
//                low = mid + 1;
//            } else {
//                high = mid - 1;
//            }

            int midN = getRoot(mid, n, m);

            if(midN == 1) {
                return mid;
            } else if(midN == 0){
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return -1;
    }
}
