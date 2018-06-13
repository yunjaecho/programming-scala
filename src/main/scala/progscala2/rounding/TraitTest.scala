package progscala2.rounding

class ServiceImportante(name: String) {
  def work(i: Int): Int = {
    println(s"ServiceImportante: Doing importante work! $i")
    i + 1
  }
}

trait Logging {
  def info(message: String): Unit
  def warning(message: String): Unit
  def error(message: String): Unit
}

trait StdoutLogging extends Logging {
  def info(message: String): Unit = println(s"INFO: $message")
  def warning(message: String): Unit = println(s"WARNING: $message")
  def error(message: String): Unit = println(s"ERROR: $message")
}



object TraitTest extends App {
  val service1 = new ServiceImportante("uno")
  (1 to 3) foreach (i => println(s"Result: ${service1.work(i)}"))

  val service2 = new ServiceImportante("dos") with StdoutLogging {
    override def work(i: Int): Int = {
      info(s"Starting work: i = $i")
      val result = super.work(i)
      info(s"Ending work: i = $i, result = $result")
      result
    }
  }

  println("########################################")
  (1 to 3) foreach (i => println(s"Result: ${service2.work(i)}"))
}

