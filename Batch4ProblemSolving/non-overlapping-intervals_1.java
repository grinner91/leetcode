//https://leetcode.com/problems/non-overlapping-intervals
class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        //handles edge cases 
        if(intervals.length <= 1) {
            return 0;
        }
        
        //step: sort intervals by start time 
        Arrays.sort(intervals, new Comparator<int[]>() {
           public int compare(int[] a, int[] b) {
               return a[0] - b[0];
           } 
        });
        
        //step: iterate over intervals and remove if any over-lap intervals 
        Deque<int[]> result = new ArrayDeque<>();
        result.addLast(intervals[0]);
        int removeCount = 0;
        
        for(int i = 1; i < intervals.length; i++) {
            int[] current = intervals[i];
            //last interval's end time < current interval start time, then add
            if(result.getLast()[1] > current[0]) {
                //if last interval's end > current end
                //keep smaller width interval, which overlaps less with others
                if(result.getLast()[1] > current[1]) {
                    result.removeLast();
                    result.add(current);
                }
                 removeCount++;
            }  else {
                result.addLast(current);
            }
        }
        
        return removeCount ;
    }
}
