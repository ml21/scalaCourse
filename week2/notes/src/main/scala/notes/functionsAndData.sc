// Lecture 2.5 Functions and data
// https://www.coursera.org/learn/progfun1/lecture/5mmJP/lecture-2-5-functions-and-data

class Rational(x: Int, y: Int) {
  def numerator = x
  def denominator = y

  def add(that: Rational) = new Rational(
    that.denominator * this.numerator + this.denominator * that.numerator,
    this.denominator * that.denominator
  )

  def mul(that: Rational) = new Rational(
    this.numerator * that.numerator,
    this.denominator * that.denominator
  )

  def mul(that: Int) = new Rational(
    this.numerator * that,
    this.denominator
  )

  def sub(that: Rational) = this add that.neg

  def div(that: Rational) = this mul new Rational(that.denominator, that.numerator)

  def neg = this mul -1

  override def toString: String = this.numerator + "/" + this.denominator

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
r add s
r mul s
r mul 2
r mul -1
r sub s
r div s

val x = new Rational(1, 3)
val y = new Rational(5, 7)
val z = new Rational(3, 2)
x sub y sub z


