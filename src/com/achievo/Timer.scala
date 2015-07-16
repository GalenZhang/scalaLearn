package com.achievo

/**
 * @author galen.zhang
 */
object Timer {
  def oncePersecond(callback: () => Unit): Unit = {
    while (true) {
      callback()
      Thread sleep 1000
    }
  }

  def timeFiles() {
    println("time files like an arrow...")
  }

  def main(args: Array[String]): Unit = {
    oncePersecond(timeFiles)
  }
}