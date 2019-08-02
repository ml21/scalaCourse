/*
fixedPoint(неподвижная точка) - это такая точка, значение функции в которой равно этой точкеЖ
  f(x0) = x0
*/

val tolerance = 0.0001
def isCloseEnough(x: Double, y: Double) =
  Math.abs((x - y) / x) / x < tolerance
def fixedPoint(f: Double => Double)(firstGuess: Double) = {
  def iterate(guess: Double): Double = {
    println("guess = " + guess)
    val next = f(guess)
    if (isCloseEnough(guess, next)) next
    else iterate(next)
  }
  iterate(firstGuess)
}

//fixedPoint(x => 1 + x / 2)(1)

// потренируюсь в каррировании без синтаксического сахара
def fixedPointWithoutSugar(f: Double => Double): Double => Double = {
  def iterate(guess: Double): Double = {
    val next = f(guess)
    if(isCloseEnough(guess, next)) next
    else iterate(next)
  }

  iterate
}

//fixedPointWithoutSugar(x => 1 + x / 2)(1)

/*
sqrt(x0) = y0, => y0 * y0 = x0 => y0 = x0 / y0
т.е. sqrt(x0) является неподвижной точно для f(y) = x0 / y0
 */
// реализация sqrt(x) через fixedPoint
def sqrt(x: Double) : Double = fixedPoint(y => x / y)(1)

// будет осцилировать между 1 и 2
// sqrt(2)

// для решения проблемы можно брать среднее при вызове fixedPoint
// (данный прием называется стабилизацией)
def sqrt1(x: Double) : Double = fixedPoint(y => (y + x / y) / 2)(1)
sqrt1(2)

// абстрагируем стабилицие в отдельную функцию
def averageDump(f: Double => Double)(x: Double) = (x + f(x)) / 2

def sqrt2(x: Double): Double = fixedPoint(averageDump(y => x / y))(1)
sqrt2(2)