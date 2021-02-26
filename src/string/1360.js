/** 80
 * @param {string} date1
 * @param {string} date2
 * @return {number}
 */
var daysBetweenDates = function(date1, date2) {
    return Math.abs( (+new Date(date1)) - (+new Date(date2)) ) / (24 * 60 * 60 * 1000);
};
/** 84
 * @param {string} date1
 * @param {string} date2
 * @return {number}
 */
var daysBetweenDates = function (date1, date2) {
    date1 = new Date(date1).getTime();
    date2 = new Date(date2).getTime();
    return Math.abs(date1 - date2) / 1000 / 60 / 60 / 24;
};

