package progscala2.typesystem.higherkindered

trait Add[T] {
  def add(t1: T, T2: T): T
}

object Add {
  implicit val addInt = new Add[Int] {
    def add(i1: Int, i2: Int): Int = i1 + i2
  }

  implicit val addIntIntParir = new Add[(Int, Int)] {
    def add(p1: (Int, Int), p2: (Int, Int)): (Int, Int) =
      (p1._1 + p2._1, p1._2 + p2._2)
  }


}

object AddTest extends App {
  def sumSeq[T: Add](seq: Seq[T]): T =
    seq reduce(implicitly[Add[T]].add(_, _))

  sumSeq(Vector(1-> 10, 2 -> 20, 3 -> 30))
  sumSeq(1 to 10)
  //sumSeq(Option(2))
}
