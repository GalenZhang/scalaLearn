package com.achievo.samples.akka
import akka.actor.Actor
import akka.actor.ActorSystem
import akka.actor.ActorLogging
import akka.actor.Props
import akka.event.Logging.LogEvent
import akka.event.Logging.StdOutLogger

/**
 * @author galen.zhang
 */
class TeacherActor extends Actor {
  val quotes = List(
    "Moderation is for cowards",
    "Anything worth doing is worth overdoing",
    "The trouble is you think you have time",
    "You never gonna know if you never even try")

  def receive = {
    case TeacherProtocol.QuoteRequest => {
      import util.Random

      val quoteResponse = TeacherProtocol.QuoteResponse(quotes(Random.nextInt(quotes.size)))

      println(quoteResponse)

    }
  }
}

class TeacherLogActor extends Actor with ActorLogging {
  val quotes = List(
    "Moderation is for cowards",
    "Anything worth doing is worth overdoing",
    "The trouble is you think you have time",
    "You never gonna know if you never even try")

  def receive = {
    case TeacherProtocol.QuoteRequest => {
      import util.Random

      val quoteResponse = TeacherProtocol.QuoteResponse(quotes(Random.nextInt(quotes.size)))
      log.info(quoteResponse.toString())
    }
  }

  def quoteList = quotes
}

class DefaultLogger extends Actor with StdOutLogger {
  override def receive: Receive = {
    case event: LogEvent => print(event)
  }
}

object TeacherProtocol {
  case class QuoteRequest()
  case class QuoteResponse(quoteString: String)
}

object StudentSimulatorApp extends App {
  val actorSystem = ActorSystem("UniversityMessageSystem")
  val teacherActorRef = actorSystem.actorOf(Props[TeacherLogActor])
  teacherActorRef ! TeacherProtocol.QuoteRequest
  
  Thread.sleep(2000)
  actorSystem.shutdown()
} 
