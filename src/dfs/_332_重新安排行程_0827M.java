package dfs;

import java.util.*;

/**
 * https://leetcode-cn.com/problems/reconstruct-itinerary/
 * 给定一个机票的字符串二维数组 [from, to]，子数组中的两个成员分别表示飞机出发和降落的机场地点，对该行程进行重新规划排序。所有这些机票都属于一个从 JFK（肯尼迪国际机场）出发的先生，所以该行程必须从 JFK 开始。
 * 说明:
 * <p>
 * 如果存在多种有效的行程，你可以按字符自然排序返回最小的行程组合。例如，行程 ["JFK", "LGA"] 与 ["JFK", "LGB"] 相比就更小，排序更靠前
 * 所有的机场都用三个大写字母表示（机场代码）。
 * 假定所有机票至少存在一种合理的行程。
 */
public class _332_重新安排行程_0827M {
    class Solution {
        Map<String, PriorityQueue<String>> map = new HashMap<>();
        List<String> itinerary = new ArrayList<>();
        public List<String> findItinerary(List<List<String>> tickets) {
            for(List<String> l : tickets) {
                map.computeIfAbsent(l.get(0), k -> new PriorityQueue<>()).add(l.get(1));
            }
            dfs("JFK");
            return itinerary;
        }
        private void dfs(String airport) {
            while(map.containsKey(airport) && !map.get(airport).isEmpty()) dfs(map.get(airport).poll());
            itinerary.add(0, airport);
        }
    }
    class Solution11 {
        public List<String> findItinerary(List<List<String>> tickets) {
            LinkedList<String> res = new LinkedList<>();
            Map<String, PriorityQueue<String>> flights = new HashMap<>();
            for(List<String> ticket : tickets) {
                if(!flights.containsKey(ticket.get(0))) {
                    flights.put(ticket.get(0), new PriorityQueue<>());
                }
                flights.get(ticket.get(0)).offer(ticket.get(1));
            }
            dfs(flights, res, "JFK");
            return res;
        }
        public void dfs(Map<String, PriorityQueue<String>> flights, LinkedList<String> res, String dep) {
            PriorityQueue<String> arrival = flights.get(dep);
            while(arrival != null && !arrival.isEmpty()) {
                dfs(flights, res, arrival.poll());
            }
            res.addFirst(dep);
        }
    }
    class Solution9 {
        Map<String, PriorityQueue<String>> map = new HashMap<>();
        List<String> itinerary = new LinkedList<>();
        public List<String> findItinerary(List<List<String>> tickets) {
            for(List<String> ticket : tickets) {
                String src = ticket.get(0), dst = ticket.get(1);
                if(!map.containsKey(src)) {
                    map.put(src, new PriorityQueue<String>());
                }
                map.get(src).offer(dst);
            }
            dfs("JFK");
            Collections.reverse(itinerary);
            return itinerary;
        }
        public void dfs(String curr) {
            while(map.containsKey(curr) && map.get(curr).size() > 0) {
                String tmp = map.get(curr).poll();
                dfs(tmp);
            }
            itinerary.add(curr);
        }
    }
}
