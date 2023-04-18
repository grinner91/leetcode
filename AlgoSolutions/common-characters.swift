class Program {
/*
  https://www.algoexpert.io/questions/common-characters
  
  O(n * m) - n is number of strings, m is the characters in string[0]  
  O(c) - c is the unique chars 
*/

func commonCharacters(_ strings: [String]) -> [String] {
    
    var commonStrs = [String]()
    
    for chr in strings[0] {
        var isCharInAllStrs = true
        for str in strings {
            if !str.contains(chr) {
                isCharInAllStrs = false
                break
            }
        }
        if isCharInAllStrs && !commonStrs.contains(String(chr)) {
            commonStrs.append(String(chr))
        }
    }
    
    return commonStrs
}



func testCommonCharacters() {
    let chars = ["abc", "bcd", "cbad"]
    let result = commonCharacters(chars)
    print(result)
}


}
