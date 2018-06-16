package progscala2.patternmatching

object RegexAssignments extends App {
  val cols = """\*|[\w, ]+"""  // 컬럼
  
  val table = """\w+"""        // 테이블 이름
  
  val others = """.*"""        // 기타
  
  val selectRE =
    s"""SELECT\\s*(DISTINCT)?\\s+($cols)\\s*FROM\\s+($table)\\s*($others)?;""".r

  val selectRE(distinct1, cols1, table1, otherClauses1) =
    "SELECT DISTINCT * FROM atable;"
  println(s"distinct1 : $distinct1 , cols1 : $cols1 , table1 : $table1 , otherClauses1 : $otherClauses1")
  
  val selectRE(distinct2, cols2, table2, otherClauses2) =
    "SELECT col1, col2 FROM atable;"
  println(s"distinct2 : $distinct2 , cols2 : $cols2 , table1 : $table2 , otherClauses2 : $otherClauses2")
  val selectRE(distinct3, cols3, table3, otherClauses3) =
    "SELECT DISTINCT col1, col2 FROM atable;"
  println(s"distinct3 : $distinct3 , cols3 : $cols3 , table1 : $table3 , otherClauses3 : $otherClauses3")
  val selectRE(distinct4, cols4, table4, otherClauses4) =
    "SELECT DISTINCT col1, col2 FROM atable WHERE col1 = 'foo';"
  println(s"distinct4 : $distinct3 , cols3 : $cols3 , table1 : $table3 , otherClauses3 : $otherClauses3")
}
