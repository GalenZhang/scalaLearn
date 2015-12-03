package com.achievo.samples

/**
 * @author galen.zhang
 */
object SeqCollect {
  def wordsWithoutOutliers(wordFrequencies: Seq[(String, Int)]): Seq[String] =
    wordFrequencies.collect { case (word, freq) if freq > 3 && freq < 25 => word }

  def main(args: Array[String]): Unit = {
    val wordFrequencies = ("habitual", 6) :: ("and", 56) :: ("consuetudinary", 2) ::
      ("additionally", 27) :: ("homely", 5) :: ("society", 13) :: Nil
    println(wordsWithoutOutliers(wordFrequencies)) // List("habitual", "homely", "society")

    val greeting: Option[String] = Some("Hello world")
    val absentGreeting: Option[String] = Option(null)
    val presentGreeting: Option[String] = Option("Hello!")
  }
}

class SeqCollect