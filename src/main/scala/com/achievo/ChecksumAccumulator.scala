package com.achievo
import scala.collection.mutable.Map

/**
 * @author galen.zhang
 */
class ChecksumAccumulator {
  private var sum = 0
  def add(b: Byte): Unit = sum += b
  def checksum(): Int = ~(sum & 0xFF) + 1
}

object ChecksumAccumulator {
  private val cache = Map[String, Int]()
  def calculate(s: String): Int = {
    if (cache.contains(s))
      cache(s)
    else {
      val acc = new ChecksumAccumulator
      for (c <- s)
      {
        acc.add(c.toByte)
        println(c)
      }  
      val cs = acc.checksum()
      cache += (s -> cs)
      cs
    }
  }

  def main(args: Array[String]): Unit = {
    var str = ChecksumAccumulator.calculate("Welcome to Scala Chinese community")
    println(str)
  }
}
