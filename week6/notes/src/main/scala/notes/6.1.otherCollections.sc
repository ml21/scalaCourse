// https://www.coursera.org/learn/progfun1/lecture/d0fdt/lecture-6-1-other-collections
/*
Vector

Если доступ к элементам рекурсивен, списки лучше.
Если доступ к элементам представляет собой
массовые операции, такие как map\fold\filter, тогда предпочтительнее использовать вектор.
*/
val nums = Vector(1, -2, 10)
val people = Vector("Bob", "James", "Mike")

// поддерживаются те же операции, что и для List (map, fold, head, tail и т.д),
nums.tail
nums.head
nums.last
nums.fold(0)(_ + _)

// кроме :: - вместо :: используются:

// x +: xs - создает новый вектор с первым элементом x
// и последующими xs
0 +: nums

// xs :+ - создает новый вектор с последним элементом x
// и предшествующими xs
nums :+ 0


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

val a = Array(1, 2, 3)
a.map(x => 2 * x)
val ys =  "Hello world!"
ys.filter(_.isUpper)

// также примером Sequence является Range
val r: Range = 1 to 5

// Range представлен как объект с тремя полями:
// lower bound, upper bound, step value

// операторы
// to - включает верхнюю границу
// until - не включает верхнюю границу
// by - задает шаг

val r1 = 1 to 5 by 2
r1.head
r1.tail.head
r1.reduceLeft(_ + _)

val r2 = 1 until 5 by 2
r2.head
r2.tail.head
r2.reduceLeft(_ + _)

// еще операции Sequence

r1.exists(x => x == 3)
r1.forall(x => x > 0)

a zip ys;
val (odds, evens) = List((1, 2), (3, 4), (5, 6)) unzip;

List((1 :: 2 :: Nil), (1 :: 2 :: Nil)).flatMap(x => x);
List((1 :: 2 :: Nil), (1 :: 2 :: Nil)).flatMap(x => x map (_ * 2));

(1 :: 2 :: 3 :: Nil) product;
r1 max;
r1 min

// пример - расчет произведения векторов
val a = Vector[Double](1, 2)
val b = Vector[Double](3, 4)

def scalarProduct(xs: Vector[Double], ys: Vector[Double]): Double =
    (xs zip ys).map(xy => xy._1 * xy._2).sum

scalarProduct(a, b)

// либо используя паттерн матчинг
def scalarProduct1(xs: Vector[Double], ys: Vector[Double]): Double =
    (xs zip ys).map{case (x, y) => x * y}.sum

scalarProduct1(a, b)

// exercise
4 % 2
4 % 3
3 % 4
def isPrime(n: Int): Boolean = (2 until n).forall(x => (n % x) != 0)

isPrime(13)
isPrime(12)
isPrime(27)
