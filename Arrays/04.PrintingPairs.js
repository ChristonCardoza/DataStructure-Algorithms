const printAllPairs = (arr) => {
    for(let i = 0; i < arr.length; i++){
        let x = arr[i];
        for(let j=i+1; j< arr.length; j++) {
            let y  = arr[j];
            console.log(x,y);
        }
        console.log();
    }
}

const main = () => {
    const array = [1, 2, 3, 4, 5, 6];
    
    console.log("Array pair of: ", array);
    printAllPairs(array)
}

main();

/*
    Complexity:
        Here is we are using nested loops: O(n2)
*/