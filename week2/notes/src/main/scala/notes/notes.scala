package notes

object notes extends App {
  val tolerance = 0.0001
  def isCloseEnough(x: Double, y: Double) =
    Math.abs((x - y) / x) / x < tolerance
  def fixedPoint(f: Double => Double)(firstGuess: Double) = {
    def iterate(guess: Double): Double = {
      println("guess = " + guess)
      val next = f(guess)
      println("next" + next)
      if (isCloseEnough(guess, next)) next
      else iterate(next)
    }
    iterate(firstGuess)
  }

  def sqrt(x: Double) : Double = fixedPoint(y => (y + x / y) / 2)(1)
  println("sqrt =" + sqrt(2))
}
