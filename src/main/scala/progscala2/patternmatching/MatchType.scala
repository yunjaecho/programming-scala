package progscala2.patternmatching

object MatchType extends App {
  // 타입 소거 발생
  // List("a", "b") List[String] 인지 알수 없 음
  // Seq 첫번째 요소의 타입으로 처리됨

  for (x <- Seq(List(5.5, 6.5, 5.7), List("a", "b"))) yield {
    println(
    x match {
      case seqd: Seq[Double] => ("seq string", seqd)
      case seqd: Seq[String] => ("seq double", seqd)
      case _ => ("unknown", x)
    }
    )
  }
  println("==============================================")


  // head의 원소에 대한 매치를 내포시켜서 head의 타입으로 부터 리스트의 타입을 결정하는 것이다.
  def doSeqMatch[T](seq: Seq[T]): String = seq match {
    case Nil => "Nothing"
    case head +: _ => head match {
      case _: Double => "Double"
      case _: String => "String"
      case _ => "Unmatched seq element"
    }
  }

  for (x <- Seq(List(5.5, 6.5, 5.7), List("a", "b"))) yield {
    println(
      x match {
        case seq: Seq[_] => (s"seq ${doSeqMatch(seq)}", seq)
        case _ => ("unknown", x)
      }
    )
  }

}
