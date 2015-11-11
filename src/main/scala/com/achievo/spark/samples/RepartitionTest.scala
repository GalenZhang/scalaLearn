package com.achievo.spark.samples
import org.apache.spark.SparkContext
import org.apache.spark.HashPartitioner

/**
 * @author galen.zhang
 */
object RepartitionTest {
  def main(args: Array[String]): Unit = {
    val sc = new SparkContext("local", "repartition Test")
    val data = Array[(Int, Char)]((3, 'a'), (2, 'b'), (1, 'c'), (4, 'd'))
    val pairs1 = sc.parallelize(data, 3).partitionBy(new HashPartitioner(2))
    
    pairs1.zipWithIndex.foreach { case (e, i) => println("[pairs1-Index " + i + "] " + e) }
  }
  
}