package com.achievo.samples

/**
 * @author galen.zhang
 */
trait TimerTest {
  
}

object Timer {

   def oncePerSecond(callback: () => Unit) {
    var s = 5
        while (s > 0) {callback(); Thread sleep 1000; s = s - 1}
   }

   //作为回调的函数
   def timeFlies() {
       //使用预定义的函数println，而非使用System.out.println(...)
       println("每秒都打印一下..")
   }

   //主函数调用计时器并传递打印句子的函数作为回调，这个程序永无止境的每秒打印一句话
   def main(args: Array[String]) {
//       oncePerSecond(timeFlies)
     oncePerSecond(() => println("每秒都打印一下.."))
   }
}