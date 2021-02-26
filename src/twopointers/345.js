/**
 * @param {string} s
 * @return {string}
 */
var reverseVowels = function(s) {
    const store = ['a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U'];
    const sArr = s.split('');
    let left = 0;
    let right = sArr.length-1;
    while(left<right){
        const leftChar = sArr[left];
        const rightChar = sArr[right];
        if(store.indexOf(leftChar) > -1 && store.indexOf(rightChar) > -1){
            if(store.indexOf(leftChar) !==store.indexOf(rightChar)){
                [sArr[left], sArr[right]] = [sArr[right], sArr[left]];
            }
            left ++;
            right --;
            continue;
        }
        if(store.indexOf(leftChar) === -1){
            left++
        }
        if(store.indexOf(rightChar) === -1){
            right--
        }
    }
    return sArr.join('');
};