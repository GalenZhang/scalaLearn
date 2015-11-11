package com.achievo.spark.rdd

import org.apache.spark.SparkConf
import org.apache.spark.SparkContext

/**
 * @author galen.zhang
 */
object SparkWordCount {
  def main(args: Array[String]) {
    System.setProperty("hadoop.home.dir", "/home/hadoop/hadoop-2.7.1")
    val conf = new SparkConf()
    conf.setAppName("SparkWordCount").setMaster("local")
    val sc = new SparkContext(conf)
    val rdd1 = sc.textFile("file:///D:/word.in")
    println(rdd1.toDebugString)
    val rdd2 = rdd1.flatMap(_.split(" "))
    println("rdd2: " + rdd2.toDebugString)
    val rdd3 = rdd2.map((_, 1))
    println("rdd3: " + rdd3.toDebugString)
    val rdd4 = rdd3.reduceByKey(_ + _)
    println("rdd4: " + rdd4.toDebugString)
    rdd4.saveAsTextFile("file:///D:/wordout" + System.currentTimeMillis())
    sc.stop()
  }
}