package progscala2.patternmatching

object MatchSeq extends App {
  val nonEmptySeq = Seq(1,2,3,4,5)
  val emptySeq = Seq.empty[Int]
  val nonEmptyList = List(1,2,3,4,5)
  val emptyList2 = Nil
  val emptyList = List.empty[Int]
  val nonEmptyVector = Vector(1,2,3,4,5)
  val emptyVector = Vector.empty[Int]
  val nonEmptyMap = Map("one" -> 1, "two" -> 2, "three" ->3)
  val emptyMap = Map.empty[String, Int]

  def seqToString[T](seq: Seq[T]): String = seq match {
    case head +: tail => s"$head +: " + seqToString(tail)
    case Nil => "Nil"
  }

  def seqToString2[T](seq: Seq[T]): String = seq match {
    case head +: tail => {
      s"($head +: ${seqToString(tail)})"
    }
    case Nil => "Nil"
  }

  for (seq <- Seq(nonEmptySeq,
    emptySeq,
    nonEmptyList,
    emptyList,
    nonEmptyVector,
    emptyVector,
    nonEmptyMap.toSeq,
    emptyMap.toSeq)) yield println(seqToString(seq))

  println("========================")

  for (seq <- Seq(nonEmptySeq,
    emptySeq,
    nonEmptyMap.toSeq,
    emptyMap.toSeq)) yield println(seqToString2(seq))

  println("========================")

  val s1 = (1 +: (2 +: (3 +: (4 +: (5 +: Nil)) )))
  println(s1)
  val s2 = (1 :: (2 :: (3 :: (4 :: (5 :: Nil)) )))
  println(s2)

  val s3 = (("one", 1) +: (("two", 2) +: (("three", 3) +: Nil)))
  val m = Map(s3: _*)
  println(m)
}
