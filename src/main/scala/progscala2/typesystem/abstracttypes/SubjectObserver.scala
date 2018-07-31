package progscala2.typesystem.abstracttypes

abstract class SubjectObserver {
  type S <: Subject
  type O <: Observer

  // 컴파일 오류
  /*trait Subject {
    private var observers = List[O]()

    def addObserver(observer: O) = observers ::= observer

    def notifyObservers() = observers.foreach(_.receiveUpdate(this))
  }*/

  trait Subject {
    self: S =>
    private var observers = List[O]()

    def addObserver(observer: O) = observers ::= observer

    def notifyObservers() = observers.foreach(_.receiveUpdate(self))
  }

  trait Observer {
    def receiveUpdate(subject: S)
  }
}


object SubjectObserverApp extends App {

}
