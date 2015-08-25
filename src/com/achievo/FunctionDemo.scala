package com.achievo

/**
 * @author galen.zhang
 * @Description http://blog.csdn.net/y3wegy/article/details/8025380
 */
object FunctionDemo {
  // 定义方法1 
  def function1() {
    println("function1 run!")
  }

  // 定义方法2,效果和function1是一样的,可见Unit的作用void
  def function2(): Unit = {
    println("function2 run!")
  }

  // 定义方法3 
  def function3(a: Int, b: Int): Int = {
    a + b
  }

  /**
   * function4主要是测试=是否什么时候是必须的
   */
  def function4() = {
    println("function4 run!")
  }

  def function5(): Int = {
    2 + 5
  }

  def function6(a: Int, b: Int) = {
    val s = a + b
    println("function6: " + s)
  }

  //定义一个参数,觉得是static 类型的  
  val staticfunction = {
    println("staticfunction run!")
  }

  val value1 = {
    1 + 2 + 3
  }

  val value2 = {
    val a = 1 + 2 + 3
    val b = a + 2
  }

  val value3 = 2 + 3 + 4

  def main(args: Array[String]): Unit = {
    function1
    function2
    println("function3:" + function3(1, 2))
    function4
    println("function5:" + function5)
    val f1 = function6 _
    f1(1, 2)
    //staticfunction //发现无法运行,因为staticfunction是一个参数
    println("staticfunction:" + staticfunction) //输出:(),相对于null  
    println(value1 + ";" + value2 + ";" + value3) //value2=null  
  }
}