package com.achievo.spark.samples

import org.apache.spark.SparkContext

/**
 * @author galen.zhang
 */
object IntersectionTest {
  def main(args: Array[String]): Unit = {
    val sc = new SparkContext("local", "Intersection Test")
    val a = sc.parallelize(List(1, 2, 3, 4, 5), 3)
    val b = sc.parallelize(List(1, 2, 5, 6), 2)

    val r = a.intersection(b)

    a.zipWithIndex.foreach { case (e, i) => println("[aIndex " + i + "] " + e) }
    b.zipWithIndex.foreach { case (e, i) => println("[bIndex " + i + "] " + e) }
    r.zipWithIndex.foreach { case (e, i) => println("[PartitionIndex " + i + "] " + e) }

    println(r.toDebugString)
  }
}