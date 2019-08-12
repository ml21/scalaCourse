// https://www.coursera.org/learn/progfun1/lecture/n2EWV/lecture-4-2-functions-as-objects

// функция
val f0 = (x: Int) => x * x
f0(2)
// на самом деле транслируется в класс
val f1 = { class AnonFun extends Function1[Int, Int] {
        def apply(x: Int) = x * x
    }
    new AnonFun
}
f1(2)

// либо использую синтаксис анонимных классов:
val f2 = new Function1[Int, Int] {
    def apply(x: Int) = x * x
}
f2(2)
f2.apply(2)


//*******************EXERCISE***********************
trait List[T] {
    def isEmpty: Boolean
    def head: T
    def tail: List[T]
}

class Cons[T] (head: T, tail: List[T]) extends List[T] {
    val isEmpty = false

    override def toString = head.toString() + " " + tail.toString()
}

class Nil[T] extends List[T] {
    def isEmpty = true
    def head: Nothing = throw new NoSuchElementException("Nil.head")
    def tail: Nothing = throw new NoSuchElementException("Nil.tail")

    override def toString = "empty"
}

object List {
    def apply: List[T] = new Nil[T]
    def apply[T](x1: T): List[T] = new Cons(x1, new Nil)
    def apply[T](x1: T, x2: T): List[T] = new Cons(x1, new Cons(x2, new Nil))
}

List() // the empty list
List(1)  // the list with single element 1
List(2, 3) // the list with elements 2 and 3