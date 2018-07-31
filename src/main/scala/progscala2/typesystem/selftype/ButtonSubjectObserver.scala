package progscala2.typesystem.selftype

case class Button(label: String) {
  def click(): Unit = {}
}

object ButtonSubjectObserver extends SubjectObserver {

  type S = ObservableButton
  type O = ButtonObserver

  class ObservableButton(lable: String) extends Button(lable) with Subject {
    override def click(): Unit = {
      super.click()
      notifyObservers()
    }
  }

  trait ButtonObserver extends Observer {
    def receiveUpdate(buttn: ObservableButton)
  }

}

import ButtonSubjectObserver._

import scala.collection.mutable

class ButtonClickObserver extends ButtonObserver {
  val clicks = new mutable.HashMap[String, Int]()

  override def receiveUpdate(buttn: ObservableButton) = {
    val count = clicks.getOrElse(buttn.label, 0) + 1
    clicks.update(buttn.label, count)
  }
}

object ButtonSubjectObserverApp  {
  def main(args: Array[String]): Unit = {
    val buttons = Vector(new ObservableButton("one"), new ObservableButton("two"))
    val observer = new ButtonClickObserver
    buttons.foreach(_.addObserver(observer))

    for (i <- 0 to 2) buttons(0).click()
    for (i <- 0 to 4) buttons(1).click()

    println(observer.clicks)
  }


}
