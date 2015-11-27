package com.achievo.samples.akka
import akka.actor.{Actor, Props, ActorSystem}
import akka.testkit.CallingThreadDispatcher

/**
 * @author galen.zhang
 */
class MultiEchoServer(name: String) extends Actor {
  def receive = {
    case msg => println("Server" + name + " echo " + msg + " by " + Thread.currentThread().getName)
  }
}

object MultiEchoDemo {
  def main(args: Array[String]): Unit = {
    implicit val system = ActorSystem()
    val echoServers = (1 to 10).map(x => system.actorOf(Props(new MultiEchoServer(x.toString()))
      .withDispatcher(CallingThreadDispatcher.Id)))
    
    List(1 to 10: _*).foreach(msg => echoServers(scala.util.Random.nextInt(10)) ! msg.toString())
    system.shutdown()
  }
}