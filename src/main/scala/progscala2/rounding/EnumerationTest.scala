package progscala2.rounding

object Breed extends Enumeration {
  type Breed = Value
  val doberman = Value("Doberman Pinscher")
  val yorkie = Value("Yorkie Terrier")
  val scottie = Value("Scottie Terrier")
  val dane = Value("Great Dane")
  val portie = Value("Portuguese Water Dog")
}

object EnumerationTest extends App {
  import Breed._

  // 품종과 품종 ID 목록을 표시한다.
  println("ID\tBreed")
  for(breed <- Breed.values) println(s"${breed.id}\t${breed}")

  // 테이어 품종의 목록을 표시한다.
  println("\nJust Terriers")
  Breed.values.filter(_.toString.endsWith("Terrier")) foreach println

  println("\nTerries Again??")
  def isTerrier(b: Breed) = b.toString.endsWith("Terrier")
  Breed.values filter isTerrier foreach println

}
