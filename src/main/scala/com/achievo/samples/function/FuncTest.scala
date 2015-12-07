package com.achievo.samples.function

/**
 * @author galen.zhang
 */
object FuncTest {
  type EmailFilter = Email => Boolean

  def newMailsForUser(mails: Seq[Email], f: EmailFilter) = mails.filter(f)

  val sentByOneOf: Set[String] => EmailFilter =
    senders =>
      email => senders.contains(email.sender)

  val notSentByAnyOf: Set[String] => EmailFilter =
    senders =>
      email => !senders.contains(email.sender)

  val minimunSize: Int => EmailFilter =
    n =>
      email => email.text.size >= n

  val maximumSize: Int => EmailFilter =
    n =>
      email => email.text.size <= n

  type SizeChecker = Int => Boolean

  val sizeConstraint: SizeChecker => EmailFilter =
    f =>
      email => f(email.text.size)

  def main(args: Array[String]): Unit = {
    val emailFilter: EmailFilter = notSentByAnyOf(Set("johndoe@example.com"))
    val mails = Email(
      subject = "It's me again, your stalker friend!",
      text = "Hello my friend! How are you?",
      sender = "johndoe@example.com",
      recipient = "me@example.com") :: Nil
    println(newMailsForUser(mails, emailFilter))
  }
}

case class Email(subject: String, text: String, sender: String, recipient: String)


