package progscala2.typesystem.structuraltypes

trait SubjectFun {
  type State

  // Observer 타입을 State => Unit 타입의 함수에 대한 별명으로 정의 한다.
  type Observer = State => Unit

  private var observers: List[Observer] = Nil

  def addObserver(observer: Observer) = observers ::= observer
  // 각 관찰자에게 통지하는 것이 관찰자의 apply 메서드를 호출하는 것으로 바뀐다.
  def notifyObservers(state: State) = observers.foreach(o => o(state))
}

object SubjectFunTest extends App {
  val observer: Int => Unit = (state: Int) => println("got one! " + state)
  val subject = new SubjectFun {
    type State = Int

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
