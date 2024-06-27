const PrintAllSubArrays = (arr) => {

    for( let i=0; i< arr.length-1; i++){
        for(let j=i; j< arr.length; j++){  
            for(let k=i; k<=j; k++){
                process.stdout.write(`${arr[k]}`);
            }
            console.log(); 
        }
    }
}

const main = () => {
    const array = [1, 2, 3, 4, 5, 6];
    
    console.log("Sub array of: ", array);
    PrintAllSubArrays(array)
}

main();

/*
    Complexity:
        Array of size N have approximately N^2 subarrays.
        3 Nested loops: O(n^3)
*/