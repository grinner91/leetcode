//https://www.algoexpert.io/questions/best-seat
class Program {
func bestSeat(_ seats: [Int]) -> Int {
    // Write your code here.
    var start = 0
    var end = 0
    var maxEmptySeats = 0
    var left = 0
    
    for right in 1..<seats.count{
        if seats[right-1] == 0 && seats[right] == 1 {
            let currentEmptys = right - left
            if  currentEmptys > maxEmptySeats {
                maxEmptySeats = currentEmptys
                start = left + 1
                end = right - 1
            }
        }
        
        if seats[right] == 1 {
            left = right
        }
    }
    if maxEmptySeats > 0 {
        //print( "\(start)" + ", \(end) ")
        return start + ((end - start) / 2)
    }
    return -1
}
func testBestSeat() {
    var input = [1, 0, 1, 0, 0, 0, 1]
     //input = [1, 0, 1, 1, 1, 1, 1]
    var expected = 4
    var actual = bestSeat(input)
    print(actual)
}
}
