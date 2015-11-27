package com.achievo.samples.akka
import akka.actor.{Actor, ActorSystem, Props}

/**
 * @author galen.zhang
 */
class EchoServer extends Actor {
  def receive = {
    case msg: String => println("echo: " + msg)
  }
}

object EchoDemo {
  def main(args: Array[String]): Unit = {
    val system = ActorSystem()
    val echoServer = system.actorOf(Props[EchoServer])
    echoServer ! "hi"
    system.shutdown()
  }
}

object EchoServer {
  def main(args: Array[String]): Unit = {
    import akka.actor.ActorDSL._
    implicit val system = ActorSystem()
    
    val echoServer = actor(new Act {
      become {
        case msg => println("echo: " + msg)
      }
    })
    
    echoServer ! "hi"
    system.shutdown()
  }
}