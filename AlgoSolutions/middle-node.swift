/*
https://www.algoexpert.io/questions/middle-node

time O(n)
space O(1) 

*/

class Program {
  // This is an input class. Do not edit.
  class LinkedList: Hashable {
    var value: Int
    var next: LinkedList?

    init(value: Int) {
      self.value = value
    }

    func hash(into hasher: inout Hasher) {
      hasher.combine(ObjectIdentifier(self).hashValue)
    }

    static func == (left: LinkedList, right: LinkedList) -> Bool {
      return left === right
    }
  }

 func middleNode(_ linkedList: LinkedList) -> LinkedList? {
    var slow: LinkedList? = linkedList
   //when fast node traverse to last node, 
   //slow node is in the middle
    var fast: LinkedList? = linkedList.next

    while(slow != nil && fast != nil) {
        slow = slow?.next
        fast = fast?.next?.next
    }
    
    return slow
}


func testMiddleNode() {
    var n1 = LinkedList(value: 1);
    var n2 = LinkedList(value: 2);
    n1.next = n2
    var n3 = LinkedList(value: 3);
    n2.next = n3
    var n4 = LinkedList(value: 4);
    n3.next = n4
    var n5 = LinkedList(value: 5);
    n4.next = n5
    print(middleNode(n1)?.value);
}
}
