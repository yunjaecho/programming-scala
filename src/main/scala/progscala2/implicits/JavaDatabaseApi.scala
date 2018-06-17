
// 자보와 비슷한 데이타베이스 API. 편의상 스칼라로 만듦
package progscala2.implicits {
  package datase_api {
    case class InvalidCoumnName(name: String) extends RuntimeException(s"Invalid column name $name")

    trait Row {
      def getInt(colName: String): Int
      def getDouble(column: String): Double
      def getText(column: String): String
    }
  }

  package javadb {
    import datase_api._

    case class JRow(representation: Map[String, Any]) extends Row {
      private def get(colName: String): Any =
        representation.getOrElse(colName, throw InvalidCoumnName(colName))

      def getInt(colName: String): Int = get(colName).asInstanceOf[Int]
      def getDouble(colName: String): Double = get(colName).asInstanceOf[Double]
      def getText(colName: String): String = get(colName).asInstanceOf[String]
    }

    object JRow {
      def apply(pairs: (String, Any)*): JRow = new JRow(Map(pairs : _*))
    }
  }
}

