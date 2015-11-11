package com.achievo

/**
 * @author galen.zhang
 */
abstract class Nat {
  def isZero: Boolean
  def pred: Nat
  def succ: Nat = new Succ(this)
  def +(x: Nat): Nat =
    if (x.isZero) this else succ + x.pred
  def -(x: Nat): Nat =
    if (x.isZero) this else pred - x.pred
}

class Succ(n: Nat) extends Nat {
  def isZero: Boolean = false
  def pred: Nat = n
  override def toString: String = "Succ(" + n + ")"
}

object Zero extends Nat {
  def isZero: Boolean = true
  def pred: Nat = throw new Error("Zero.pred")
  override def toString: String = "Zero"
}