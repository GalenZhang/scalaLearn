package com.achievo

/**
 * @author galen.zhang
 */
class Person(val name: String) {
  def greeting = "Hi" + name
}

object Person {
  val twoCars: Pair[Car] = new Pair(new Car(), new Car())
  val tankAndCar: Pair[Vehicle] = twoCars.replaceFirst(new Tank())
}

class Vehicle {}

class Car extends Vehicle {}

class Tank extends Vehicle {}

class Pair[T](val first: T, val second: T) {
  def replaceFirst[R >: T](newFirst: R): Pair[R] = new Pair[R](newFirst, second)
}