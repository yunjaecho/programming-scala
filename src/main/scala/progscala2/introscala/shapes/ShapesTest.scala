package progscala2.introscala.shapes

object ShapesTest extends App {
  val p00 = new Point
  val p20 = new Point(2.0)
  val p20b = new Point(2.0)
  val p02 = new Point(y = 2.0)

  println(s"p00 == p20 : ${p00 == p20}")
  println(s"p20 == p20b : ${p20 == p20b}")
}
