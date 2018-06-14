package progscala2.patternmatching

object MatchVariable extends App {
  for {
    x <- Seq(1, 2, 2,.7, "one", "two", "three")
  } {
    val str = x match {
      case 1 => "int 1"
      case i : Int => "other int : " + i
      case Double => "a double : " + x
      case "one" => "string one"
      case s: String => "other string : " + s
      case unexpected => "unexpected value : " + unexpected
    }
    println(str)
  }

  def checkY(y: Int) = {
    for {
      x <- Seq(99,100,101)
    } {
      val str = x match {
        case `y` => "found y!"
        case i: Int => "int : " + i
      }
      println(str)
    }
  }

  println("===========================")

  for {
    x <- Seq(1, 2, 2,.7, "one", "two", "three")
  } {
    val str = x match {
      case _ : Int | _: Double   => "other number : " + x
      case "one" => "string one"
      case s: String => "other string : " + s
      case unexpected => "unexpected value : " + unexpected
    }
    println(str)
  }
  println("===========================")



  println("===========================")
  checkY(100)
  println("===========================")


  val list1 = List(1,2,3,4,5)
  val list2 = List(6,7,8,9)

  val list3 = for (x <- list1; y <- list2) yield (x, y * x)
  println(list3)
  val list4 = list3.groupBy(_._1)
  println(list4)
  val list5 = list4.toList.map { data =>
    (data._1, data._2.maxBy(_._2)._2)
  }
  println(list5)

}
