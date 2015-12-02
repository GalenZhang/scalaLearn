package com.achievo.samples

/**
 * @author galen.zhang
 */
class Foo(val name: String, val age: Int, val sex: Symbol) {

}

object Foo {
  def apply(name: String, age: Int, sex: Symbol) = new Foo(name, age, sex)

  def main(args: Array[String]): Unit = {
    val fooList = Foo("Hugh Jass", 25, 'male) ::
      Foo("Biggus Dickus", 43, 'male) ::
      Foo("Incontinentia Buttocks", 37, 'female) ::
      Nil

    val stringList = fooList.foldLeft(List[String]()) { (z, f) =>
      val title = f.sex match {
        case 'male => "Mr."
        case 'female => "Ms."
      }
      z :+ s"$title ${f.name}, ${f.age}"
    }

    stringList.foreach(println)
    println("hello")

  }
}