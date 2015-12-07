package com.achievo.samples.futher
import scala.concurrent.Future
import scala.concurrent.future
import scala.concurrent.duration._
import scala.concurrent.Await
import scala.util.{ Success, Failure }
import scala.concurrent.ExecutionContext.Implicits.global

/**
 * @author galen.zhang
 */
object ThreadTest {

  def grind(): Future[Int] = Future {
    println("Sub thread start......")
    Thread.sleep(1000)
    println("Sub thread over......")
    10
  }

  def main(args: Array[String]): Unit = {
    println("Start...")
    val res = grind()
    //    println(Await result (grind(), 1 seconds))
    println("end...")

    val mFuture = future {
      Thread sleep 1000
      "result"
    }

    mFuture.onComplete {
      case Success(result) => println("result success")
      case Failure(ex) => println("result failure")
    }

    val result = Await result (mFuture, 3 seconds)
    println("main method: " + result)
  }
}