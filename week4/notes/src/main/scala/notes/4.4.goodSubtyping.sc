
/* https://www.coursera.org/learn/progfun1/lecture/dnreZ/lecture-4-4-variance-optional

хорошая статья на хабре на тему ко\конт-варинтности https://habr.com/ru/post/218753/

Пусть A2 <: A1 и B1 <: B2
Тогда
A1 => B1 <: A2 => B2
*/

trait List[T] {
    def isEmpty: Boolean
    def head: T
    def tail: List[T]
}

class Cons[T](head: T, tail: List[T]) extends List[T] {
    def isEmpty = false

    override def toString = head + " " + tail.toString()
}

class Nil extends List[T] {
    def isEmpty = true
    def head = throw new NoSuchElementException("Nil.head")
    def tail = throw new NoSuchElementException("Nil.tail")
}

val l = new Cons[Int](1, new Cons[Int](2, Nil))
