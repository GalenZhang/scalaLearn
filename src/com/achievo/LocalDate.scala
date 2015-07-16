package com.achievo
import java.util.{ Date, Locale }
import java.text.DateFormat
import java.text.DateFormat._

/**
 * @author galen.zhang
 * @Description http://blog.csdn.net/y3wegy/article/details/8024707
 */
object LocalDate {
  def main(args: Array[String]): Unit = {
    val now = new Date
    val df = getDateInstance(LONG, Locale.FRANCE)
    println(df format now)
  }
}