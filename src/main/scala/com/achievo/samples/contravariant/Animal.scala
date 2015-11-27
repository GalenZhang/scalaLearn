package com.achievo.samples.contravariant

/**
 * @author galen.zhang
 */
class Animal {
  
}

class Bird extends Animal {}

class Consumer[+T](t: T) {
  def use[U >: T](t: U) = {}
}