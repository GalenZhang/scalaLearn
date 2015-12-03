package com.achievo.samples

/**
 * @author galen.zhang
 */
object ListBufer_Queue {
  def main(args: Array[String]): Unit = {
    import scala.collection.mutable.ListBuffer
    val list = new ListBuffer[Int]
    list += 1
    list += 2
    println(list)

    import scala.collection.mutable.ArrayBuffer
    val array = new ArrayBuffer[Int]
    array += 1
    array += 2
    println(array)

    import scala.collection.immutable.Queue
    val empty = Queue[Int]()
    val queue1 = empty.enqueue(1)
    val queue2 = queue1.enqueue(List(2, 3, 4, 5))
    println(queue2)
    val (element, left) = queue2.dequeue
    println(element + " : " + left)
    
    import scala.collection.mutable
    val queue = mutable.Queue[String]()
    queue += "a"
    queue ++= List("b", "c")
    println(queue)
    println(queue.dequeue())
    println(queue)
    
    val stack = mutable.Stack[Int]()
    stack.push(1)
    stack.push(2)
    stack.push(3)
    println(stack.top)
    println(stack)
    println(stack.pop())
    println(stack)
  }
}