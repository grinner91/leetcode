
//https://leetcode.com/problems/merge-intervals/
class Solution {
    fun merge(intervals: Array<IntArray>): Array<IntArray> {
        //step: sort intervals by start time
        // intervals.sortWith(object: Comparator<IntArray> {
        //     override fun compare(a: IntArray, b: IntArray): Int {
        //         return a[0] - b[0]
        //     }
        // })
        
        intervals.sortWith(Comparator{ a, b -> a[0] - b[0] })
        
        //merged to non overlaping list
        var merged: MutableList<IntArray> = mutableListOf()
        
        for(current in intervals) {
            if(merged.isEmpty() || current[0] > merged[merged.lastIndex][1]) {
                merged.add(current)
            } else {
                merged[merged.lastIndex][1] = maxOf(merged[merged.lastIndex][1], current[1])
            }
        }
        
        return merged.toTypedArray()
    }
}
