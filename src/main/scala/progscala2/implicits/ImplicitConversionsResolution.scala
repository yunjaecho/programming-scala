package progscala2.implicits



object ImplicitConversionsResolution extends App {
  case class Foo(s: String)

  object Foo {
    implicit def fromString(s: String): Foo = Foo(s)
  }

  // Foo fromString 보다 우선 적용됨
  implicit def overridingConversion(s: String): Foo = Foo("Boo: " + s)

  class FooTest {
    def m1(foo: Foo) = println(foo)
    // Foo object String implicit
    def m(s: String) = m1(s)
  }

  val fooTest = new FooTest()
  fooTest.m("aaa")

  val s = "Programming Scala"
  println(s.reverse)
  println(s.capitalize)
}
