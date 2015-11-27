package com.achievo.samples.akka
import akka.actor.{Actor, ActorSystem, Props}
import com.typesafe.config.ConfigFactory

/**
 * @author galen.zhang
 */
class RemoteEchoServer extends Actor {
  def receive = {
    case msg: String => println("echo " + msg)
  }  
}

object RemoteEchoServer {
  def main(args: Array[String]): Unit = {
    implicit val system = akka.actor.ActorSystem("RemoteSystem", ConfigFactory.load().getConfig("remote"))
    val server = system.actorOf(Props[RemoteEchoServer], name = "echoServer")
    
//    val echoClient = system.actorSelection("akka://RemoteSystem@127.0.0.1:2552/user/echoServer")
    val echoClient = system.actorFor("akka://RemoteSystem@127.0.0.1:2552/user/echoServer")
    echoClient ! "Hi Remote"
    
    system.shutdown()
  }
}