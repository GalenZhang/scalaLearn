package com.achievo.samples

/**
 * @author galen.zhang
 */
class ListTest {
  
}

object ListTest {
  def main(args: Array[String]): Unit = {
    val list = List("Hadoop", "Hive", "HBase", "Flume")
    println(list.head)
    println(list.last)
    println(list.init)
    println(list.tail)
    println(list.count(_.length() > 5))
    println(list.splitAt(2))
    
    val data = List('a', 'b', 'c', 'd', 'e', 'f')
    println(data.indices)
    println(data.indices zip data)
    println(data.zipWithIndex)
    
    val buffer = new StringBuilder
    data.addString(buffer, "(", ";;", ")")
    println(buffer)
    
    val array = new Array[Char](10)
    data.copyToArray(array, 3)
    array.foreach(print)
  }
}