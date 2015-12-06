package com.achievo.samples.bounds

/**
 * @author galen.zhang
 */
object Multiple_Bounds {
  def main(args: Array[String]): Unit = {
    implicit val a = new M_A[Int]
    implicit val b = new M_B[Int]
    def foo[T: M_A : M_B](i: T) = println("OK")
    foo(2)
  }
}

class M_A[T]

class M_B[T]