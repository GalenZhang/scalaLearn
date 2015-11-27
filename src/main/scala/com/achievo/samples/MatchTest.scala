package com.achievo.samples
import scala.util.matching.Regex

/**
 * @author galen.zhang
 */
object Email {
  def unapply(str: String) = new Regex("""(.*)@(.*)""")
    .unapplySeq(str).get match {
    case user :: domain :: Nil => Some(user, domain)
    case _ => None
  }
}
object MatchTest {
  def main(args: Array[String]): Unit = {
    "user@domain.com" match {
      case Email(user, domain) => println(user + "@" + domain)
    }
    
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