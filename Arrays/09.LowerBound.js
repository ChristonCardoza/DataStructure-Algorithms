const LowerBound = (arr, key) => {

    let start = 0;
    let end = arr.length - 1;

    while(start <= end) {
        let mid = Math.round((start + end) / 2);

        if( arr[mid] >= key) {
            end = mid - 1;
        }else {
            start = mid + 1;
        }
    }

    return start;
}

const UpperBound = (arr, key) => {

    let start = 0;
    let end = arr.length - 1;

    while(start <= end) {
        let mid = Math.round((start + end) / 2);

        if(arr[mid] > key ) {
            end = mid - 1;
        }else { 
            start = mid + 1;
        }
    }
    return start;
}
const main = () => {
    const array = [10, 20, 30, 30, 30, 30, 40, 50];
    const key = 35;

    const lowerBound = LowerBound(array, key);
    const upperBound = UpperBound(array, key);

    console.log(`Upper and Lower Bound of given array ${array} of key ${key} is ${lowerBound} and ${upperBound}`);
}

main();

/*
    Complexity:
        When array is sorted ......
        array = [10, 20, 30, 30, 30, 30, 40, 50]
        key = 30

        lowerbound: first apperance of key index if the key present, if not immediate next index -> 2
        upperbound : next index of key.->6

        its a binary search algorithm : O(n)
*/