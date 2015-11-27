package com.achievo.samples.akka
import akka.actor.ActorDSL._
import akka.pattern.ask

/**
 * @author galen.zhang
 */
object AskServer {
  def main(args: Array[String]): Unit = {
    implicit val ec = scala.concurrent.ExecutionContext.Implicits.global
    implicit val system = akka.actor.ActorSystem()
    
    val versionUrl = "http://www.baidu.com"
    
    val formURL = actor(new Act {
      become {
        case url: String => sender ! scala.io.Source.fromURL(url).getLines().mkString("\n")
      }
    })
    
    val version = formURL.ask(versionUrl)(akka.util.Timeout(5 * 1000))
    
//    version.foreach(println _)
//    system.shutdown()
    version onComplete {
      case msg => println(msg); system.shutdown()
    }
  }
}