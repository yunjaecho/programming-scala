package progscala2.typesystem.higherkindered

import scala.language.higherKinds

trait Reduce[T, -M[T]] {
  def reduce(m: M[T])(f: (T, T) => T): T
}

object Reduce {
  implicit def seqReduce[T] = new Reduce[T, Seq] {
    def reduce(seq: Seq[T])(f: (T, T) => T): T = seq reduce f
  }

  implicit def OptionReduce[T] = new Reduce[T, Option] {
    def reduce(opt: Option[T])(f: (T, T) => T): T = opt reduce f
  }
}

object ReduceTest extends App {
  def sum[T: Add, M[T]](container: M[T])(implicit red: Reduce[T, M]): T =
    red.reduce(container)(implicitly[Add[T]].add(_ , _))


  println(sum(Vector(1-> 10, 2 -> 20, 3 -> 30)))
  println(sum(1 to 10))
  println(sum(Option(2)))
}
