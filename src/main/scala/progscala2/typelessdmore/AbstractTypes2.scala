package progscala2.typelessdmore

import java.io.{BufferedInputStream, File, FileInputStream}

abstract class BulkReader2[A] {
  val source: A
  def read: String
}

class StringBulkReader2(val source: String) extends BulkReader2[String] {
  type In = String
  def read: String = source
}

class FileBulkReader2(val source: File) extends BulkReader2[File] {
  type In = File
  def read: String = {
    val in = new BufferedInputStream(new FileInputStream(source))
    val numBytes = in.available()
    val bytes = new Array[Byte](numBytes)
    in.read(bytes, 0, numBytes)
    new String(bytes)
  }
}

object AbstractTypes2 extends App {
  println(new StringBulkReader2("Hello Scala!").read)
  println(new FileBulkReader2(
    new File("/media/comp1/disk128/housing.data.txt")
  ).read)
}