

import Foundation
//1071. Greatest Common Divisor of Strings

class SolutiongcdOfStrings {
    
    func gcdOfStrings(_ str1: String, _ str2: String) -> String {
        
        guard str1 + str2 == str2 + str1 else { return "" }
        
        let gcd = calculateGcd(max(str1.count, str2.count), min(str1.count, str2.count))
    
        return String(str1.prefix(gcd))
    }
    
    private func calculateGcd(_ x: Int, _ y: Int) -> Int {
        var x = x, y = y
        while y != 0 {
            let temp = y
            y = x % y
            x = temp
        }
        return x
    }
    
    //solution 2
    func gcdOfStrings2(_ str1: String, _ str2: String) -> String {
        
        guard str1 + str2 == str2 + str1 else { return "" }
        
        var (numStr, gcdStr) = str1.count > str2.count ? (str1, str2) : (str2, str1)
        
        if numStr.count % gcdStr.count == 0 { return gcdStr }
        
        while !gcdStr.isEmpty {
            if str1.count % gcdStr.count == 0
                && str2.count % gcdStr.count == 0 {
                return gcdStr
            }
            gcdStr.removeLast()
        }
        
        return gcdStr
    }
}


func testSolutiongcdOfStrings() {
    let sol = SolutiongcdOfStrings()
  print(sol.gcdOfStrings("ABCABC", "ABC"))
  print(sol.gcdOfStrings("AB", "ABC"))
    print(sol.gcdOfStrings("AB", "X"))
}

