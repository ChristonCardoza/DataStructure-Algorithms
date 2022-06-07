const sumOfSubArray = (arr) => {
    let largestSum = 0;
    let currentSum = 0;

    for(let i=0; i<arr.length; i++){
        for(let j=i; j<arr.length; j++){
            currentSum = 0;
            for(let k=i; k<=j; k++){
                currentSum = currentSum + arr[k];
            }
            largestSum = largestSum > currentSum ? largestSum : currentSum;
           
        }
    }
    return largestSum;
}
const main = () => {
    const array = [-2,3,4,-1,5,-12,6,1,3];

    console.log('Sum of sub array: ', array);
    const sum = sumOfSubArray(array);
    console.log(sum);
}
main();

/*
    Complexity:
        largest sum of subarray is total sum of array when elements are positive.
        3 Nested loops: O(n^3)
*/