package com.achievo

/**
 * @author galen.zhang
 */
object ArrayDemo {
  var array = new Array[Int](3)
  var array2 = new Array[Int](3)
  var array3 = new Array[Int](3)

  def init1() {
    array(0) = 1
    array(1) = 2
    array(2) = 3
  }

  def init2() {
    array2.update(0, 4)
    array2.update(1, 5)
    array2.update(2, 6)
  }
  
  def out(array: Array[Int]) {
    val length = array.length
    for (i <- 0 to length -1)
      println(array.apply(i))
  }
  
  def main(args: Array[String]): Unit = {
    out(array3)
    init1()
    out(array)
    init2()
    out(array2)
  }
}