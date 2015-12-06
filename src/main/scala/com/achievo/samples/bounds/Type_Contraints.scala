package com.achievo.samples.bounds

/**
 * @author galen.zhang
 */
object Type_Contraints {
  def main(args: Array[String]): Unit = {
    //A =:= B 表示A类型等同于B类型
    //A <:< B 表示A类型是B类型的子类型
    def rocky[T](i: T)(implicit ev: T <:< java.io.Serializable) {
      println("Type contraints.")
    }

    rocky("Spark")
//        rocky(100)
  }
}