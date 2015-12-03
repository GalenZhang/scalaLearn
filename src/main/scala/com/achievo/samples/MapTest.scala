package com.achievo.samples

/**
 * @author galen.zhang
 */
object MapTest {
  def main(args: Array[String]): Unit = {
    val file = List("warn 2013 msg", "warn 2012 msg", "error 2013 msg", "warn 2013 msg")

    def wordcount(str: String): Int = str.split(" ").count("msg" == _)

    val num = file.par.map(wordcount).par.reduceLeft(_ + _)

    println("wordcount: " + num)

    val value = List(1, 2, 3, 4, 5).find(_ % 2 == 0)
    if (value.isEmpty) println(value)
    else println(value.get)

    println((0 to 100).foldLeft(0)(_ + _))
    
    println(List(1, -3, 4, 2, 6).sortWith( _ > _))
  }
}