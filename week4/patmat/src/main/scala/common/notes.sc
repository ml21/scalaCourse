def remove[T](n: Int, xs: List[T]): List[T] = xs match {
  case Nil => throw new UnsupportedOperationException()
  case y :: ys =>
    if (n < 0) throw new IndexOutOfBoundsException()
    else if (n == 0) ys
    else y :: remove(n - 1, ys)
}

val list = 'a' :: 'b' :: 'c' :: 'd' :: Nil
remove(1, list)
remove(2, list)


def flatten[Any](xs: List[Any]): List[Any] = xs.head match {
  case Nil => Nil
  case y => y :: flatten(xs.tail)
  case y :: ys => (y :: flatten(ys)) ++ flatten(xs.tail)
}

