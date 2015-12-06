package com.achievo.samples.bounds

/**
 * @author galen.zhang
 */
object Structural_Type {
  def main(args: Array[String]): Unit = {
    init(new { def open() = println("Opened") })
    type X = { def open(): Unit }
    def init(res: X) = res.open()

    init(new { def open() = println("Opened inner method") })

    object A { def open() = { println("A single object Opened") } }
    init(A)

    val structural = new Structural
    init(structural)
  }

  def init(res: { def open(): Unit }) {
    res.open()
  }
}

class Structural { def open() = println("A class instance Opened") }