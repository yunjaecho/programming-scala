package progscala2.typelessdmore

import scala.concurrent.Future
import scala.concurrent.ExecutionContext.Implicits.global
import scala.util.{Failure, Success}

object Futures extends App {


  def sleep(millis: Long) = {
    Thread.sleep(millis)
  }

  def doWork(index: Int) = {
    sleep((math.random() * 1000).toLong)
    index
  }

  (1 to 5) foreach { index =>
    val future = Future {
      doWork(index)
    }
    future onComplete {
      case Success(answer) => println(s"Success! returned $answer")
      case Failure(e) => println(s"FAILURE! returned : $e")
    }
  }

  sleep(5000)
  println("Finish!")
}
