// Lecture 3.2 How classes are organized
// https://www.coursera.org/learn/progfun1/lecture/YDsaZ/lecture-3-2-how-classes-are-organized

package week3

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