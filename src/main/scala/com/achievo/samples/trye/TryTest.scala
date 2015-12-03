package com.achievo.samples.trye
import scala.util.Try
import java.net.URL
import java.io.InputStream
import scala.io.Source
import scala.util.Success
import scala.util.Failure
import java.net.MalformedURLException
import java.io.FileNotFoundException

/**
 * @author galen.zhang
 */
object TryTest {
  def parseURL(url: String): Try[URL] = Try(new URL(url))

  def parseHttpURL(url: String) = parseURL(url).filter(_.getProtocol == "http")

  def getURLContent(url: String): Try[Iterator[String]] =
    for {
      url <- parseURL(url)
      connection <- Try(url.openConnection())
      is <- Try(connection.getInputStream)
      source = Source.fromInputStream(is)
    } yield source.getLines()

  def getURLContent1(url: String): Try[Iterator[String]] =
    for {
      url <- parseURL(url)
      source = Source.fromURL(url)
    } yield source.getLines()

  def inputStreamForURL(url: String): Try[Try[Try[InputStream]]] = parseURL(url).map { u =>
    Try(u.openConnection()).map(conn => Try(conn.getInputStream))
  }

  def inputStreamForURL1(url: String): Try[InputStream] =
    parseURL(url).flatMap { u =>
      Try(u.openConnection()).flatMap(conn => Try(conn.getInputStream))
    }

  def main(args: Array[String]): Unit = {
    println(parseURL("http://danielwestheide.com"))
    println(parseURL("garbage"))

    println(parseURL("http://danielwestheide.com").map(_.getProtocol))
    // results in Success("http")
    println(parseURL("garbage").map(_.getProtocol))
    // results in Failure(java.net.MalformedURLException: no protocol: garbage)

    println(parseHttpURL("http://apache.openmirror.de")) // results in a Success[URL]
    println(parseHttpURL("ftp://mirror.netcologne.de/apache.org")) // results in a Failure[URL]

    parseHttpURL("http://danielwestheide.com").foreach(println)
    parseHttpURL("ftp://mirror.netcologne.de/apache.org").foreach(println)
    println("------------------------------------------")

    getURLContent("http://danielwestheide.com/foobar") match {
      case Success(lines) => lines.foreach(println)
      case Failure(ex) => println(s"Problem rendering URL content: ${ex.getMessage}")
    }

    val content = getURLContent("garbage") recover {
      case e: FileNotFoundException => Iterator("Requested page does not exist")
      case e: MalformedURLException => Iterator("Please make sure to enter a valid URL")
      case _ => Iterator("An unexpected error has occurred. We are so sorry!")
    }
    println(content)
    content.get.foreach(println)
  }
}