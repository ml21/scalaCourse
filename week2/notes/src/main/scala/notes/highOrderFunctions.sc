def sum(f: Int => Int, a: Int, b: Int): Int = {
  def loop(a: Int): Int =
    if (a > b) 0
    else f(a) + loop(a + 1)

  loop(a)
}

def sumInts(a: Int, b: Int): Int = sum(x => x, a, b)
def sumCubes(a: Int, b: Int): Int = sum(x => x * x * x, a, b)

sumInts(1, 5)
sumCubes(1, 5)

def sum1(f: Int => Int): (Int, Int) => Int = {
  def sumF(a: Int, b: Int): Int =
    if (a > b) 0
    else f(a) + sumF(a + 1, b)
  sumF
}

def sumInts1 = sum1(x => x)
def sumCubes1 = sum1(x => x * x * x)

sumInts1(1, 5)
sumCubes1(1, 5)

sum1(x => x)(1, 5)

def sum2(f: Int => Int)(a: Int, b: Int): Int =
  if (a > b) 0
  else f(a) + sum2(f) (a + 1, b)

sum2(x => x)(1, 2)

def product(f: Int => Int)(a: Int, b: Int): Int =
  if (a > b) 1
  else f(a) * product(f) (a + 1, b)

def factorial(n: Int) = product(x => x)(1, n)
factorial(5)

def mapReduce(f: Int => Int, combine: (Int, Int) => Int, zero: Int)(a: Int, b: Int): Int =
  if(a > b) zero
  else combine(f(a), mapReduce(f, combine, zero)(a + 1, b))

def sum3(f: Int => Int)(a: Int, b: Int): Int = mapReduce(f, (x, y) => x + y, 0)(a, b)
sum3(x => x)(1, 5)

def product2(f: Int => Int)(a: Int, b: Int) = mapReduce(f, (x, y) => x * y, 1)(a, b)

product(x => x)(1, 5)

