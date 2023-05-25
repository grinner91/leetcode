class Program {
  //https://www.algoexpert.io/questions/valid-starting-city
//time O(n), space O(1)
func validStartingCity(_ distances: [Int], _ fuel: [Int], _ mpg: Int) -> Int {
    //start frome each city
    let numCities = fuel.count
    var milesRemaining  = 0
    var startingCityIdx = 0
    
    for i in 1..<numCities {
        milesRemaining += fuel[i-1] * mpg
        milesRemaining -= distances[i-1]
        
        if(milesRemaining < 0) {
            startingCityIdx = i
            milesRemaining = 0
        }
        
    }
    return startingCityIdx
}
}
