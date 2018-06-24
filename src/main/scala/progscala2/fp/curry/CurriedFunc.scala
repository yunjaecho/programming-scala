package progscala2.fp.curry

object CurriedFunc extends App {
  def cat1(s1: String)(s2: String) = s1 + s2


  // 부분함수 적용 (_)
  val hello = cat1("Hell") _
  println(hello("World!"))

  println(cat1("Hello")("World!"))


  val inverse: PartialFunction[Double, Double] = {
    case d if d != 0.0 => 1.0 / d
  }

  println(inverse(1.0))
  println(inverse(2.0))
  println(inverse(2.0)(4))
  //println(inverse(0.0))
}
