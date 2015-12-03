package com.achievo.samples

/**
 * @author galen.zhang
 */
object ListObjectOps {
  def main(args: Array[String]): Unit = {
    println(List.make(5, 5))
    println(List.range(1, 5))

    val zipped = "abcde".toList zip List(1, 2, 3, 4, 5)
    println(zipped)
    println(zipped.unzip)

    println(List.map2(List(10, 20), List(10, 10))(_ * _))
    println((List(10, 20), List(10, 10)).zipped.map(_ * _))
  }
}