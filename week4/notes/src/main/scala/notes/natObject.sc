import scala._

abstract class Nat {
    def isZero: Boolean
    def predecessor: Nat
    def + (that: Nat): Nat
    def - (that: Nat): Nat
}

class Succ(n: Nat) extends Nat {
    def isZero: Boolean = false
    def predecessor: Nat = n
    def successor: Nat = new Succ(this)
    def + (that: Nat): Nat = new Succ(n + that)
    def - (that: Nat): Nat =
        if (that.isZero) this
        else n - that.predecessor   

    override def toString =
        this.predecessor + ". "
}

object Zero extends Nat {
    def isZero: Boolean = true
    def predecessor = throw Error("0.predecessor")
    def successor: Nat = new Succ(this)
    def + (that: Nat): Nat = that
    def - (that: Nat) =
        if (that.isZero) this
        else throw UnsupportedOperationException()
    override def toString = "0 "
}

val one = new Succ(Zero)

val two = one + one

two - one
