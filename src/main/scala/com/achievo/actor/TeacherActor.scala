package com.achievo.actor

import com.achievo.actor.protocols.TeacherProtocol.QuoteRequest
import com.achievo.actor.protocols.TeacherProtocol.QuoteResponse
import akka.actor.Actor

/**
 * @author galen.zhang
 */
class TeacherActor extends Actor {

  val quotes = List("Moderation is for cowards",
    "Anything worth doing is worth overdoing",
    "The trouble is you think you have time",
    "You never gonna know if you never even try")

  def receive = {
    case QuoteRequest => {
      import util.Random

      //Get a random Quote from the list and construct a response
      val quoteResponse = QuoteResponse(quotes(Random.nextInt(quotes.size)))
      println(quoteResponse)
    }
  }
}