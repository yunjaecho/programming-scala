package progscala2.patternmatching

object MatchFunArgs extends App {
  case class Address(street: String, city: String, country: String)
  case class Person(name: String, age: Int)

  val as = Seq(
    Address("1 Scala Lane", "Anytown", "USA"),
    Address("2 Clojure", "Othertown", "USA")
  )

  val ps = Seq(
    Person("Buck Trends", 29),
    Person("Clo Jure", 28)
  )

  val pas = ps zip as

  // 보기 좋지 않은 예
  pas map { tup =>
    val Person(name, age) = tup._1
    val Address(stree, city, country) = tup._2
    println(s"$name (age : $age) lives at $stree, $city in $country")
  }

  pas map {
    case (Person(name, age), Address(street, city, country)) =>
      println(s"$name (age : $age) lives at $street, $city in $country")
  }


}
