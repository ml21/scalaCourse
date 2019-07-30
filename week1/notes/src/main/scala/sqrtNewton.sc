// https://www.coursera.org/learn/progfun1/lecture/FQDE1/lecture-1-5-example-square-roots-with-newtons-method

def sqrt(x: Double): Double = {
  def improve(guess: Double): Double = (guess + x / guess) / 2

  def abs(x: Double): Double = if (x < 0) -1 * x else x

  def isGoodEnough(guess: Double): Boolean = abs(guess * guess - x) < 0.000000000000001 * x

  def sqrtIter(guess: Double): Double =
    if (isGoodEnough(guess)) guess
    else sqrtIter(improve(guess))

  sqrtIter(1)
}

sqrt(2)
sqrt(4)
sqrt(16)
sqrt(250000000)

sqrt(0.001)
sqrt(0.1e-20)
sqrt(1.0e20)
sqrt(1.0e50)

sqrt(1e-6)






