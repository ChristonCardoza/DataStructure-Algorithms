const BST = (arr, key) => {
    let start = 0;
    let end = arr.length - 1;

    while(start <= end) {
        let mid = (start + end) / 2;

        if( arr[mid] === key) {
            return mid;
        } else if(arr[mid] > key) {
            end = mid-1;
        } else {
            start = mid + 1;
        }
    }

    return -1;
    
}

const main = () => {
    const array = [10, 20, 30, 40, 50];
    const key = 30;

    const elementAt = BST(array, key);

    const result = elementAt === -1 ?
        `Element ${key} is not present` :
        `Element ${key} is present at index ${elementAt}`
    
    console.log(result);
}

main();

/*
Complexity:
 1st Itr N/2^0
 2nd Itr N/2^1
      |
      |
 Nth Itr N/2^k = 1
 O(nlogn)     
 */