package com.achievo.samples.futher
import scala.concurrent.Promise
import scala.concurrent.Future
import scala.concurrent.ExecutionContext.Implicits.global
import scala.util.{Success, Failure}

/**
 * @author galen.zhang
 */
object PromiseTest {
  def main(args: Array[String]): Unit = {
    // either give the type as a type parameter to the factory method:
    val taxcut = Promise[TaxCut]()
    // or give the compiler a hint by specifying the type of your val:
    val taxcut2: Promise[TaxCut] = Promise()
    // taxcut: scala.concurrent.Promise[TaxCut] = scala.concurrent.impl.Promise$DefaultPromise@66ae2a84
    // taxcut2: scala.concurrent.Promise[TaxCut] = scala.concurrent.impl.Promise$DefaultPromise@346974c6

    val taxCufF: Future[TaxCut] = taxcut.future
    taxcut.success(TaxCut(20))

    val taxCutFx: Future[TaxCut] = Government.redeemCampaignPledge()
    println("Now that they're elected, let's see if they remember their promises...")
    taxCutFx.onComplete { 
      case Success(TaxCut(reduction)) =>
        println(s"A miracle! They really cut our taxes by $reduction percentage points!")
      case Failure(ex) => 
        println(s"They broke their promises! Again! Because of a ${ex.getMessage}")
    }
    
    println("------------------------------------------------------")
    Thread.sleep(3000)
  }
}

object Government {
  def redeemCampaignPledge(): Future[TaxCut] = {
    val p = Promise[TaxCut]()
    Future {
      println("Starting the new legislative period.")
      Thread.sleep(2000)
//      p.success(TaxCut(20))
      p.failure(LameExcuse("global economy crisis"))
      println("We reduced the taxes! You must reelect us!!!!1111")
    }
    p.future
  }
}

case class TaxCut(reduction: Int)

case class LameExcuse(msg: String) extends Exception(msg)
