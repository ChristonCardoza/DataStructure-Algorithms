const reverse = (arr) => {
    let start = 0;
    let end = arr.length - 1;

    while(start < end) {
        [arr[start], arr[end]] = [arr[end], arr[start]];
        start++;
        end--;
    }
    return arr;
}

const main = () => {
    const array = [10, 20, 30, 40, 50];
    console.log("Given a array:", array);
    const result = reverse(array);
    console.log("Reversed array:", result);
}

main();

/*
    Complexity:
        it needs to travel half length of the array N/2 : O(n)
*/