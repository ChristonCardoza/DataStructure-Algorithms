const ChopSticksPair = (chopSticks, diff) => {
    const pair = [];
    let numberOfPair = 0;
    // 1. Sort the ChopSticks
    chopSticks.sort((a,b) => a-b);

    // 2. Compare difference with adjacent chopstick
    for(let i=0; i<chopSticks.length-1; i++) {
        if(chopSticks[i+1]-chopSticks[i] <= diff){
            numberOfPair ++;
            pair.push([chopSticks[i], chopSticks[i+1]]);
            // 3. Remove the paired chopsticks from array
            chopSticks.splice(chopSticks.indexOf(i+1),1);
            chopSticks.splice(chopSticks.indexOf(i),1)
        } else {
            break;
        }
    }


    return {
        numberOfPair,
        pair
    }
}

const main = () => {
    const chopSticks = [1, 3, 3, 9, 4];
    const difference = 2;

    const { numberOfPair, pair } = ChopSticksPair(chopSticks, difference);

    console.log('Total Numbers of ChopStick Pair: ', numberOfPair);
    console.log('All Pair:', pair);
}

main();

/*
    Complexity:
        - Sort all width and height
        - Compare difference with adjacent chopstick smaller of equal to given diff
            - true: Once we get the matched pair Remove the paired chopsticks from array
            - false: since it is sorted adjacent elements are greater

        sorting takes O(nlogn)
*/