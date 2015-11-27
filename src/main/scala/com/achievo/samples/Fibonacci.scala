package com.achievo.samples

/**
 * @author galen.zhang
 */
object Fibonacci {
  def fibonacci(value: Any): Int = value match {
    case 0 => 0
    case 1 => 1
    case x: Int if x > 1 => fibonacci(x - 1) + fibonacci(x - 2)
    case _ => 0
  }
  
  def main(args: Array[String]): Unit = {
    println(fibonacci(3))
  }
}