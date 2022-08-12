import java.util.*;
//https://www.algoexpert.io/questions/multi-string-search

class TrieNode {
    Map<Character, TrieNode> children; 
    boolean isEndOfWord;
    String endStr; 
    public TrieNode() {
      isEndOfWord = false;
      children = new HashMap<>();
      endStr = "";
    }
  }

class Program {
  
  public static TrieNode root = new TrieNode();
  
  public static List<Boolean> multiStringSearch(String bigString, String[] smallStrings) {
    //edge case 
     if(bigString == null || bigString.length() == 0
        || smallStrings == null || smallStrings.length == 0)
       return new ArrayList<Boolean>();
    
    //construct trie data structure 
    for(String str: smallStrings) {
      insertIntoTrie(str);
    }
    
    //search small strings in big string
    HashSet<String> containedSet = new HashSet<>();
    for(int i = 0; i < bigString.length(); i++) {
      searchSmallStrInBigStr(bigString, i, containedSet);
    }
    
    //prepare list of results 
    List<Boolean> results = new ArrayList<>();
    for(String str: smallStrings) {
        results.add(containedSet.contains(str));
    }
    
    return results;
  }


  private static void searchSmallStrInBigStr(String bigStr, 
                                             int startIdx, 
                                             Set<String> containedSet) {
    var current = root; 
    for(int i = startIdx; i < bigStr.length(); i++) {
      char chKey = bigStr.charAt(i);
      if(!current.children.containsKey(chKey)) {
        break;
      }
      current = current.children.get(chKey);
      if(current.isEndOfWord) {
        containedSet.add(current.endStr);
      }
      
    }
  }

  private static void insertIntoTrie(String str) {
    TrieNode current = root;
    for(char ch: str.toCharArray()) {
      if(!current.children.containsKey(ch)) {
        current.children.put(ch, new TrieNode());
      }
      current = current.children.get(ch);
    }
    current.endStr = str;
    current.isEndOfWord = true;
  }

}
