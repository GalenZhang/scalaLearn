package com.achievo

import java.io.File

/**
 * Created by galen.zhang on 8/19/2015.
 */
object FileMatcher {
  private def filesHere = (new File(".")).listFiles()

  private def filesMathcing(matcher: String => Boolean) =
    for (file <- filesHere; if matcher(file.getName))
      yield file

  def filesEnding(query: String) =
    filesMathcing(_.endsWith(query))

  def filesContaing(query: String) =
    filesMathcing(_.contains(query))

  def filesRegex(query: String) =
    filesMathcing(_.matches(query))

}
