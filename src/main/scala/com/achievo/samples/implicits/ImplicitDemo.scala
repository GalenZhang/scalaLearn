package com.achievo.samples.implicits

/**
 * @author galen.zhang
 */
object ImplicitDemo {
  def display(input: String): Unit = println(input)

  implicit def typeConvertor(input: Int): String = input.toString

  implicit def typeConvertor(input: Boolean): String = if (input) "true" else "false"

//  implicit def booleanTypeConvertor(input: Boolean): String = if (input) "true" else "false"

  def main(args: Array[String]): Unit = {
    display("1212")
    display(12)
    display(true)
  }
}