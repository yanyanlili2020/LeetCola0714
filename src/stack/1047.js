/** 100
 * @param {string} S
 * @return {string}
 */
var removeDuplicates = function(S) {
    let stack = [];
    for(let i = 0;i<S.length;i++){
        if(S[i]===stack[stack.length-1]){
            stack.push(S[i])
        } else {
            stack.pop()
        }
    }
    return stack.join('');
};
/** 128
 * @param {string} S
 * @return {string}
 */
var removeDuplicates = function(S) {
    S = S.split('');
    for(let i = 0; i < S.length - 1; i++) {
        if(S[i+1] == S[i]) {
            S.splice(i, 1);
            S.splice(i, 1);
            i -= 2;
        }
    }
    return S.join('');
};
