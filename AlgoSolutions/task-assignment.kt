
//https://www.algoexpert.io/questions/task-assignment
package com.algoexpert.program


//time - O(nlogn)
//space - O(n)
fun taskAssignment(k: Int, tasks: List<Int>): List<List<Int>> {
    //sort tasks asc duration O(nlogn)
    val sortedTasks = tasks.withIndex().sortedBy { it.value }
    //pairs lowest and highest duration
    var left = 0
    var right = sortedTasks.size - 1
    val pairs = mutableListOf<List<Int>>()
    //O(n)
    while (left < right) {
        pairs.add(listOf(sortedTasks[left].index, sortedTasks[right].index))
        left++
        right--
    }

    return pairs
}


// fun testTaskAssignment() {
//    val tasks = listOf<Int>(1, 3, 5, 3, 1, 4)
//    val result =  taskAssignment(3, tasks);
//     println(result)
// }
