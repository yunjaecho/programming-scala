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
  //println(inverse(0.0))

  def cat2(s1: String) = (s2: String) => s1 + s2

  val cat2hello = cat2("Hello")
  println(s"cat2hello : $cat2hello")

  val cat2world = cat2hello("World!")
  println(s"cat2world : $cat2world")

  //curried 변환 함수
  def cat3(s1: String, s2: String)= s1 + s2

  val cat3Curried = (cat3 _).curried

  cat3Curried("hello")("world")

  val cat3Uncurried = Function.uncurried(cat3Curried)
  println(s"cat3Uncurried : $cat3Uncurried")
  cat3Uncurried("hello", "world")

  val f1: String => String => String = (s1: String) => (s2:String) => s1 + s2
  val ff1 = Function.uncurried(f1)
  ff1("hell", "world")

  def multiplier(i: Int)(factor: Int) = i * factor

  val byFive = multiplier(5) _
  val byTen = multiplier(10) _

  byFive(2)
  byTen(2)

  def mult(d1: Double, d2: Double, d3: Double) = d1 + d2 + d3

  val d3 = (2.2, 3.3, 4.4)

  mult(d3._1, d3._2, d3._3)


  val multTupled = Function.tupled(mult _)
  multTupled(d3)

  val multUntupled = Function.untupled(multTupled)
  multUntupled(d3._1, d3._2, d3._3)
}
