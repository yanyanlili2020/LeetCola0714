/**
 * @param {string[]} words
 * @return {string[]}
 */
var findWords = function (words) {
    // 正则
    return words.filter(x => /(^[qwertyuiop]+$)|(^[asdfghjkl]+$)|(^[zxcvbnm]+$)/i.test(x))
};
var findWords = function (words) {
    const keyboard = [
        'qwertyuiop',
        'asdfghjkl',
        'zxcvbnm'
    ]
    return words.filter(item => {
        let str = item
        keyboard.forEach((chars, line) => {
            str = str.toLocaleLowerCase().replace(
                new RegExp(`[${chars}]`, 'g'), line)
        })
        return new Set(str).size === 1
    })
};