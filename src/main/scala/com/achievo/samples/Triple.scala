package com.achievo.samples

/**
 * @author galen.zhang
 */
class Triple[F, S, T](val first: F, val secord: S, val third: T) {

}

object Triple {
  def main(args: Array[String]): Unit = {
    val triple = new Triple("Spark", 3, 3.14)
    val bigData = new Triple[String, String, Char]("Spark", "Hadoop", 'R')

    def getData[T](list: List[T]) = list(list.length / 2)
    println(getData(List("Spark", "Hadoop", 'R')))
    val f = getData[Int] _
    println(f(List(1, 2, 3, 4, 5, 6, 7, 8)))
  }
}