package com.achievo.samples.either
import scala.io.Source
import java.net.URL

/**
 * @author galen.zhang
 */
object EitherTest {
  def getContent(url: URL): Either[String, Source] =
    if (url.getHost.contains("google"))
      Left("Requested URL is blocked for the good of the people!")
    else
      Right(Source.fromURL(url))

  def main(args: Array[String]): Unit = {
    println(getContent(new URL("http://danielwestheide.com")))
    println(getContent(new URL("https://plus.google.com")))

    getContent(new URL("http://google.com")) match {
      case Left(msg) => println(msg)
      case Right(source) => source.getLines.foreach(println)
    }
    
    println("----------------------------------------------")

    val content: Either[String, Iterator[String]] =
      getContent(new URL("http://danielwestheide.com")).right.map(_.getLines())
    // content is a Right containing the lines from the Source returned by getContent

    val moreContent: Either[String, Iterator[String]] =
      getContent(new URL("http://google.com")).right.map(_.getLines)
    // moreContent is a Left, as already returned by getContent

    // content: Either[String,Iterator[String]] = Right(non-empty iterator)
    // moreContent: Either[String,Iterator[String]] = Left(Requested URL is blocked for the good of the people!)
  }
}