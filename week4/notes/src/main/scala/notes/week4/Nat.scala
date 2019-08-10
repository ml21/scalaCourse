package week4

abstract class Nat {
    def isZero: Boolean
    def predecessor: Nat
    def successor: Nat
    def + (that: Nat): Nat
    def - (that: Nat): Nat
}

object Zero extends Nat {
    override def isZero: Boolean = week4.True
    override def predecessor = null
    override def successor = One
    override def + (that: Nat): Nat = that
    override def - (that: Nat) =
        throw UnsupportedOperationException()
    override def toString = "0 "
}

object One extends Nat {
    def isZero = week4.False
    def predecessor = Zero
    def successor = new Succ(this)
    def + (that: Nat) = new Succ(that)
    def - (that: Nat) = ???
    override def toString = this.predecessor + "1 "
}

class Succ(pre: Nat) extends Nat {
    override def isZero: Boolean = week4.False
    override def predecessor: Nat = pre
    override def successor: Nat = new Succ(this)
    override def + (that: Nat): Nat =
        this.predecessor + that.predecessor + One + One
    override def - (that: Nat): Nat = ???

    override def toString =
        this.predecessor + ". "
}
