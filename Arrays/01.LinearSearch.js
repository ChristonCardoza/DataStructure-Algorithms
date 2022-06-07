const LinearSearch = (arr, key) => {
    const itr = arr.entries();
    for([index, element] of itr) {
        if(element === key) {
            return index;
        }
    }
    return -1;
}

const main = () => {

    const array = [20, 10, 30, 50, 40];
    const key = 30;

    const elementAt = LinearSearch(array, key);

    const result = elementAt === -1 ? 
        `Element ${key} not present in given array` :
        `Element ${key} present at index ${elementAt}`

    console.log(result);
}


main();

/* 
    Complexity: maximum it needs to traverse all `N` element of array O(n)
*/