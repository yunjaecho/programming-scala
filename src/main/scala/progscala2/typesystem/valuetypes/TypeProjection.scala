package progscala2.typesystem.valuetypes

trait Logger {
  def log(message: String): Unit
}

class ConsoleLogger extends Logger {
  def log(message: String): Unit = println(s"log : $message")
}

trait Service {
  type Log <: Logger
  val logger: Log
}

class Service1 extends Service {
  type Log = ConsoleLogger
  val logger: ConsoleLogger = new ConsoleLogger
}

object TypeProjection extends App {
  //val l1: Service.Log = new ConsoleLogger
  //val l2: Service1.Log = new ConsoleLogger
  //val l3: Service#Log = new ConsoleLogger
  val l4: Service1#Log = new ConsoleLogger

}
