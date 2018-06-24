package progscala2.fp.recursion

import scala.util.control.TailCalls._

/**
  * 어떤 함수  A가 자기 자신을 호출하지는 않지만, 다른 함수 B를 호출하고,
  * B가 다시 A를 호출하고, A는 다시 B를 호출하는 식의 재귀를 고려해보자.
  * 이런 식으로 주고받는 재귀를 트램펄린을 사용해서 루프로 변환할 수 있다.
  */
object Trampoline extends App {
  def isEven(xs: List[Int]): TailRec[Boolean] =
    if (xs.isEmpty) done(true) else tailcall(isOdd(xs.tail))

  def isOdd(xs: List[Int]): TailRec[Boolean] =
    if (xs.isEmpty) done(false) else tailcall(isEven(xs.tail))

  for(i <- 1 to 5) {
    val even = isEven((1 to i).toList).result
    println(s"$i is even? $even")
  }
}
