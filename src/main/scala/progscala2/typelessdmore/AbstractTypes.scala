package progscala2.typelessdmore

import java.io._

abstract class BulkReader {
  type In
  val source: In
  def read: String
}

class StringBulkReader(val source: String) extends BulkReader {
  type In = String
  def read: String = source
}

class FileBulkReader(val source: File) extends BulkReader {
  type In = File
  def read: String = {
    val in = new BufferedInputStream(new FileInputStream(source))
    val numBytes = in.available()
    val bytes = new Array[Byte](numBytes)
    in.read(bytes, 0, numBytes)
    new String(bytes)
  }
}

object AbstractTypes extends App {
  println(new StringBulkReader("Hello Scala!").read)
  println(new FileBulkReader(
    new File("/media/comp1/disk128/housing.data.txt")
  ).read)
}

