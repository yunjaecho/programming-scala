package progscala2.fp.curry

object LiftedFunc extends App {
  val finicky: PartialFunction[String, String] = {
    case "finicky" => "FINICKY"
  }

  finicky("finicky")

  finicky("other")

  // 부분함수 Option 적용 (함수를 끌어올리기)
  val finickyOption = finicky.lift

  finickyOption("finicky")

  finickyOption("other")

  Seq(1,2)
}
