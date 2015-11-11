package com.achievo

/**
 * @author galen.zhang
 */
class Greeter {
  def hello(name: String = "world") = println("hello " + name)
}

class AnotherClass {
  new Greeter().hello()
}