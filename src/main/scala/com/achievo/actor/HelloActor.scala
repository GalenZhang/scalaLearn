package com.achievo.actor
import akka.actor.Actor
import akka.actor.ActorSystem
import akka.actor.Props

/**
 * @author galen.zhang
 */
class HelloActor extends Actor {
  def receive = {
    case "hello" => println("您好！")
    case _ => println("您是?")
  }
}

object Main extends App {
  val system = ActorSystem("HelloSystem")
  val helloActor = system.actorOf(Props[HelloActor], name = "helloactor")
  helloActor ! "hello"
  helloActor ! "喂"
}
