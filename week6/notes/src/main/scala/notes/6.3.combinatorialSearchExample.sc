// https://www.coursera.org/learn/progfun1/lecture/H3cKk/lecture-6-3-combinatorial-search-example

/*
Иерархия коллекция в Scala
                         _____ Iterable______
                        /      |      |      \
                Sequence    List    Set     Map
              /     |    \
            List  Vector Range

Также условно к Sequence можно отнести String и Array, но это
классы из Java (=> они не являются реализациями Sequence)
*/

// Sets
val fruit = Set("apple", "banana", "pear")
val s = (1 to 6).toSet

s.map(_ + 2)

fruit.filter(_.startsWith("a"))
s.nonEmpty


// Различия между Sets и Sequences
// 1. sets не упорядочены
// 2. sets не содержат дупликаты
val s1 = Set(1, 1)
//3. основная операция для sets - contains;
// для list это head\tail, для vecotor - это индекс

def nqueens(n: Int): Set[List[Int]] = {
    def isSafe(i: Int, queens: List[Int]): Boolean = ???
    def placeQueens(k: Int): Set[List[Int]] =
        if (k == 0) Set(List())
        else
            for {
                queens <- placeQueens(k - 1)
                col <- 0 until n
                if isSafe(col, queens)
            } yield col :: queens

    placeQueens(n)
}