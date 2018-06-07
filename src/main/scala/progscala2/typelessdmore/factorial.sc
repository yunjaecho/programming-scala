
def factorial(i: Int): Long = {
  def fact(i: Int, accumulate: Long): Long = {
    if (i <= 1) accumulate
    else fact(i - 1, accumulate * i)
  }
  fact(i, 1)
}

(0 to 5) foreach { i =>
  println(factorial(i))
}