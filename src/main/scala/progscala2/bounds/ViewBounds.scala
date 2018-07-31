package progscala2.bounds

import progscala2.bounds.Serialization.Writable

object Serialization {
  case class Writable(value: Any) {
    // 1 : 단순화를 위해 문자열(String)을 이진 형식 대신 사용한다.
    def serialized: String = s"--- $value ---"
  }

  // 2: 몇가지 암시적 변환을 정의한다. 여기서는 메서드를 정의했지만, 우리에게 필요한 것은 A => B 타입의 함수다.
  //    스칼라는 필요할 때 메서드를 함수로 끌어올린다는 사실을 기억하라.
  implicit def fromInt(i: Int) =Writable(i)
  implicit def fromFloat(f: Float) =Writable(f)
  implicit def fromString(s: String) =Writable(s)
}

// 4 :  원격 연결에 쓰는 것을 캡슐화한 객체
object RemoteConnection {
  // 임의 타입의 인스턴스를 받아서 연결에 쓰는 메서드, 암시적 변환을 호출해서 serialized 메서드를 호출한다.
  def write[T <% Writable](t: T): Unit = println(t.serialized)
}

object ViewBounds {
  import Serialization._

  RemoteConnection.write(100)
  RemoteConnection.write(3.14f)
  RemoteConnection.write("hello")
  // 5: Boolean 형은 사용할 수 없다. Boolean 형에 대한 암시적 뷰가 없기 때문이다.
  //RemoteConnection.write(true)
}
