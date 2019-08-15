// https://www.coursera.org/learn/progfun1/lecture/TFjsY/lecture-4-7-lists
//Lists

val fruit = List("apples", "oranges", "pears")
val nums = List(1, 2, 3, 4)
val diag3 = List(List(1, 0, 0), List(0, 1, 0), List(0, 0, 1))
val empty = List()

/*
1. List неизменяем
2. List рекурсивен

val fruit = List[String]("apples", "oranges", "pears")

                    fruit
    head: "apples"                      tail
                    head: "oranges"             tail
                                    head: "pears"     tail: Nil

3. List может содержать элементы только одинакового типа

Все листы состоят из
- пустого листа Nil
- операции конструирования (Cons) x :: xs, которая создает новый лист из первого (head) элемента
и остальных элементов (tail)

fruit = "apples" :: ("oranges" :: ("pears" :: Nil))
nums = 1 :: (2 :: (3 :: (3 :: Nil)))
diag3 = (1 :: (0 :: (0 :: Nil))) :: ((0 :: (1 :: ( 0:: Nil))) :: ((0 :: (0 :: (1 :: Nil))) :: Nil))
empty = Nil
*/
val a = 1 :: (2 :: Nil) // синтаксический сахар для выражения new Cons

/*
порядок применения оператора :: справа налево
A :: B :: C = A :: (B :: C)
*/
val nums1 = 1 :: 2 :: 3 :: 4 :: Nil;
// это эквивалентно инфиксной форме (порядок применения всех инфиксных выржений слева направо)
val num2 = Nil.::(4).::(3).::(2).::(1)

/*
Все операции над List могут быть выражены в терминах
head - первый элемент
tail - List, содержащий все элементы кроме первого
isEmpty - 'true' если List пустой, иначе 'false'

Эти операции являются методами объектов типа List. Например
*/
fruit.head
fruit.tail
fruit.tail.head
diag3.head
empty.head

val chars: List[Char] = 'a' :: 'b' :: 'a' :: Nil

chars.head
chars.tail

// def times0(char: Char, list: List[Char]): Int = list match {
//         case x :: Nil => if (x == char) 1 else 0
//         case x :: xs => times0(char, x :: Nil) + times0(char, xs)
// }

// times0('a', chars)

class Leaf(char: Char, weight: Int) {
        override def toString = "(" + char + ", " + weight + ")"
}

(('a', 9) :: ('b', 1) :: Nil).sortBy(x => x._2)


 def makeOrderedLeafList(freqs: List[(Char, Int)]): List[Leaf] = freqs.sortBy(l => l._2).map(l => new Leaf(l._1, l._2))
 makeOrderedLeafList(('a', 9) :: ('v', 12) :: Nil)


/*
Также возможно (и часто даже желательно) работать с листами при помощи pattern matching
Nil - паттерн константы Nil
p :: ps - паттерн, которому будет соответсвовать лист с элементом head -> p и tail -> ps
List(p1, ..., pn) - равносильно паттерну p1 :: ... :: pn :: Nil

Примеры:
1 :: 2 :: xs - этому паттерну будет соответствовать лист, начинающийся с элементов 1 и 2
x :: Nil - этому паттерну будет соотвествовать лист, содержащий один элемент
List(x) - то же, что и x :: Nil
List() - тоже, что и Nil
List(2 :: xs) - этому паттерну будет соответсвовать лист,
содержащий единственным элементом другой лист, который начинается с 2
*/

val unsorted = List(7, 3, 9, 2)

def insert(x: Int, xs: List[Int]): List[Int] = xs match {
    case List() => List(x)
    case y :: ys =>
        if (x <= y) x :: ys
        else y :: insert(x, ys)
}

insert(1, 2 :: 3 :: Nil)


def isort(xs: List[Int]): List[Int] = xs match {
    case List() => List()
    case y :: ys => insert(y, isort(ys))
}