// https://www.coursera.org/learn/progfun1/lecture/JIPKx/lecture-6-2-combinatorial-search-and-for-expressions
def isPrime(n: Int): Boolean = (2 until n).forall(x => (n % x) != 0)

// ищем пары i, j такие, что 1 <= j < i < n и i + j простое число
// императивный подход
def getPairsImperatively(n: Int): List[(Int, Int)] = {
    var acc = List[(Int, Int)]()
    for (i <- (1 until n)) {
        for (j <- (1 until n)) {
            if (j < i && isPrime(i + j)) acc = (i, j) :: acc
        }
    }

    acc.reverse
}

getPairsImperatively(7)
getPairsImperatively(7).length


/*
Но здесь мы храними состояние и функция не является чистой

Алгоритм, который позволит реализовать функция без побочных эффектов:

 1. генерируем последовательность пар (i, j), таких что 1 <= j < n
 2. фильтруем по условию isPrime
*/

// моя реализация
def myGetPairsPure(n: Int) =
    (1 until n).map(i =>
        (1 until i).map(j => (i, j)))
    .flatMap(x => x)
    .filter((x, y) => isPrime(x + y))

myGetPairsPure(7)

// реализация из лекции
def getPairsPure(n: Int) =
    (1 until n).flatMap(i =>
        (1 until i).map(j => (i, j)))
    .filter((x, y) => isPrime(x + y))

getPairsPure(7)

// здесь есть проблема читабельности, которую можно решить при помощи
// for expressions
def getPairsForExp(n: Int) = for {
    i <- 1 until n
    j <- 1 until i
    if isPrime(i + j)
} yield (i, j)

getPairsForExp(7)


// exercise
val a = 1.0 :: 2.0 :: Nil
val b = 3.0 :: 4.0:: Nil
def scalarProduct(xs: List[Double], ys: List[Double]): Double = (for {
        (x, y) <- xs zip ys
    } yield x * y).sum

scalarProduct(a, b)