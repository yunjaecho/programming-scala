package progscala2.bounds

class Parent(val value: Int) {  // 1 : 보여주기 위해 간단한 타입 계층을 정의 한다.
  override def toString: String = s"${this.getClass.getName}($value)"
}

class Child(value: Int) extends Parent(value)

case class Opt[+A](value: A = null) {
  def getOrElse[B >: A](default: => B) = if (value != null) value else default
}

//error: covariant type A occurs in contravariant position in type A of value default
//         def getOrElse(default: A) = if (value != null) value else default
// 아래의 코드 오류 발생 코드
/*case class Opt[+A](value: A = null) {
  def getOrElse(default: A) = if (value != null) value else default
}*/


object LowerBounds extends App {
  // 2 : op1 참조는 오직 자신이 Option[Parent]라는 사실만 안다.
  //     하지만 실제로는 (올바른) 서브클래스인 Option[Child]를 가리킨다. Option[+T]가 공변적이기 때문에 그럴 수 있다.
  val op1: Option[Parent] = Option(new Child(1))
  val p1: Parent = op1.getOrElse(new Parent(10))

  // 3 : Option[X](null)은 항상 None을 반환한다. 여기서는 반환되는 참조의 타입이 Option[Parent]
  val op2: Option[Parent] = Option[Child](null)
  val p2a: Parent = op2.getOrElse(new Parent(10))
  val p2b: Parent = op2.getOrElse(new Child(100))

  // 4 : 다시 None이다. 하지만 Option[Parent]에 저장됨에도 불구하고 반환되는 참조의 타입이 Option[Child]
  val op3: Option[Parent] = Option[Child](null)
  val p3a: Parent = op3.getOrElse(new Parent(20))
  val p3b: Parent = op3.getOrElse(new Child(200))
}
