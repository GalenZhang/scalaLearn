package com.achievo.samples

import scala.collection.mutable

/**
 * @author galen.zhang
 */
object Set_Map {
  def main(args: Array[String]): Unit = {
    import scala.collection.mutable
    val data = mutable.Set.empty[Int]
    data ++= List(1, 2, 3)
    data += 4
    data --= List(2, 3)
    println(data)
    data += 1
    println(data)
    data.clear()
    println(data)

    val map = mutable.Map.empty[String, String]
    map("Java") = "Hadoop"
    map("Scala") = "Spark"
    println(map)
    println(map("Scala"))
    println(map.getOrElse("Java", "None"))

    import scala.collection.immutable.TreeSet
    val treeSet = TreeSet(9, 3, 1, 8, 0, 2, 7, 4, 6, 5)
    println(treeSet)
    val treeSetForChar = TreeSet("Spark", "Scala", "Hadoop")
    println(treeSetForChar)
    
    import scala.collection.immutable.TreeMap
    val treeMap = TreeMap("Scala" -> "Spark", "Java" -> "Hadoop")
    println(treeMap)
  }
}