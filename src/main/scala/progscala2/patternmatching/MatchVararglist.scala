package progscala2.patternmatching



object MatchVararglist extends App {

  // 컬렉션 가변인자 처리 _* 를 붙여준다.
  def sum(xs:Int*):Int = if (xs.isEmpty) 0 else xs.head + sum(xs.tail:_*)

  val ns = List(1, 3, 5)
  println(sum(ns :_*))
  println("=======================")

  // WHERE 절에 사용할 연산자들
  object Op extends Enumeration {
    type Op = Value
    val EQ = Value("=")
    val NE = Value("!=")
    val LTGT = Value("<>")
    val LT = Value("<")
    val LE = Value("<=")
    val GT = Value(">")
    val GE = Value(">=")
  }

  import Op._
  // SQL 의 WHERE x op value 절을 표현한다.
  case class WhereOp[T](columnName: String, op: Op, value: T)
  // SQL 의 WHERE x IN (a, b, c, ...) 절을 표현한다.
  case class WhereIn[T](columnName: String, val1: T, vals: T*)

  val wheres = Seq(
    WhereIn("state", "IL", "CA", "VA"),
    WhereOp("state", EQ, "IL"),
    WhereOp("name", EQ, "Buck Trends"),
    WhereOp("age", GT, 29),
  )

  for (where <- wheres) {
    where match {
        // 패턴 매칭에서 가변 인자 처리 @_*
      case WhereIn(col, val1, vals @_*) =>
        val valStr = (val1 +: vals).mkString(",")
        println(s"WHERE $col IN ($valStr)")
      case WhereOp(col, op, value) =>
        println(s"WHERE $col $op $value")
      case _ => println(s"ERROR: Unknown expression: $where")
    }
  }

}
