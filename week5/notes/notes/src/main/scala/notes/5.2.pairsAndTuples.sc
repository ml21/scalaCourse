// https://www.coursera.org/learn/progfun1/lecture/0uFfe/lecture-5-2-pairs-and-tuples
var i = 0;
var j = 0;
// моя реализация
def msort(xs: List[Int]): List[Int] = {
    i = i + 1
    if (xs.isEmpty || xs.length == 1) xs
    else {
        val sorted = msort(xs.tail)
        if (xs.head <= sorted.head) xs.head :: sorted
        else sorted.head :: msort(xs.head :: sorted.tail)
    }
}

i

var list = 3 :: 2 :: 1 :: Nil
var list2 = -1 :: -10 :: 20 :: 19 :: -100 :: Nil

msort(list)
msort(list.reverse)

msort(list2)

val (one, two_three) = (1 :: 2 :: 3 :: Nil) splitAt 1
one
two_three


// реализация из курса
// def msort0(xs: List[Int]): List[Int] = {
//     val n = xs.length / 2
//     if (n == 0) xs
//     else {
//         def merge(xs: List[Int], ys: List[Int]): List[Int] = {
//         j = j + 1;
//         xs match {
//             case Nil => ys
//             case x :: xs1 => ys match {
//             case Nil => xs
//             case y :: ys1 =>
//                 if (x < y) x :: merge(xs1, ys)
//                 else y :: merge(xs, ys1)
//             }
//         }
//         }

//         val (fst, snd) = xs splitAt n
//         merge(msort0(fst), msort0(snd))
//     }
// }

val list3 = 1 :: -2 :: 3 :: 0 :: -100 :: 1 :: -5 :: 33 :: 12 :: Nil

i = 0; j = 0;
msort(list3)
i
msort0(list3)
j


// пары
val pair = ("answer", 42)
val (x, y) = pair;
x
y


// кортежы
val tupple = ("somestring", 3.0, 1, "anotherstring")
tupple._1
val (f1, f2, f3) = (1, "2", 3.0)
f1
f2


// msort с использованием пар в матчинге
def msort1(xs: List[Int]): List[Int] = {
  val n = xs.length / 2
  if (n == 0) xs
  else {
    def merge(xs: List[Int], ys: List[Int]): List[Int] =
      (xs, ys) match {
        case (Nil, ys1) => ys
        case (xs1, Nil) => xs
        case (x :: xs1, y :: ys1) =>
          if (x < y) x :: merge(xs1, ys)
          else y :: merge(xs, ys1)
      }

    val (fst, snd) = xs splitAt n
    merge(msort1(fst), msort1(snd))
  }
}

msort1(list3)
