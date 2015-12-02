package com.achievo.samples.implicits
import java.util.Comparator

/**
 * @author galen.zhang
 */
class ContextBound {
  def max[T: Comparator](a: T, b: T) = {
    val c = implicitly[Comparator[T]]
    if (c.compare(a, b) < 0) b else a
  }

  def main(args: Array[String]): Unit = {
    //implicitly查找的是类型为Comparator[T]的隐式值，而不是隐式类型转换函数  
    implicit val toComparator = new Comparator[C] {
      override def compare(o1: C, o2: C): Int = o1.weight - o2.weight
    }

    println(max(new C(300), new C(400)).weight)
  }
}

class C(val weight: Int)