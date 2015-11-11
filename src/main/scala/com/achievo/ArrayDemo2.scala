package com.achievo
import scala.collection.mutable.ArrayBuffer

/**
 * Created by galen.zhang on 8/12/2015.
 */
object ArrayDemo2 {
  def main(args: Array[String]) {
    val b = ArrayBuffer[Int]()
    b += 1
    b += (1,2,3,4,5)
    b ++= Array(8, 13, 21)
    b.trimEnd(5)

    val a = b.toArray
    val c = a.toBuffer
  }
}
