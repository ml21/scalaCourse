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

val t0 = new NonEmpty(0, Empty, Empty)
val t1 = new NonEmpty(3, Empty, Empty)
val t2 = new NonEmpty(4, Empty, Empty)
val t3 = new NonEmpty(5, Empty, Empty)
t1 union t2 union t3 union t0
t1 union t2
t2 union t3
