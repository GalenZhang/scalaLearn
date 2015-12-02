package com.achievo.samples.implicits

/**
 * @author galen.zhang
 */
class ImplicitArgument {
  def main(args: Array[String]): Unit = {
    val a = new A[Int]()
    a.min(10, 20)
  }
}

class A[T] {
  def min(a: T, b: T)(implicit order: T => Ordered[T]) = {
    if (a < b) a else b
  }
}