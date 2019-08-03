// Lecture 2.5 Functions and data
// https://www.coursera.org/learn/progfun1/lecture/5mmJP/lecture-2-5-functions-and-data

class Rational(numer: Int, denum: Int) {
  require(denum > 0, "denumerator must be positive")
  def gcd(a: Int, b: Int): Int = if (b == 0) a else gcd(b, a % b)
  private val divisor = Math.abs(gcd(numer, denum))

  val numerator = numer / this.divisor
  val denominator = denum / this.divisor

  def this(numer: Int) = this(numer, 1)

  def +(that: Rational) = new Rational(
    that.denominator * this.numerator + this.denominator * that.numerator,
    this.denominator * that.denominator
  )

  def *(that: Rational) = new Rational(
    this.numerator * that.numerator,
    this.denominator * that.denominator
  )

  def *(i: Int) = new Rational(
    this.numerator * i,
    this.denominator)

  def -(that: Rational): Rational = this - that

  def /(that: Rational) = this * new Rational(that.denominator, that.numerator)

  def unary_- = this * -1

  def <(that: Rational): Boolean = that.denominator * this.numerator < this.denominator * that.numerator

  def max(that: Rational): Rational = if (this < that) that else this

  override def toString: String = 
    this.numerator + "/" + this.denominator
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
r + s
r * s
r * 2
r * -1
r - s
r / s

val x = new Rational(1, 3)
val y = new Rational(5, 7)
val z = new Rational(3, 2)
val r1 = x - y - z
val r2 = y + y

r < s
r < -s

r max s
r max r0

val strange = new Rational(1, 0)
strange + strange

r max s + s
val k = (Int.MaxValue - 1)*(Int.MaxValue - 2)
val i = new Rational(2)
val big = new Rational(Int.MaxValue, Int.MaxValue - 1)
val biga = new Rational(Int.MaxValue, Int.MaxValue - 2)

big + biga

new Rational(1, 2) + s
s
-s

r + -r
new Rational(1, 0)

val r3 = new Rational(1, 2)
r3 * r3 + r3 * r3



