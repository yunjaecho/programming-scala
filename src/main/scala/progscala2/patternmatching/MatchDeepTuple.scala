package progscala2.patternmatching

object MatchDeepTuple extends App {
  val itemsCosts = Seq(("Pencil", 0.52), ("Paper", 1.35), ("Notebook", 2.43))
  val itemCostsIndices = itemsCosts.zipWithIndex
  for(itemCostIndex <- itemCostsIndices) {
    itemCostIndex match {
      case((item, cost), index) => println(s"$index : $item costs $cost each")
    }
  }
}
