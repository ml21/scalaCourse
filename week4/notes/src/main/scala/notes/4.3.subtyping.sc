abstract class IntSet {
    def contains(i: Int): Boolean
    def include(i: Int): IntSet
    def union(other: IntSet): IntSet
 }

/* binary tree implementation
         7
    5        10
 E     E  9       13
      E       E E       E
*/
class NonEmpty(element: Int, left: IntSet, right: IntSet) extends IntSet {

    override def contains(i: Int): Boolean =
        if (i > element) right contains i
        else if (i < element) left contains i
        else true

    override def include(i: Int): IntSet =
        if (i > element) new NonEmpty(element, left, right include i)
        else if (i < element) new NonEmpty(element, left include i, right)
        else this

    override def union(other: IntSet): IntSet =
        ((left union right) union other) include element

    override def toString = "{ " +
        left.toString() + " " +
        element + " " +
        right.toString() +
        " }"
}

object Empty extends IntSet {
    override def contains(i: Int): Boolean = false
    override def include(i: Int): IntSet = new NonEmpty(i, Empty, Empty)
    override def union(other: IntSet) = other

    override def toString = "."
}

// problematic array example
val a: Array[NonEmpty] = Array(new NonEmpty(1, Empty, Empty))
val b: Array[IntSet] = a
b(0) = Empty
val s: NonEmpty = a(0)


/*
Т.е. Scala по умолчанию массивы инвариантны.
А в C# ковариантность массивов поддерживается.
Например, вот это код скомплируется:
class Car { }
class Bmw : Car { }
class Honda : Car { }

Bmw[] bmws = new Bmw[] { new Bmw(), new Bmw() };
Car[] cars = bmws;

Honda honda1 = new Honda()
cars[0] = honda1

и ошибка будет только в рантайми на cars[0] = honda1
*/