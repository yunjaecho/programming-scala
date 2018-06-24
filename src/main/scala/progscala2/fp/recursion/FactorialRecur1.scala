package progscala2.fp.recursion

import scala.annotation.tailrec

object FactorialRecur1 extends App {

  // 아래 애노테이션에서 주석을 없애면 무슨 일이 벌어질까?
  // @tailrec
  def factorial(i: BigInt): BigInt = {
    if (i == 1) i
    else i * factorial(i - 1)
  }

  for (i <- 1 to 10)
    println(s"$i:\t${factorial(i)}")
}
