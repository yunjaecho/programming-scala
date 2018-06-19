package progscala2.implicits

object ImplicitErasure extends App {
  object M  {
    def m(seq: Seq[Int]): Unit = println(s"Seq[Int] : $seq")
    // 타입소거 에 대한 문제점
    //def m(seq: Seq[String]): Unit = println(s"Seq[String] : $seq")

    // 타입 소거로 영향을 받을 두 메서드의 모호성을 제거하기 위해 사용할 특별한 목적의 암시적 객체 정의
    implicit object IntMarker
    implicit object StringMarker

    // Seq[Int]를 받는 메서드를 오버라이딩한다. 이번에는 암시적 IntMarker를 요구하는 두번째 인자 목록이 있다.
    // IntMarker.type 타입에 유의하라. 싱글턴 객체의 타입을 참조할 때 이런 구분을 사용한다.
    def m2(seq: Seq[Int])(implicit i: IntMarker.type): Unit = println(s"Seq[Int] : $seq")
    def m2(seq: Seq[String])(implicit i: StringMarker.type): Unit = println(s"Seq[String] : $seq")
  }

  import M._

  m2(List(1,2,3))
  m2(List("one", "two",  "three"))

}
