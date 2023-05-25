package com.algoexpert.program
//https://www.algoexpert.io/questions/valid-starting-city

fun validStartingCity(distances: List<Int>, fuel: List<Int>, mpg: Int): Int {
    var startingCityIdx = 0
    var milesRemaining = 0

    for (i in 1 until  fuel.size) {
        milesRemaining += fuel[i - 1] * mpg
        milesRemaining -= distances[i - 1]
        if (milesRemaining < 0) {
            startingCityIdx = i
            milesRemaining = 0
        }
    }

    return startingCityIdx
}
