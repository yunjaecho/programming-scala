import progscala2.typelessdmore.shapes.{Circle, Point}

val s = Circle(Point(0.2, 3.4), 4.0)
s.draw(Point(1.0, 2.0)) {
  str => println(s"ShapesDrawingActor: $str")
}

//s.draw2(f = str => println(s"ShapesDrawingActor:  $str"))

def m1[A](a: A, f: A => String) = f(a)

def m2[A](a: A)(f: A => String) = f(a)

//m1(100, i => s"$i + $i")

m2(100)(i => s"$i + $i")