const Reverse = (arr, start, end) => {

    while(start<=end) {
        [arr[start], arr[end]] = [arr[end], arr[start]];
        start ++;
        end --;
    }
}

const ClockRotate = (arr, k) => {
    let n =  arr.length
    k = k % n;

    Reverse(arr, 0, n - k - 1);
    Reverse(arr, n-k, n-1);
    Reverse(arr, 0, n-1);
}

const CounterClockRotate = (arr, k) => {
    let n =  arr.length
    k = k % n;

    Reverse(arr, 0, k - 1);
    Reverse(arr, k, n-1);
    Reverse(arr, 0, n-1);
}

const main = () => {
    const array = [10, 20, 30, 40, 50];
    const rotation = 3;
    console.log("Given Array: ",array);
    ClockRotate(array, rotation)
    console.log("ClockWise Array: ",array);
    CounterClockRotate(array, rotation)
    console.log("CounterClockWise Array: ",array);
}

main();

/*
    Complexity:
       
        array = [10, 20, 30, 40, 50]
        rotation = 3

        when rotation is equal to length of the array then it will be its initial position.
        divide the array into 2 parts, and reverse individual parts 
            Clockwise:
                - 0 to n-k-1
                - n-k to n-1
            AntiClockwise:
                - 0 to k-1
                - k to n-1
        reverse entire array will give you the answer              
                            or

        when i < k store the a[n+i-k] else a[i-k] value push into new array



        its a binary search algorithm : O(n)
*/