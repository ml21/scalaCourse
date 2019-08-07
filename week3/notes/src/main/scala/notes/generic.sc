import week3._

def nth[T](n: Int, list: List[T]) : T =
    if (n < 0 || n > list.length - 1) throw IndexOutOfBoundsException("index must be greater than zero")
    else if (n == 0) list.head
    else nth(n - 1, list.tail)


val ints = new Cons[Int](1, new Cons[Int](2, new Cons[Int](3, new Nil[Int])))

nth(0, ints) == 1
nth(2, ints) == 3
nth(-1, ints)
nth(3, ints)
