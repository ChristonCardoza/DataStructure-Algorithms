const ArePermutation = (str1, str2) => {

    if(str1.length !== str2.length) {
        return false;
    }
    
    const strArray1 = Array.from(str1);
    const strArray2 = Array.from(str2);

    strArray1.sort();
    strArray2.sort();

    for(let i=0; i<strArray1.length; i++){
        if(strArray1[i] !== strArray2[i]){
            return false;
        }
    }
    return true;
}

const main = () => {
    string1= 'abc';
    string2= 'cba';

    console.log('The given String 1', string1);
    console.log('The given String 2', string2);
    console.log('Are Permutaion: ' ,ArePermutation(string1, string2));
}

main();

/*
    Complexity:  Time Complexity= O(n log n)
*/