package progscala2.typesystem.existentials

/**
  * def double(seq: Seq[String]): Seq[Int] at line 4 and
  * def double(seq: Seq[Int]): Seq[Int] at line 5
  * have same type after erasure: (seq: Seq)Seq
  * def double(seq: Seq[Int]): Seq[Int] = seq map (_ * 2)
  */
/*object Doubler {
  def double(seq: Seq[String]): Seq[Int] = double(seq map (_.toInt))
  def double(seq: Seq[Int]): Seq[Int] = seq map (_ * 2)
}*/


// 가자기 타입
// Seq[_]  => Seq[T] forSome {type T}
// Seq[_ <: A]  => Seq[T] forSome {type T <: A}
// Seq[_ >: Z <: A]  => Seq[T] forSome {type T >: Z <: A}

object Doubler {
  def double(seq: Seq[_]): Seq[Int] = seq match {
    case Nil => Nil
    case head +: tail =>  (toInt(head) * 2) +: double(tail)
  }

  def toInt(x: Any): Int = x match {
    case i: Int => i
    case s: String => s.toInt
    case x => throw new RuntimeException(s"Unexpected list element $x")
  }
}

object TypeErasureWorkaround extends App {
  val result = Doubler.double(Seq("1", "2", "3"))
  println(result)
}
