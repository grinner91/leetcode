//https://leetcode.com/problems/insert-interval/
class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        LinkedList<int[]> output = new LinkedList<>();
        int idx = 0;
        int n = intervals.length;
        //step: add intervals before newIntvl 
        while(idx < n && intervals[idx][1] < newInterval[0]) {
            output.add(intervals[idx]);
            idx++;
        }
        //step: add and merge overlapping intvls 
        int start = newInterval[0], end = newInterval[1];
        while(idx < n && intervals[idx][0] <= newInterval[1]) {
            start = Math.min(start, intervals[idx][0]);
            end = Math.max(end, intervals[idx][1]);
            idx++;
        }
        output.add(new int[] {start, end});
        
        //step: add remaining intvls 
        while(idx < n) {
            output.add(intervals[idx]);
            idx++;
        }
        
        return output.toArray(new int[output.size()][2]);
    }
}
