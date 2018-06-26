package progscala2.fp.datastructs

object FoldReduce extends App {
  val list = List(1,2,3,4,5)

  val list1 = list.reduce(_ + _)
  println(list1)
  val list2 = list.fold(0)(_ + _)
  println(list2)
  val list3 = list.fold(10)(_ * _)
  println(list3)
  val list4 = List.empty[Int].fold(10)(_ + _)
  println(list4)
  val list5 = List.empty[Int].fold(10)(_ * _)
  println(list5)
  val list6 = List.empty[Int].reduceOption(_ + _)

  val list7 = List(1,2,3,4,5,6).foldRight(List.empty[String]) {
    (x, list) => (s"[$x]") :: list
  }

  println(list7)

  val list8 = List(1,2,3,4,5,6).foldLeft(List.empty[String]) {
    (list, x) => (s"[$x]") :: list
  }
  println(list8)

  println(List(1,2,3,4,5).scan(10)(_ + _))

}
