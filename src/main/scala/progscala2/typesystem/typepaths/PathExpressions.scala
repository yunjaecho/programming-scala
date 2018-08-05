package progscala2.typesystem.typepaths

class C1 {
  var x = "1"
  def setX1(x: String): Unit = this.x = x
  def setX2(x: String): Unit = C1.this.x = x
}

trait X {
  def setXX(x: String): Unit = {}
}

class C2 extends C1
class C3 extends C2 with X  {
  def setX3(x: String): Unit = super.setX1(x)
  def setX4(x: String): Unit = C3.super.setX1(x)
  def setX5(x: String): Unit = C3.super[C2].setX1(x)
  def setX6(x: String): Unit = C3.super[X].setXX(x)
  //def setX7(x: String): Unit = C3.super[C1].setX1(x)
  //def setX8(x: String): Unit = C3.super.super.setX1(x)
}


object PathExpressions extends App {

}
