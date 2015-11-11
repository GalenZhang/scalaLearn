package com.achievo

/**
 * @author galen.zhang
 */
object TimerAnonymous {
  def oncePersecond(callback: () => Unit): Unit = {
    while (true) {
      callback()
      Thread sleep 1000
    }
  }

  def main(args: Array[String]): Unit = {
    oncePersecond(() => println("time flies like an arrow..."))
  }
}