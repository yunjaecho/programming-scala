package progscala2.fp.datastructs

object MapApp extends App{
  val stateCapitals = Map(
    "Alabama" -> "Montgomery",
    "Alaska" -> "Juneau",
    "Wyoming" -> "Cheyenne"
  )

  val length = stateCapitals map { kv =>
    (kv._1, kv._2.length)
  }


  val caps = stateCapitals map {
    case(k, v) => (k, v.toUpperCase)
  }

  val stateCapitals2 = stateCapitals + ("Virginia" -> "Richmond")

  val stateCapitals3 = stateCapitals2 + (
    "New York" -> "ALbany", "Illinois" -> "Springfield"
  )

}
