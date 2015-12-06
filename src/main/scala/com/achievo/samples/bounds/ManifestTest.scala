package com.achievo.samples.bounds
import scala.reflect.ClassTag

/**
 * @author galen.zhang
 */
object ManifestTest {
  def arrayMake[T: Manifest](first: T, second: T) = {
    val r = new Array[T](2); r(0) = first; r(1) = second
    r
  }

  def manif[T](x: List[T])(implicit m: Manifest[T]) = {
    if (m <:< manifest[String])
      println("List strings")
    else
      println("Some other type")
  }

  def mkArray[T: ClassTag](elems: T*) = Array[T](elems: _*)

  def main(args: Array[String]): Unit = {
    arrayMake(1, 2).foreach(println)

    manif(List("Spark", "Hadoop"))
    manif(List(1, 2))
    manif(List("Scala", 3))

    val m = manifest[A[String]]
    println(m)
    val cm = classManifest[A[String]]
    println(cm)

    mkArray(50, 150)
  }
}

class A[T]