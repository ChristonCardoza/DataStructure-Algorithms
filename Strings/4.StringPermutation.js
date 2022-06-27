const factorial = (number) => {
    let value = 1;

    for(let i=2; i<=number; i++){
        value = value * i;
    }

    return value;
}

const permutaion = (str) => {

    const strLength = str.length;
    const fact = factorial(strLength);
    const allPermuation = [];

    for( let i=0; i<fact; i++) {

        const tempStringArray = Array.from(str);
        let temp = i;
        let permuatedString ='';

        for(let div=strLength; div>=1; div--) {

            const q = Math.floor(temp/div);
            const r = temp % div;

            // process.stdout.write(tempStringArray[r]);
            permuatedString = permuatedString + tempStringArray[r];
            tempStringArray.splice(r,1);

            temp = q;

        }

        // console.log("");
        allPermuation.push(permuatedString);
    }
    return allPermuation;
}

const main = () => {
    const str = 'abc';

    console.log('Permuation of ', str);
    console.log(permutaion(str));
}

main();


/*
    Complexity:
        - permutation takes n! of possible solution
        - hence the outer loop will run for n! times -1
        - divide the outer loop value with string length iteratively (length to 1)
          here remider will give the the first letter of each combination,
          suppose the string ABC length is 3 and 3! is 6 so outer loop runs for 0 to 5
              outer loop 0                                               abc
          now 0/3 gives r as 0 and q is 0        ====> r = 0 ===> a      bc
              0/2 gives r as 0 and q is 0        ====> r = 0 ===> b      c
              0/1 gives r as 0 and q is 0        ====> r = 0 ===> c

              outer loop 1                                              abc
          now 1/3 gives r as 1 and q is 0        ====> r = 1 ===> b      ac
              0/2 gives r as 0 and q is 0        ====> r = 0 ===> a      c
              0/1 gives r as 0 and q is 0        ====> r = 0 ===> c    

              outer loop 2                                              abc
          now 2/3 gives r as 2 and q is 0        ====> r = 2 ===> c      ab
              0/2 gives r as 0 and q is 0        ====> r = 0 ===> a      c
              0/1 gives r as 0 and q is 0        ====> r = 0 ===> b      

              outer loop 3                                              abc
          now 3/3 gives r as 0 and q is 1        ====> r = 0 ===> a      bc
              1/2 gives r as 1 and q is 0        ====> r = 1 ===> c      a
              0/1 gives r as 0 and q is 0        ====> r = 0 ===> b      

              outer loop 4                                              abc
          now 4/3 gives r as 1 and q is 1        ====> r = 1 ===> b      ac
              1/2 gives r as 1 and q is 0        ====> r = 1 ===> c      c
              0/1 gives r as 0 and q is 0        ====> r = 0 ===> a      

              outer loop 5                                              abc
          now 5/3 gives r as 2 and q is 1        ====> r = 2 ===> c      ab
              1/2 gives r as 1 and q is 0        ====> r = 1 ===> b      a
              0/1 gives r as 0 and q is 0        ====> r = 1 ===> a      
*/