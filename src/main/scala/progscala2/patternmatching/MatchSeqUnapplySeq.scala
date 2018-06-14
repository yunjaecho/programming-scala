package progscala2.patternmatching

object MatchSeqUnapplySeq extends App {
  val nonEmptyList = List(1,2,3,4,5)
  val emptyList = Nil
  val nonEmptyMap = Map("one" -> 1, "two" -> 2, "three" -> 3)

  def window[T](seq: Seq[T]): String = seq match {
    case Seq(head1, head2, _*) =>
      s"($head1, $head2), " + window(seq.tail)
    case Seq(head, _*) =>
      s"($head, _), " + window(seq.tail)
    case Nil => "Nil"
  }

  def window2[T](seq: Seq[T]): String = seq match {
    case head1 +: head2 +: tail =>
      s"($head1, $head2), " + window(seq.tail)
    case head +: tail =>
      s"($head, _), " + window(seq.tail)
    case Nil => "Nil"
  }

  for (seq <- Seq(nonEmptyList, emptyList, nonEmptyMap.toSeq)) {
    println(window(seq))
  }

  println("====================================")

  for (seq <- Seq(nonEmptyList, emptyList, nonEmptyMap.toSeq)) {
    println(window2(seq))
  }
}
