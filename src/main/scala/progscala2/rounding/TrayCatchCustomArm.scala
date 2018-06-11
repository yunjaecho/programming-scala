package progscala2.rounding

import scala.io.Source
import scala.util.control.NonFatal
import java.io.Closeable

object managed {
  // <: 는 R이 다른 어떤 것의 서브 클래스임을 의미
  // 여기서 close(): Unit 메소드가 들어 있는 구조적 타입(structure type)
  //def apply[R <: {def close(): Unit}, T](resource: => R)(f: R => T) = {
  def apply[R <: Closeable, T](resource: => R)(f: R => T) = {
    var res: Option[R] = None
    try {
      res = Some(resource)
      f(res.get)
    } catch {
      case NonFatal(ex) => println(s"Non fatal exception! $ex")
    } finally {
      if (res != None) {
        println(s"Closing resource..")
        res.get.close()
      }
    }
  }
}

object TryCatchCustomARM extends App {
  def countLines(fileName: String) = {
    println()

    managed(Source.fromResource(fileName)) { source =>
      val size = source.getLines.size
      println(s"file $fileName has $size lines")
      if (size > 500) throw new RuntimeException("Big file!")
    }
  }


  println()
  List("read1.log",
    "read3.log",
    "read2.log")
    .foreach {
         countLines(_)
    }


}
