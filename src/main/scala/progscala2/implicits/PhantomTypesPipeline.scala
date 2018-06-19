package progscala2.implicits

object Pipline {
  implicit class toPiped[V](value: V) {
    def |>[R](f: V => R) = f(value)
  }
}

object PhantomTypesPipeline extends App {
  import Pipline._
  import Payrool._

  val e = Employee("Buck Trends", 100000.0F, 0.25F, 200F, 10F, 0.05F)
  val pay =
    start(e) |>
    minus401k |>
    minusInsurance |>
    minusTax |>
    minusFinalDeductions

  val twoWeekGroos = e.annualSalary / 26.0F
  val twoWeekNet = pay.netPay
  val percent = (twoWeekNet / twoWeekGroos) * 100
  println(s"For ${e.name}, the gross vs. net pay every 2 week is")
  println(f"$$${twoWeekGroos}.2F vs $$${twoWeekNet}.2F or ${percent}.1f%%")

}
