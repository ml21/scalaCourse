package week3

trait List[T] {
    def isEmpty: Boolean
    def head: T
    def tail: List[T]
    def length: Int
}

class Cons[T](val head: T, val tail: List[T]) extends List[T] {
    def isEmpty: Boolean = false
    def length: Int = 1 + tail.length

    override def toString = this.head + " " + this.tail
}

class Nil[T] extends List[T] {
    def isEmpty: Boolean = true
    def head: Nothing = throw NoSuchElementException("Nil.head")
    def tail: Nothing = throw NoSuchElementException("Nil.head")
    def length: Int = 0

    override def toString = ""
}