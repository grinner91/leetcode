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
        
        //step: iterate over intervals and remove 
        //if any over-lapping intervals with larger width 
        int prev = 0;
        int removeCount = 0;
        
        for(int i = 1; i < intervals.length; i++) {
            int prevEnd = intervals[prev][1];
            int currentStart = intervals[i][0];
            int currentEnd = intervals[i][1];
        
            //previous interval's end time > current start time, overlap
            //then update prev and remove overlapping interval
            if(prevEnd > currentStart) {
                //if prev interval's end > current end
                //keep smaller width interval, which overlaps less with others
                if(prevEnd > currentEnd) {
                    prev = i;
                }
                removeCount++;
            }  else {
                prev = i;
            }
        }
        
        return removeCount ;
    }
}
