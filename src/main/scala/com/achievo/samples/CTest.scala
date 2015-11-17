package com.achievo.samples

/**
 * @author galen.zhang
 */
class CTest(var x: Int) {
  def getValue = x
}

class Person (name: String) {
  val firstName = name.split(" ")(0)
  val lastName = name.split(" ")(1)
}