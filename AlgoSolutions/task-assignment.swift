//https://www.algoexpert.io/questions/task-assignment
class Program {
func taskAssignment(_ k: Int, _ tasks: [Int]) -> [[Int]] {
    //sort tasks map with index and sorted by value
    let sortedTasks = tasks.enumerated()
        .map{($0.offset, $0.element)}
        .sorted(by: {$0.1 < $1.1})
    
    //pairs
    var paris = [[Int]]()
    let count = sortedTasks.count - 1
    
    //list tasks
    for i in 0..<k {
        paris.append([
                      sortedTasks[i].0,
                      sortedTasks[count - i].0
                     ])
    }
 
    return paris
  }


func testTaskAssignment() {
   let tasks = [1, 3, 5, 3, 1, 4]
   let result =  taskAssignment(3, tasks);
    print(result)
}


}
