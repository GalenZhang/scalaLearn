package com.achievo.spark.samples

import org.apache.spark._
import org.apache.spark.streaming.{Seconds, StreamingContext}

/**
 * Created by galen.zhang on 8/6/2015.
 */
object SecondarySort {
  def main(args: Array[String]) {
    val conf = new SparkConf().setMaster("local[2]").setAppName("SecondarySort")
    val sc = new SparkContext(conf)

    val lines = sc.textFile("file///home/hadoop/temp/data.txt")
    val result = lines.map{words => val datas = words.split(","); (datas(0) + datas(1), datas(2))}.reduceByKey(_ + "," + _).collect()
  }
}
