package com.achievo.actor.protocols

/**
 * @author galen.zhang
 */
object TeacherProtocol {
  /*
   * The Student sends this message to request for a Quotation 
   * 
   */
  case class QuoteRequest()

  /* 
   * The TeacherActor responds back to the Student with this message object
   * The actual quote string is wrapped inside the response.
   * 
   */
  case class QuoteResponse(quoteString: String)
}