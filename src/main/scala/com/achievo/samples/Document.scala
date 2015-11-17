package com.achievo.samples

/**
 * @author galen.zhang
 */
object Title

class Document {
  private var useNextArgAs: Any = null
  def set(obj: Title.type): this.type = { useNextArgAs = obj; this}
  def setTitle(title: String): this.type = { println(title); this}
  def setAuthor(author: String): this.type = { println(author); this}
}

class Book extends Document {
  def addChapter(chapter: String): this.type = { println(chapter); this}
}

object TestDoc
{
  def main(args: Array[String]): Unit = {
    val article = new Document
    article.setTitle("Whatever").setAuthor("Cay");
    
    val book = new Book
    book.setTitle("Scala for").addChapter("hello")
    book.set(Title) 
  }
}