package progscala2.implicits

import scala.util.parsing.json.JSONObject
import scala.collection.JavaConverters._

object Interpolators {
  implicit class jsonForStringContext(val sc: StringContext) {
    def json(values: String*): JSONObject = {
      val keyRE = """^[\s{,]*(\S+):\s*""".r
      val keys = sc.parts.map {
        case keyRE(key) => key
        case str => str
      }
      val kvs = (keys zip values)
      JSONObject(kvs.toMap)
    }
  }
}


object CustomStringInterpolator extends App {
  import Interpolators._

  val name = "Dean Wampler"
  val book = "Programming Scala, Second Edition"

  val jsonobj = json"{name: $name, book: $book}"
  println(jsonobj)

}
