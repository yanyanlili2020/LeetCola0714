/**
 * @param {number} n
 * @return {number}
 */
var climbStairs = function(n) {
    let p = 0;
    let q = 0;
    let r = 1;
    for(let i = 0; i < n; i++) {
        p = q;
        q = r;
        r = p + q;// %1000000007
    }
    return r;// 爬楼梯题改成输出r即可
};