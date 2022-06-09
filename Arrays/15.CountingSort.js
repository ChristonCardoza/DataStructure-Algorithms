const CountingSort = (arr) => {

   let largest = -1;

   for( i =0; i< arr.length; i++) {
       largest = Math.max(largest, arr[i]);
   };

   const freq = new Array(largest + 1).fill(0)
 
   for( val of arr) {
       freq[val] += 1;
   }
 
   let k=0;

  for( let j=0; j< freq.length; j++) {

    while(freq[j] > 0) {
        arr[k] = j
        freq[j]--;
        k++;
    }
  }

}


const main = () => {

    const array = [5,8,3,1,1,2,6];

    console.log("The Given Array is: ", array);
    CountingSort(array);
    console.log("The Sorted Array is: ", array);
}

main();

/*
    Complexity:
        array = [5,8,3,1,1,2,6]
        
        - Find the maximum element of the the array (8)
        - create a new array whose size(range) is same as maximum element  + 1 freq[9]
        - Insert element value form arr array to freq array's index location by 1 [0,2,1,1,0,1,1,0,1]
        - Replace element index value from freq array to entire arr array

        O(n + range)
*/