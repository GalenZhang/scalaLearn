package com.achievo.samples.user

/**
 * @author galen.zhang
 */
trait Prompter1 {
  val prompt = ">"
  val greeting = "Hello world"

  def printGreeting() {
    println(prompt + greeting)
  }
}

trait Prompter2 {
  this: GreetingProvider =>

  val prompt = ">"

  def printGreeting() {
    println(prompt + greeting)
  }
}

trait GreetingProvider {
  val greeting = "Hello world"
}

object Prompter {
  def main(args: Array[String]): Unit = {
    val prompter1 = new Object with Prompter1
    prompter1.printGreeting()

    val prompter2 = new Prompter2 with GreetingProvider
    prompter2.printGreeting()

    val prompter2backwards = new GreetingProvider with Prompter2
    prompter2backwards.printGreeting
  }
}