class Program {

//https://www.algoexpert.io/questions/valid-starting-city
  //time O(n^2), space O(1)
func validStartingCity(_ distances: [Int], _ fuel: [Int], _ mpg: Int) -> Int {
    //start frome each city
  let numCities = fuel.count
    for i in 0..<numCities { 
        var currentIdx = i;
        var milesRemaining = fuel[currentIdx] * mpg;
        for j in 0..<numCities {
            milesRemaining -= distances[currentIdx]
            let nextIdx =  ( i + j + 1 ) % numCities
            if milesRemaining >= 0 {
                milesRemaining += (fuel[nextIdx] * mpg)
                currentIdx = nextIdx;
            } else { break; }
        }
        if(milesRemaining >= 0) {
         return i;
        }

    }
   return -1
 }


func testValidStartingCity() {
    let dist = [5, 25, 15, 10, 15];
    let fuel = [1, 2, 1, 0, 3];
    let mpg = 10
    
    print( validStartingCity(dist, fuel, mpg));
}

}
