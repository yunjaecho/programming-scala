package progscala2.rounding


object WeekDay extends Enumeration {
  type WeekDay = Value
  val Mon, Tue, Wed, Thu, Fri, Sat, Sun = Value
}

object DayEnumeration extends App {
  import WeekDay._

  def isWorkingDay(d: WeekDay): Boolean = !(d == Sat || d == Sun)

  WeekDay.values filter isWorkingDay foreach println
}
