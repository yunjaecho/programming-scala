package progscala2.implicits

sealed trait PreTaxDeductions
sealed trait PostTaxDeductions
sealed trait Final

case class Employee(name: String,
                    annualSalary: Float,
                    taxRate: Float,
                    insurancePremiumsPerPayPeriod: Float,
                   _401kDeductionRate: Float,
                    postTaxDeductions: Float)

case class Pay[Step](employee: Employee, netPay: Float)

object Payrool {
  def start(employee: Employee): Pay[PreTaxDeductions] =
    Pay[PreTaxDeductions](employee, employee.annualSalary / 26.0F)

  def minusInsurance(pay: Pay[PreTaxDeductions]): Pay[PreTaxDeductions] = {
    val newNet = pay.netPay - pay.employee.insurancePremiumsPerPayPeriod
    pay copy (netPay = newNet)
  }

  def minus401k(pay: Pay[PreTaxDeductions]): Pay[PreTaxDeductions] = {
    val newNet = pay.netPay - (pay.employee._401kDeductionRate * pay.netPay)
    pay copy (netPay = newNet)
  }

  def minusTax(pay: Pay[PreTaxDeductions]): Pay[PostTaxDeductions] = {
    val newNet = pay.netPay - (pay.employee.taxRate * pay.netPay)
    pay copy (netPay = newNet)
  }

  def minusFinalDeductions(pay: Pay[PostTaxDeductions]): Pay[Final] = {
    val newNet = pay.netPay - pay.employee.postTaxDeductions
    pay copy (netPay = newNet)
  }
}


object PhantomType extends App {
  val e = Employee("Buck Trends", 100000.0F, 0.25F, 200F, 10F, 0.05F)
  val pay1 = Payrool start e

  // 401K(연금)와 보험은 어떤 순서로 계산해도 상관없다.
  val pay2 = Payrool minus401k pay1
  val pay3 = Payrool minusInsurance pay2
  val pay4 = Payrool minusTax pay3
  val pay = Payrool minusFinalDeductions pay4
  val twoWeekGroos = e.annualSalary / 26.0F
  val twoWeekNet = pay.netPay
  val percent = (twoWeekNet / twoWeekGroos) * 100
  println(s"For ${e.name}, the gross vs. net pay every 2 week is")
  println(f"$$${twoWeekGroos}.2F vs $$${twoWeekNet}.2F or ${percent}.1f%%")
}
