//https://leetcode.com/problems/merge-intervals

class Solution {
    public int[][] merge(int[][] intervals) {

        //step: sort intervals with start time 
        Arrays.sort(intervals, new Comparator<int[]>() {
            public int compare(int[] a, int[] b) {
                return a[0] - b[0];
            }
        });
        
        //step: iterate over intervals, merge overlapping with end time >= start
        LinkedList<int[]> mergedList = new LinkedList<>();
       
        for(int[] current: intervals) {
            if(mergedList.isEmpty() || current[0] > mergedList.getLast()[1]) {
                mergedList.add(current);
            } else {
                mergedList.getLast()[1] = Math.max(mergedList.getLast()[1], current[1]);
            }
        }
        
        return mergedList.toArray(new int[mergedList.size()][]);
    }
}
