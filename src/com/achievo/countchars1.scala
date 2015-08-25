package com.achievo
import scala.io.Source

/**
 * Created by galen.zhang on 8/18/2015.
 */
object countchars1 {
  def main(args: Array[String]) {
    if (args.length > 0) {
      val lines = Source.fromFile(args(0)).getLines().toList
      val longestLine = lines.reduceLeft(
        (a, b) => if (a.length > b.length) a else b
      )

      val maxWidth = widthOfLength(longestLine)
      for (line <- lines) {
        val numSpace = maxWidth - widthOfLength(line)
        val padding = " " * numSpace
        print(padding + line.length + " | " + line)
      }
    }
  }

  def widthOfLength(s: String) = s.length.toString.length
}
