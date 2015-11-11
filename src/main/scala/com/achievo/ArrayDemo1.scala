package com.achievo

/**
 * @author galen.zhang
 */
object ArrayDemo1 {
  def ergodic1(array: Array[Int]) {
    println("ergodic1 run!")
    var i = 0
    while (i < array.length) {
      println(array(i))
      i += 1
    }
  }

  def ergodic2(array: Array[Int]) {
    println("ergodic2 run!")
    array.foreach(value => println(value))
  }

  def ergodic3(array: Array[Int]) {
    println("ergodic3 run!")
    array.foreach(println)
  }

  def ergodic4(array: Array[Int]) {
    println("ergodic4 run!")
    for (arg <- array) {
      println(arg)
    }
  }

  def main(args: Array[String]): Unit = {
    var array = new Array[Int](3)
    array(0) = 1
    array(1) = 2
    array(2) = 3
    ergodic1(array)
    ergodic2(array)
    ergodic3(array)
    ergodic4(array)
  }
}