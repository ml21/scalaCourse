// https://www.coursera.org/learn/progfun1/lecture/UWSpZ/lecture-5-4-higher-order-list-functions

// 1. a common operation is to transform each element of a list and then return the list of results
def scaleList(xs: List[Double], factor: Double): List[Double] = xs match {
  case Nil => xs
  case y :: ys => y * factor :: scaleList(ys, factor)
}

val l = 1.0 :: 2.0 :: 3.0 :: 4.0 :: Nil
scaleList(l, 2.0)

// this scheme can be generalized to the method map of the List class
// abstract class List[T] {
//  def map[U](f: T => U): List[U] = this match {
//    case Nil => this
//    case x :: xs => f(x) :: xs.map(f)
//  }
//}

// def scaleList1(xs: List[Double], factor: Double): List[Double] => xs map (x => x * factor)

// excercise: implement squareList using pattern matching and using map
def squareListWithPm(xs: List[Int]): List[Int] = xs match {
  case Nil => xs
  case y :: ys => y * y :: squareListWithPm(ys)
}

squareListWithPm(2 :: 4 :: 10 :: Nil)

def squareListWithMap(xs: List[Int]): List[Int] = xs map (x => x * x)

squareListWithMap(2 :: 4 :: 10 :: Nil)


// 2. another common operation on lists is the selection of all elments satisfying a given condition
def posElems(xs: List[Int]): List[Int] = xs match {
  case Nil => xs
  case y :: ys =>	if (y > 0) y :: posElems(ys) else posElems(ys)
}

val ints = -1 :: 10 :: 0 :: 12 :: 1 :: -10 :: Nil

posElems(ints)

// this pattern is generalized by the method filter of the List class:
// abstract class List[T] {
//	 	...
//		def filter(p: T => boolean): List[T] = this match {
//      case Nil =>  this
//      case x :: xs => if (p(x)) x :: xs.filter(p) else xs.filter(p)
//    }
// }

def posElems1(xs: List[Int]): List[Int] = xs filter (x => x > 0)

posElems1(ints)

// there are also the folllowing methods that extract sublits based on a predicate:
ints filterNot (x => x < 0) // = filter (x => !p(x))
ints partition (x => x < 0) // = (xs filter p, xs filterNot p)

ints takeWhile (x => x < 0)
ints dropWhile (x => x < 0)
ints span (x => x < 0) // = (xs takeWhile p, xs dropWhile p)

// exercise
def pack[T](xs: List[T]): List[List[T]] = xs match {
  case Nil => Nil
  case y :: ys => {
    val s = xs span (x1 => x1 == y)
    s._1 :: pack(s._2)
  }
}

val test = "a" :: "a" :: "a" :: "b" :: "c" :: "c" :: "a" :: Nil

pack(test)

// exercise
def encode[T](xs: List[T]): List[(T, Int)] = pack(xs) map (duplicates => (duplicates.head, duplicates.length))
encode(test)
