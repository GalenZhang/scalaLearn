package com.achievo.samples

/**
 * @author galen.zhang
 */
object Func {
  val func = new Function1[Int, Int]() {
    def apply(a: Int) = {
      a + 10
    }
  }

  def main(args: Array[String]): Unit = {

    println(func(100))
  }
}

class Func {
  val adder2 = (x: Int, y: Int) => x + y

  def m1 = 100

  val f1 = () => 100

  def m2(f: () => Int) = f()

  val v1 = m2(m1 _)

  val f2: () => Int = m1 _

  def m3(x: Int) = x + 1

  val f3: (Int) => Int = m3

  def m4(f: (Int) => Int) = f(10)

  val v4 = m4(m3)

  def m5(x: => Int) = List(x, x)

  import scala.util.Random

  var r = new Random()

  val v5 = m5(r.nextInt())

  def adder(m: Int, n: Int) = m + n

  (adder _).curried

  def capitalizeAll(args: String*) = {
    args.map { arg =>
      arg.capitalize
    }
  }

  capitalizeAll(List("abc", "test"): _*)

  val map = Map("test" -> "test")
  val value = map.getOrElse("test", "")

  val numbers = List(1, 2, 3, 4, 5)

  def timesTwo(i: Int): Int = i * 2

  numbers.map(timesTwo)

  val a = Array("Hello", "World")
  val b = Array("hello", "world")
  a.corresponds(b)(_.equalsIgnoreCase(_))
}