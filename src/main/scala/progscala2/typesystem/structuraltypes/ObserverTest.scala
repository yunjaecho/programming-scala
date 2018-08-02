package progscala2.typesystem.structuraltypes

// 1 : 예제와 관계는 없지만 State 타입 매개변수와 추상 타입을 서로 바꿀수 있음을 보여주기 위해 바꾼 부분
trait Subject {
  // 2: 리플렉션을 사용한 메서드 호출을 허용하기 위해 선택적인 특서을 활성화해야 한다.
  import scala.language.reflectiveCalls
  // 3: State 추상 타입
  type State
  // 4: Observer 구조적인 타입
  type Observer = {
    def receiveUpdate(state: Any): Unit
  }
  // 5: Observer 에서도 State라는 ㅁ타입 매개 변수를 제거한다.
  private var observers: List[Observer] = Nil

  def addObserver(observer: Observer) = observers ::= observer

  def notifyObservers(state: State) = observers.foreach(_.receiveUpdate(state))
}

object observer {
  def receiveUpdate(state: Any): Unit = println("got one! " + state)
}

object ObserverTest extends App {
  val subject = new Subject {
    override type State = Int

    protected var count = 0

    def increment(): Unit = {
      count += 1
      notifyObservers(count)
    }
  }

  subject.increment()
  subject.increment()
  subject.addObserver(observer)
  subject.increment()
  subject.increment()


}
