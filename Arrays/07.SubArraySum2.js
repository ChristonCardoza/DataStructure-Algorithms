const sumOfSubArray = (arr) => {
    let largestSum = 0;
    let currentSum = 0;
    const prefixSumArray = [0];
    prefixSumArray[0] = a[0];

    for(let i=1; i<arr.length; i++){
        prefixSumArray[i] = prefixSumArray[i-1]+a[i]
    }

    for(let i=0; i<arr.length; i++){
 
        for(let j=i; j<arr.length; j++){

            currentSum = i > 0 ? 
                prefixSumArray[j] - prefixSumArray[i-1] :
                prefixSumArray[j];
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
        Prefix Sum:
         - store the cumulative some of array in to array
           arr[1,2,4,-2,3]
           cumulative sum[1,3,7,5,8]
         - prefixSum = prefixSum[i-1]+a[i]
         - sumofSubArray = prefixSum[j] - prefixSum[i-1]

         Two nested loops + one independent loop = O(n^2) + O(n) = O(n)
*/