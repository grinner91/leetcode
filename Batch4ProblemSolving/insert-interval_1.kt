//https://leetcode.com/problems/insert-interval/submissions/
class Solution {
    fun insert(intervals: Array<IntArray>, newInterval: IntArray): Array<IntArray> {
        var output: MutableList<IntArray> = mutableListOf()
        val n = intervals.size
        var idx = 0
        
        //step: add intervals before new interval 
        while(idx < n && intervals[idx][1] < newInterval[0]) {
            output.add(intervals[idx])
            idx++
        }
        
        //step: merge overlapping intervals with new interval
        var start = newInterval[0]
        var end = newInterval[1]
        
        while(idx < n && intervals[idx][0] <= newInterval[1]) {
            start = minOf(start, intervals[idx][0])
            end = maxOf(end, intervals[idx][1])
            idx++
        }
        output.add(intArrayOf(start, end))
        
        //step: add remaining intervals 
        while(idx < n) {
            output.add(intervals[idx])
            idx++
        }
        
        return output.toTypedArray()
    }
}
