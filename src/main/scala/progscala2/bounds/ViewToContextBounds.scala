package progscala2.bounds


object Serialization2 {
  case class Rem[A](value: A) {
    def serialized: String = s"--- $value ---"
  }

  type Writeable2[A] = A => Rem[A]
  implicit def fromInt: Writeable2[Int] = (i: Int) => Rem(i)
  implicit def fromFloat: Writeable2[Float] = (f: Float) => Rem(f)
  implicit def fromString: Writeable2[String] = (s: String) => Rem(s)
}

import Serialization2._

object RemoteConnection2 {
  // 임의 타입의 인스턴스를 받아서 연결에 쓰는 메서드, 암시적 변환을 호출해서 serialized 메서드를 호출한다.
  def write[T: Writeable2](t: T): Unit = println(t.serialized)
}


object ViewToContextBounds extends App {
  RemoteConnection2.write(100)
  RemoteConnection2.write(3.14f)
  RemoteConnection2.write("hello")
}
