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
  }
}