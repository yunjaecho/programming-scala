package progscala2.rounding

import scala.io.Source
import scala.util.control.NonFatal

object TryCatch extends App {
  def countLines(fileName: String) = {
    println()
    var source: Option[Source] = None
    try {
      source = Some(Source.fromResource(fileName))
      val size = source.get.getLines.size
      println(s"file $fileName has $size lines")
    } catch {
      case NonFatal(ex) => println(s"Non fatal exception! $ex")
    } finally {
      for (s <- source) {
        println(s"Closing $fileName")
        s.close
      }
    }
  }

  List("read1.log",
    "read3.log",
    "read2.log").foreach(countLines(_))
}
