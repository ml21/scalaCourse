val xs = 1 :: 2 :: 3 :: Nil
val ys = 4 :: 5 :: Nil

// Sublists and element access

// O(n) = const time
xs.head
Nil.head

// O(n) = const time
xs.tail
Nil.tail


xs.length
Nil.length

xs.last
Nil.last

// такая реализация выполняется за O(n) = n
// def last[T](xs: List[T]): T = xs match {
//     case Nil => throw NoSuchElementException()
//     case y :: Nil => y
//     case y :: s => last(xs)
// }

xs.init
(1 :: Nil).init
Nil.init

// def init[T](xs: List[T]): List[T] = xs match {
//     case Nil => throw new UnsupportedOperationException()
//     case y :: Nil => Nil
//     case y :: ys => y :: init(ys)
// }

xs.take(2)
Nil take 2

xs drop 1
Nil drop 1

xs(0)
xs.apply(0)
Nil(0)


// Creating new lists
xs ++ ys // xs ++ ys = xs.++(ys)
xs.++(ys)
xs ::: ys //xs ::: ys = ys.:::(xs)
xs.:::(ys)
ys.:::(xs)

// такая реализация выполняется за O(n) = n (n - размер xs)
// def concat[T](xs: List[T], ys: List[T]): List[T] = xs match {
//     case Nil => ys
//     case z :: zs => z :: concat(zs, ys)
// }

xs reverse

// выполняется за O(n) = n^2
// def reverse[T] (xs: List[T]): List[T] = xs match {
//     case Nil => xs
//     case y :: ys => reverse(ys) ++ List(y)
// }

xs.updated(0, 10)

// Finding elements
xs indexOf 3
xs indexOf 20

xs contains 3
xs contains 20


// Exercise
def remove[T](n: Int, xs: List[T]): List[T] = (xs take(n)) ++ (xs drop n + 1)
remove(0, xs)
remove(1, xs)

xs ::: ys
1 :: ys
