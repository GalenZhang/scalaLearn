package com.achievo

/**
 * @author galen.zhang
 */
object Bartender {
  def main(args: Array[String]): Unit = {
    var gin: Liquor = new Liquor("Gin")
    var tonic: Liquor = new Liquor("Tonic")
    var mixed = gin.mix(tonic)
    println(mixed)
  }
}

class Liquor(name: String) {
  def mix(rho: Liquor): String = {
    this.name + " and " + rho.getName
  }
  def getName(): String = this.name
}