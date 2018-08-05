package progscala2.typesystem.higherkindered

trait Reduce1[-M[T]] {
  def reduce[T](m: M[T])(f: (T, T) => T): T
}

object Reduce1 {
  implicit val seqReduce = new Reduce1[Seq] {
    def reduce[T](seq: Seq[T])(f: (T, T) => T): T = seq reduce f
  }

  implicit val optionReduce = new Reduce1[Option] {
    def reduce[T](opt: Option[T])(f: (T, T) => T): T = opt reduce f
  }
}

object Reduce1Test extends App {
  def sum[T: Add, M[_]: Reduce1](container: M[T]): T =
    implicitly[Reduce1[M]].reduce(container)(implicitly[Add[T]].add(_, _))

  println(sum(Vector(1-> 10, 2 -> 20, 3 -> 30)))
  println(sum(1 to 10))
  println(sum(Option(2)))
  //println(sum[Int, Option](None))
}
