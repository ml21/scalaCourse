// Lecture 2.5 Functions and data
// https://www.coursera.org/learn/progfun1/lecture/5mmJP/lecture-2-5-functions-and-data

def gcd(a: Int, b: Int): Int =
  if (b == 0) a
  else gcd(b, a % b)

class Rational(numer: Int, denum: Int) {
  require(denum > 0, "denumerator must be positive")
  private def gcd(a: Int, b: Int): Int = if (b == 0) a else gcd(b, a % b)

  val numerator = numer
  val denominator = denum

  def this(numer: Int) = this(numer, 1)

  def add(that: Rational) = new Rational(
    that.denominator * this.numerator + this.denominator * that.numerator,
    this.denominator * that.denominator
  )

  def mul(that: Rational) = new Rational(
    this.numerator * that.numerator,
    this.denominator * that.denominator
  )

  def mul(i: Int) = new Rational(
    this.numerator * i,
    this.denominator)


  def sub(that: Rational) = (this add that.neg)

  def div(that: Rational) = (this mul new Rational(that.denominator, that.numerator))

  def neg = (this mul -1)

  def lessZero = this.numerator * this.denominator < 0

  def less(that: Rational): Boolean = that.denominator * this.numerator < this.denominator * that.numerator

  def max(that: Rational): Rational = if (this less that) that else this

  override def toString: String = {
    val divisor = Math.abs(gcd(numer, denum))
    this.numerator / divisor + "/" + this.denominator / divisor
  }
}

def addRational(r: Rational, s: Rational): Rational = new Rational(
  s.denominator * r.numerator + r.denominator * s.numerator,
  r.denominator * s.denominator
)

def makeString(r: Rational): String = r.numerator + "/" + r.denominator

object rationals {


}

val r = new Rational(1,2)
val s = new Rational(2, 3)
val r0 = new Rational(1,2)
r add s
r mul s
r mul 2
r mul -1
r sub s
r div s

val x = new Rational(1, 3)
val y = new Rational(5, 7)
val z = new Rational(3, 2)
val r1 = x sub y sub z
val r2 = y add y

r less s
r less s.neg

r max s
r max r0

val strange = new Rational(1, 0)
strange add strange

r max s add s

val i = new Rational(2)
val big = new Rational(Int.MaxValue, Int.MaxValue/2)
val biga = new Rational(Int.MaxValue, Int.MaxValue/3)

big add biga

