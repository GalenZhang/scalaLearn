package com.achievo.samples

/**
 * @author galen.zhang
 */
object UserTest {
  def main(args: Array[String]): Unit = {
    val users = List(User("Zhang", "San", 80), User("Li", "Si", 75))
    val result = advance(users)
    println("result: " + result)
  }
  
  def advance(xs: List[User]) = xs match {
    case User(_, _, score1) :: User(_, _, score2) :: _ => score1 - score2
    case _ => 0
  }
}

case class User(firstName: String, lastName: String, score: Int)
