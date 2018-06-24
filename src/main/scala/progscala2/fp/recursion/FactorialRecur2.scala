package progscala2.fp.recursion

import scala.annotation.tailrec

object FactorialRecur2 extends App {

  // 어떤 재귀 호출 메서드가 파생타이에 의해 오버라이딩될 수 있는 경우 꼬리 호출 치적화를 적용할 수 없다.
  // 따라서 재귀 메서드는 반드시 private나 final 키워드와 함께 정의하거나 다른 메소드에 내포시켜야 한다.
  def factorial(num: BigInt): BigInt = {
    @tailrec
    def fact(i: BigInt, accumlator: BigInt): BigInt = {
      if (i == 1) accumlator
      else fact(i -1, i * accumlator)
    }
    fact(num, 1)
  }

  for (i <- 1 to 10)
    println(s"$i:\t${factorial(i)}")
}
