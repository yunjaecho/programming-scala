package progscala2.implicits

object TypeClassesSubtyping {
  trait Stringizer[+T] {
    def stringizer: String
  }

  implicit class AnyStringizer(a: Any) extends Stringizer[Any] {
    override def stringizer: String = a match {
      case s: String => s
      case i: Int => (i*10).toString
      case f: Float => (f*10.1).toString
      case other => throw new UnsupportedOperationException(s"Can't stringize $other")
    }
  }

  def m(pair: Tuple2[Int, String]) = println(pair)

  def main(args: Array[String]): Unit = {
    val list: List[Any] = List(1, 2.2F, "three", 'symbol)

    list.foreach { (x: Any) =>
      try {
        println(s"$x: ${x.stringizer}")
      } catch {
        case e: UnsupportedOperationException => println(e)
      }
    }

    println("=========================================")
    m(1, "two")

    val value1: Int = 1
    val value2 : Long = value1
  }
}
