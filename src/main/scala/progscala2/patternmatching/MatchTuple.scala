package progscala2.patternmatching

object MatchTuple extends App {
  val langs = Seq(
    ("Scala", "Martin", "Ordersky"),
    ("Clojure", "Rich", "Hickey"),
    ("Lisp", "John", "McCarthy")
  )

  for (tuple <- langs) {
    tuple match {
      case ("Scala", _, _) => println("Found Scala")
      case (lang, first, last) =>
        println(s"Found other language: $lang ($first, $last)")
    }
  }
}
