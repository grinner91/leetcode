package com.algoexpert.program
//https://www.algoexpert.io/questions/three-number-sum

fun threeNumberSum(array: MutableList<Int>, targetSum: Int): List<List<Int>> {
    val triplets = mutableListOf<MutableList<Int>>()
    array.sort()
    for( i in 0 until array.size - 2) {
        var left = i + 1;
        var right = array.size - 1;
        while(left < right) {
            val currentSum = array[i] + array[left] + array[right];
            if(currentSum == targetSum) {
                triplets.add(mutableListOf(array[i] , array[left] , array[right]))
                left++
                right--
            } else if (currentSum < targetSum) {
                left++;
            } else {
                right--;
            }
        }
    }

    return triplets
}

fun testThreeSum() {
    var arr = mutableListOf<Int>(12, 3, 1, 2, -6, 5, -8, 6)
    println(threeNumberSum(arr, 0))
}
