package com.achievo.samples

/**
 * @author galen.zhang
 */
object MatchTest {
  def main(args: Array[String]): Unit = {
    val data = 10
    matchNum(data)

    List(0, 1) match {
      case List(0) => println("0")
      case List(0, _) => println("0, _")
      case List(_, _) => println("_, _")
      case List(0, _*) => println("_*")
    }
  }

  def matchNum(value: Any) = value match {
    case 10 => println("10")
    case _: Int => println("Int")
    case _ => println("any data")
  }
}