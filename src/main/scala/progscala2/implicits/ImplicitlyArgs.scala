package progscala2.implicits

object ImplicitlyArgs extends App {

  //@inline def implicitly[T](implicit e: T) = e    // for summoning implicit values from the nether world -- TODO: when dependent method types are on by default, give this result type `e.type`, so that inliner has better chance of knowing which method to inline in calls like `implicitly[MatchingStrategy[Option]].zero`


  case class MyList[A](list: List[A]) {
    def sortBy1[B](f: A => B)(implicit ord: Ordering[B]): List[A] = {
      println(s"f  : $f")
      println(s"ord  : $ord")
      list.sortBy(f)(ord)
    }

    def sortBy2[B: Ordering](f: A => B): List[A] = list.sortBy(f)(implicitly[Ordering[B]])
  }

  val list =  MyList(List(1,2,3,4,5))
  println(list.sortBy1(i => -i))
  println(list.sortBy2(i => -i))
}
