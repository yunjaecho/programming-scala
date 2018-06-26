package progscala2.fp.datastructs

object FoldAssicFuncs extends App {
  val facLeft = (accum: Int, x: Int) => accum - x
  val facRight = (x: Int, accum: Int) => accum - x
  val list1 = List(1,2,3,4,5)

  println(list1 reduceLeft facLeft)
  println(list1 reduceRight facRight)

  val fnacLeft = (x: String, y: String) => s"($x)-($y)"
  val fnacRight = (x: String, y: String) => s"($y)-($x)"
  val list2 = list1.map(_.toString)

  println(list2 reduceLeft fnacLeft)
  println(list2 reduceRight fnacRight)
  println(list2 reduceRight fnacLeft)

}
