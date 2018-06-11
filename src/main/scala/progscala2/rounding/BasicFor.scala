package progscala2.rounding

object BasicFor extends App {

  val dogBreeds = List("Doberman", "Yorkshire Terrier", "Dachshund",
    "Scottish Terrier", "Great Dane", "Portuguese Water Dog")

  for(breed <- dogBreeds) println(breed)
  println("==============================")

  for(i <- 1 to 10) println(i)
  println("==============================")

  for(i <- 1 to 10) {
    println(i)
  }
  println("==============================")

  for (breed <- dogBreeds if breed.contains("Terrier")) println(breed)
  println("==============================")

  for (breed <- dogBreeds
    if breed.contains("Terrier") && !breed.startsWith("Yorkshire")
    ) println(breed)
  println("==============================")

  for {
    breed <- dogBreeds
    if breed.contains("Terrier") && !breed.startsWith("Yorkshire")
  } println(breed)
  println("==============================")

  val filteredBreeds = for {
    breed <- dogBreeds
    if breed.contains("Terrier") && !breed.startsWith("Yorkshire")
  } yield breed
  println(filteredBreeds)
  println("==============================")

  for {
    breed <- dogBreeds
    upcasedBreed = breed.toUpperCase
  } println(upcasedBreed)
  println("==============================")

  val dogBreeds2 = List(Some("Doberman"), None, Some("Yorkshire Terrier"),
    Some("Dachshund"), None, Some("Scottish Terrier"),
    None, Some("Great Dane"), Some("Portuguese Water Dog"))

  println("first pass:")
  for {
    breedOption <- dogBreeds2
    breed <- breedOption
    upcasedBreed = breed.toUpperCase
  } println(upcasedBreed)
  println("second pass:")
  for {
    Some(breed) <- dogBreeds2
    upcasedBreed = breed.toUpperCase
  } println(upcasedBreed)
  println("============================")

}
