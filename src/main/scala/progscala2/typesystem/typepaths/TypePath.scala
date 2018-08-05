package progscala2.typesystem.typepaths

class Service {
  class Logger {
    def log(message: String): Unit = println(s"log : $message")
  }
  val logger: Logger = new Logger
}

object TypePath extends App {
  val s1 = new Service
  val s2 = new Service {
//    override val logger: Logger = s1.logger
  }
}
