package BinarySearch;

public class Search21AllocateBooks {
/*
    Given an array ‘arr of integer numbers, ‘ar[i]’ represents the number of pages in the ‘i-th’ book. There are a ‘m’ number of students, and the task is to allocate all the books to the students.
    Allocate books in such a way that:

    Each student gets at least one book.
    Each book should be allocated to only one student.
    Book allocation should be in a contiguous manner.

    You have to allocate the book to ‘m’ students such that the maximum number of pages assigned to a student is minimum. If the allocation of books is not possible. return -1

    arr[] = {25, 46, 28, 49, 24} student = 4

    25 | 46 | 28 | 49 24
    25   46   28     73    => 73

    25 | 46 | 28 49 | 24   => 77

    25 | 46  28 | 49 | 24   => 74

    25  46 | 28 | 49 | 24   => 71

    Ans :=> 71

*/

    public static void main(String[] args) {

        int[] arr = {25, 46, 28, 49, 24};
        int student = 4;

        System.out.println("Bruteforce Approach:");
        System.out.println(bruteforceApproach(arr,student));

        System.out.println("BinarySearch Approach:");
        System.out.println(binarySearchApproach(arr, student));
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

    public static int getStudentCount(int[] arr, int pages){

        int student = 1, pageCount = 0;

        for(int i=0; i<arr.length; i++){

            if(pageCount + arr[i] <= pages){
                pageCount += arr[i];
            } else {
                student ++;
                pageCount = arr[i];
            }
        }

        return student;
    }

    public static int bruteforceApproach(int[] arr, int student){

        int[] maxAndSum = findMaxAndSum(arr);
        int low = maxAndSum[0];
        int high = maxAndSum[1];

        for(int pages=low; pages<=high; pages++){

            int cntStudent = getStudentCount(arr, pages);

            if(cntStudent == student){
                return pages;
            }
        }
        return -1;
    }

    public static int binarySearchApproach(int[] arr, int student){

        int[] maxAndSum = findMaxAndSum(arr);

        int low = maxAndSum[0], high =  maxAndSum[1];
        int ans = -1;

        if(student > arr.length) return ans;

        while(low<=high){

            int mid = low + (high - low)/2;

            int studentCount = getStudentCount(arr, mid);

            if(studentCount > student) low = mid + 1;

            else {

                ans = mid;

                high = mid - 1;
            }

        }

        return ans;
    }
}
