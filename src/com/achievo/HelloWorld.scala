package com.achievo

/**
 * @author galen.zhang
 */
object HelloWorld {
  def main(args: Array[String]): Unit = {
    println("Hello world!");

    val strArr = new Array[String](3)
    strArr(0) = "Hello"
    strArr(1) = ", "
    strArr(2) = "world!\n"

    // foreach 的三种写法
    strArr.foreach { str => print(str) }
    
    // 指明变量类型
    strArr.foreach { (str: String) => print(str) }
    
    // 唯一参数传给唯一的方法体，可以省略参数名
    strArr.foreach { print }
    
    // 这里左箭头<-可以读成in
    for (str <- strArr)
      print(str)
      
    for (i <- 0 to 2) 
      print(strArr(i))
  }
}