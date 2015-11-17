package com.achievo.spark.rdd
import org.apache.spark.SparkConf
import org.apache.spark.SparkContext

/**
 * @author galen.zhang
 */
object SimpleApp {
  def main(args: Array[String]): Unit = {
    val logFile = "file:///home/hadoop/temp/README.md"
    val conf = new SparkConf().setAppName("Simple Application").setMaster("local[*]")
    val sc = new SparkContext(conf)
    val logData = sc.textFile(logFile, 2).cache()
    val numAs = logData.filter(line => line.contains("a")).count()
    val numBs = logData.filter(line => line.contains("b")).count()
    println("Lines with a: %s, Lines with b: %s".format(numAs, numBs))
  }
}