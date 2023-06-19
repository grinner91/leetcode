//https://www.algoexpert.io/questions/min-heap-construction

class Program {
   public class MinHeap {
        var heap = [Int]()
        
        init(array: [Int]) {
            self.heap = array
            //print("self.heap: \(self.heap)")
            self.heap = buildHeap(array: array)
        }
        //time O(n) , space O(1)
        func buildHeap(array: [Int]) -> [Int] {
            //start build heap from parent of leaves
            let parentIdx = (self.heap.count - 2) / 2
            for i in stride(from: parentIdx , through: 0, by: -1) {
                //print("index: \(i): \(self.heap[i])")
                siftDown(from: i)
            }
            return self.heap
        }
        //time O(log(n)) , space O(1)
        func siftDown(from startIdx: Int) {
            var currentIdx = startIdx
            var endIdx = self.heap.count
            var childIdx = 2 * currentIdx + 1
            
            while childIdx < endIdx {
                if childIdx + 1 < endIdx && self.heap[childIdx + 1] < self.heap[childIdx] {
                    childIdx += 1
                }
                guard heap[currentIdx] > heap[childIdx] else { break }
                
                self.heap.swapAt(currentIdx, childIdx)
                currentIdx = childIdx
                childIdx = 2 * currentIdx + 1
            }
        }
        //time O(log(n)) , space O(1)
        func siftUp() {
            var currentIdx = self.heap.count - 1
            var parentIdx = (currentIdx - 1) / 2
            
            while currentIdx > 0 && self.heap[currentIdx] < self.heap[parentIdx]  {
                self.heap.swapAt(parentIdx, currentIdx)
                currentIdx = parentIdx
                parentIdx = (currentIdx - 1) / 2
            }
            
        }
          //time O(1), space O(1)
        func peek() -> Int {
            return self.heap.first ?? -1
        }
        //time O(log(n)), space O(1)
        func remove() -> Int {
            guard self.heap.count > 0 else { return -1 }
            self.heap.swapAt(0, self.heap.count - 1)
            defer { self.siftDown(from: 0) }
            return self.heap.removeLast()
        }
        //time O(log(n))
        func insert(value: Int) {
            self.heap.append(value)
            self.siftUp()
        }
    }
    
}
