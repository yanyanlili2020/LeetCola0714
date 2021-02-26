/** 112
 * @param {number} x
 * @return {number}
 */
var mySqrt = function(x) {
    if(x === 0) return 0;
    var re = 1;
    while(!(re * re <= x && (re + 1) * (re + 1) > x)) {
        re = parseInt(re - (re * re - x) / (2 * re))
    }
    return re
};
/** 128
 * @param {number} x
 * @return {number}
 */
var mySqrt = function(x) {
    if(x === 0 || x === 1) return x
    let low = 0
    let high = x
    let mid
    let qr
    while(low < high) {
        mid = Math.floor(low + (high - low) / 2)
        qr = mid * mid
        if(qr === x) return mid
        if(qr < x && (mid + 1) * (mid + 1) > x) return mid //这里要判断mid下一位的平方是否会比给定的阿平方数大
        if(qr > x) {
            high = mid - 1
        } else {
            low = mid + 1
        }
    }
    return low //最后返回low必然没错，因为是舍弃小数点往小取整数
};