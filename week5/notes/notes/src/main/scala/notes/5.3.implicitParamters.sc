// https://www.coursera.org/learn/progfun1/lecture/82wi4/lecture-5-3-implicit-parameters

val list3 = 1 :: -2 :: 3 :: 0 :: -100 :: 1 :: -5 :: 33 :: 12 :: Nil

def msort[T](xs: List[T])(lt: (T, T) => Boolean): List[T] = {
  val n = xs.length / 2
  if (n == 0) xs
  else {
    def merge(xs: List[T], ys: List[T]): List[T] =
      (xs, ys) match {
        case (Nil, ys1) => ys
        case (xs1, Nil) => xs
        case (x :: xs1, y :: ys1) =>
          if (lt(x, y)) x :: merge(xs1, ys)
          else y :: merge(xs, ys1)
      }

    val (fst, snd) = xs splitAt n
    merge(msort(fst)(lt), msort(snd)(lt))
  }
}

msort[Int](list3)((a, b) => a < b)

val fruits = "apple" :: "banana" :: "pineapple" :: Nil

def fruitsLt(a: String, b: String): Boolean = {
    def fruitsLt(pair: (String, String)): Boolean = pair match {
        case ("apple", "banana") => false
        case ("apple", "pineapple") => false
        case ("banana", "pineapple") => true
    }

    fruitsLt((a, b))
}
msort[String](fruits)(fruitsLt)