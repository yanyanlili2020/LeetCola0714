package array;

/***
 * https://leetcode-cn.com/problems/distance-between-bus-stops/
 */
public class _1184_公交车站间的距离_0722S {
    public int distanceBetweenBusStops(int[] distance, int start, int destination) {
        int sum = 0;
        for(int i = 0; i < distance.length; i++) sum += distance[i];
        int sum1 = 0;
        if(start < destination) {
            for(int i = start; i < destination; i++) sum1 += distance[i];
        } else {
            for(int i = destination; i < start; i++) sum1 += distance[i];
        }
        return Math.min(sum1, sum - sum1);
    }
}
