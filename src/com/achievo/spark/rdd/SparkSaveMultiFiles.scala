package com.achievo.spark.rdd
import org.apache.spark.{ SparkContext, SparkConf }

/**
 * @author galen.zhang
 */
object SparkSaveMultiFiles {

  def main(args: Array[String]) {
    val conf = new SparkConf().setAppName("SparkRDDJoin").setMaster("local");
    val sc = new SparkContext(conf);
    val rdd = sc.textFile("file:///D:/wordcount.txt");
    val result = rdd.filter(_.contains("WordCount"));
    result.foreach(println);
  }
}