//https://leetcode.com/problems/insert-interval
//ref: inspired by @asrid21 solution
class Solution {
    
    public int[][] insert(int[][] intervals, int[] newInterval) {
        int prevStart = newInterval[0];
        int prevEnd = newInterval[1];
        List<int[]> output = new ArrayList<>();
        
        //iterate over all intervals, add if no overlap, else update prev values
        for(int i = 0; i < intervals.length; i++) {
            int[] current = intervals[i];
            
            if(current[1] < prevStart) {
                //if currentEnd < previousStart, so no overlap 
                //then add current interval to output 
                output.add(current);
            } else if(prevEnd < current[0]) {
                //if prevEnd < currentStart, so no overlap 
                //then add prev interval and update prev interval by current intvl
                output.add(new int[]{ prevStart, prevEnd });
                prevStart = current[0];
                prevEnd = current[1];
            } else {
                //there is ovelapping, prev interval and current interval 
                //so, do not add and update values
                prevStart = Math.min(prevStart, current[0]);
                prevEnd = Math.max(prevEnd, current[1]);
            }
            
        }
    
        //add last prev interval to output 
        output.add(new int[]{prevStart, prevEnd});
                                
        return output.toArray(new int[output.size()][2]);
    }
}
