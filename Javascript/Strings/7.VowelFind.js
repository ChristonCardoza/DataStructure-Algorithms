const FindVowel = (str) => {
    let vowel = '';

    for( let ch of str){
        if(ch==='a' || ch==='e' || ch==='i' || ch==='o' || ch==='u'){
            vowel = vowel + ch;
        }
    }

    return vowel;
}

const main = () => {
    const str = 'aeoibsddaeioudb'

    console.log('The given String is:', str);
    console.log('The Vowel strin is: ', FindVowel(str));
}

main();