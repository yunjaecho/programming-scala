def map[A, B](seq: Seq[A])(f: A => B): Seq[B] = seq map f
def map[A, B](f: A => B)(seq: Seq[A]): Seq[B] = seq map f

val fm = map((i: Int) => i *2.1) _
