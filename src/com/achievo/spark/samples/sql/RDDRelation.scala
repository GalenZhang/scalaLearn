package com.achievo.spark.samples.sql
import org.apache.spark.{ SparkConf, SparkContext }
import org.apache.spark.sql.SQLContext
import org.apache.spark.sql.functions._

/**
 * @author galen.zhang
 */
case class Record(key: Int, value: String)

object RDDRelation {
  def main(args: Array[String]): Unit = {
    val sparkConf = new SparkConf().setAppName("RDDRelation").setMaster("local")
    val sc = new SparkContext(sparkConf)
    val sqlContext = new SQLContext(sc)

    // Importing the SQL context gives access to all the SQL functions and implicit conversions.
    import sqlContext.implicits._
    val df = sc.parallelize((1 to 100).map(i => Record(i, s"val_$i"))).toDF()
    df.registerTempTable("records")

    println("Result of SELECT *:")
    sqlContext.sql("SELECT * FROM records").collect().foreach(println)

    val count = sqlContext.sql("SELECT COUNT(*) FROM records").collect().head.getLong(0)
    println(s"COUNT(*): $count")

    val rddFromSql = sqlContext.sql("SELECT key, value FROM records WHERE key < 10")
    println("Result of RDD.map:")
    rddFromSql.map(row => s"Key: ${row(0)}, Value: ${row(1)}").collect().foreach(println)
    
    // Queries can also be written using a LINQ-like Scala DSL.
    df.where($"key" === 1).orderBy($"value".asc).select($"key").collect().foreach(println)
  }
}