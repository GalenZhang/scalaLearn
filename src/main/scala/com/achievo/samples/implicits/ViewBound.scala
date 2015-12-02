package com.achievo.samples.implicits

/**
 * @author galen.zhang
 */
object ViewBound {
  def max[T <% Ordered[T]](a: T, b: T) = {
    if (a.compare(b) < 0) a else b
  }

  def main(args: Array[String]): Unit = {
    implicit def toOrdered(a: B) = new Ordered[B] {
      override def compare(that: B): Int = a.weight - that.weight
    }

    println(max(new B(300), new B(400)).weight)
  }
}

class B(val weight: Int) 