package progscala2.typelessdmore.shapes

case class Point(x: Double = 0.0, y: Double = 0.0) {
  def shift(deltax: Double, deltay: Double) = copy(x + deltax, y + deltay)
}

abstract class Shape {
  /**
    * 두 인자 목록을 받는다.
    * 한 이자 목록은 그림을 그릴 때 x, y축 바방향으로 이동시킬 오프셋 값이고
    * 나머지 인자 목록은 앞에서 봤던 함수 인자다.
    */
  def draw(offset: Point = Point(0.0, 0.0))(f: String => Unit): Unit = f(s"draw :${this.toString}")
  def draw2(offset: Point = Point(0.0, 0.0), f: String => Unit): Unit = f(s"draw :${this.toString}")
}

case class Circle(center: Point, radius: Double) extends Shape

case class Rectangle(lowerLeft: Point, height: Double, width: Double) extends Shape

case class Triangle(point1: Point, point2: Point, point3: Point) extends Shape
