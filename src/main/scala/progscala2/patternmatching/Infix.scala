package progscala2.patternmatching

object Infix extends App {
  def processSeq2[T](l: Seq[T]): Unit = l match {
    case +:(head, tail) =>
      printf("%s +:", head)
      processSeq2(tail)
    case Nil => print("Nil")
  }

  processSeq2(List(1,2,3,4,5))
  println()
  println("=====================")

  case class With[A, B](a: A, b: B)

  //val with1: With[String, Int] = With("Food", 1)
  val with1 = With("Food", 1)
  val with2: String With Int = With("Bar", 2)

  Seq(with1, with2) foreach { w =>
    w match {
      case s With i => println(s"$s with $i")
      case _ => println(s"Unknown: $w")
    }
  }


  println(List(1,2,3) :+ 4)
}
