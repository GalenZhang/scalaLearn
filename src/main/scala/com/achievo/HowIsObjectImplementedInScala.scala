package com.achievo

/**
 * @author galen.zhang
 */
object HowIsObjectImplementedInScala {
  def printSomething() {
    println("printSomething")
    val words = scala.io.Source.fromFile("d:/BugReport.txt").mkString
    
    val matrix = Array.ofDim[Double](3, 4)
    matrix.grouped(5)
    
    val array = Array(1, 2, 3, 4)
    val groups = array.grouped(2)
    val list = groups.toList
    
    import scala.collection.JavaConversions.bufferAsJavaList
    import scala.collection.mutable.ArrayBuffer
    val command = ArrayBuffer("ls", "-al", "/home/zheng")
    val pb = new ProcessBuilder(command)  

  }
}