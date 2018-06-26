package progscala2.fp.datastructs

import scala.annotation.tailrec

object foldImpl extends App {
  // 구현을 단순화했기 때문에
  // Seq[A]로 받은 컬렉션으니 구체적인 타입과 일치하는 타입을 출력으로 내놓지 않음
  def reduceLeft[A, B](s: Seq[A])(f: A => B): Seq[B] = {
    @tailrec
    def r1(accum: Seq[B], s2: Seq[A]): Seq[B] = s2 match {
      case head +: tail => r1(f(head) +: accum, tail)
      case _ => accum
    }

    r1(Seq.empty[B], s)
  }

  def reduceRight[A, B](s: Seq[A])(f: A => B): Seq[B] = s match {
    case head +: tail => f(head) +: reduceRight(tail)(f)
    case _ => Seq.empty[B]
  }

  val list = List(1,2,3,4,5,6)
  println(reduceLeft (list) (i => 2 * i))
  println(reduceRight (list) (i => 2 * i))

}
