package progscala2.fp.categories


// 1: map 메서드는 F(이는 컨테이너의 일종일 것이다)의 인스턴스를 인자로 받는다.
trait Functor[F[_]] {
  // map의 인자는 F[A]라는 펑터로, A => B로 변환하는 함수다. F[B]를 반환한다.
  def map[A, B](fa: F[A])(f: A => B): F[B]
}

object SeqF extends Functor[Seq] {
  def map[A, B](seq: Seq[A])(f: A => B): Seq[B] = seq map f
}

object OptionF extends Functor[Option] {
  def map[A, B](opt: Option[A])(f: A => B): Option[B] = opt map f
}

object FunctionF {
  // 4: 한 함수를 다른 함수로 매핑하는 구현 객체를 정의한다. 쉽지 않다.!
  def map[A, A2, B](func: A => A2)(f: A2 => B): A => B = {
    // 5: FunctorF는 자신만의 map 메서드를 정의 한다. map을 호출하는 구문이 Seq, Option 그리고
    //    우리가 구현할 수 있는 다른 변환에 있는 함수를 호출하는 것과 동일해지도록 구현했다.
    //    이 map은 변환할 대상 초기 함수를 받아서 그 변환을 수행하는 함수를 반환한다.
    //    타입에 유의 하라.
    //    우리는 A => A2를 A => B로 변환한다. 이는 두 번째 인자인 함수 f 가 A2 => B라는 뜻이다.
    //    다른 말로 하면, 여기서는 함수를 연쇄시킨다.
    val functor = new Functor[({type λ[β] =  A => β})#λ] {
      // 6: map 구현은 변환을 수행하기 위해 올바든 타입이 지정된 Functor를 구성한다.
      def map[A3, B](func: A => A3)(f: A3 => B): A => B = (a: A) => f(func(a))
    }
    // 7: 마지막으로 FunctorF.map이 그 Functor를 호출한다.
    //    FunctorF.map 의 반환 타입은 A => B 이다.
    functor.map(func)(f)
  }
}

object FunctionTest extends App {
  val fii: Int => Int = i => i *2
  val fid: Int => Double = i => 2.1 * i
  val fds: Double => String = d => d.toString

  SeqF.map(List(1,2,3,4))(fii)
  SeqF.map(List.empty[Int])(fii)

  OptionF.map(Some(2))(fii)
  OptionF.map(Option.empty[Int])(fii)

  val fa = FunctionF.map(fid)(fds)
  println(fa(2))

  //val fb = FunctionF.map(fid)(fds)
  val fb = FunctionF.map[Int, Double, String](fid)(fds)
  println(fb(2))

  val fc = fds compose fid
  println(fc(2))
}
