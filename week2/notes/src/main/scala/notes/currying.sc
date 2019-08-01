// лекция 2.1 high order functions
def sumInt0(a: Int, b: Int): Int =
  if (a > b) 0
  else a + sumInt0(a + 1, b)

def sumCube0(a: Int, b: Int): Int =
  if (a > b) 0
  else a * a * a + sumCube0(a + 1, b)

sumInt0(1, 5)
sumCube0(1, 5)

def cube(x: Int): Int = x * x * x
def sum1(f: Int => Int, a: Int, b: Int): Int =
  if (a > b) 0
  else f(a) + sum1(f, a + 1, b)

def sumInt1(a: Int, b: Int) = sum1(x => x, a, b)
def sumCube1(a: Int, b: Int) = sum1(cube, a, b)

sumInt1(1, 5)
sumCube1(1, 5)

// лекция 2.1 currying
def sum2(f: Int => Int): (Int, Int) => Int = {
  def sumF(a: Int, b: Int): Int =
    if (a > b) 0
    else f(a) + sumF(a + 1, b)

  sumF
}

def sumInt2(a: Int, b: Int) = sum2(x => x)
def sumCube2 = sum2(cube)

sumInt2(1, 5)
sumCube2(1, 5)
sum2(cube)(1, 5)

// multiple args lists. Такая форма записи полностью эквивалентна sum2
// и является сахаром (просто чтобы не писать внутри sum2 вспомогательную функцию sumF)
def sum3 (f: Int => Int)(a: Int, b: Int): Int =
  if (a > b) 0 else f(a) + sum3(f)(a + 1, b)

def sumInt3: (Int, Int) => Int = sum3(x => x)
def sumCube3: (Int, Int) => Int = sum3(cube)

sumInt3(1, 5)
sumCube3(1, 5)
sum3(cube)(1, 5)

/*
Пусть функция представлена
  def f(arg1)(arg2)...(argsN-1)(argN) = E

Ее всегда можно каррировать так
  def f = (args1 => (args2 => ... (argsN => E)))
*/// Например:
def s = (x: Int) => (y: Int) => x + y
def plusOne = s(1)
plusOne(4)


def product0(f: Int => Int)(a: Int, b: Int): Int =
  if (a > b) 1
  else f(a) * product0(f)(a + 1, b)

def factorial0(b: Int) = product0(x => x)(1, b)

factorial0(5)


def mapReduce(f: Int => Int, combine: (Int, Int) => Int, zero: Int)(a: Int, b: Int): Int =
  if (a > b) zero
  else combine(f(a), mapReduce(f, combine, zero)(a + 1, b))

def sum4(f: Int => Int)(a: Int, b: Int): Int = mapReduce(f, (x, y) => x + y, 0)(a, b)
sum4(cube)(1, 5)

def product4(f: Int => Int)(a: Int, b: Int) = mapReduce(f, (x, y) => x * y, 1)(a, b)
def factorial4(n: Int) = product4(x => x)(1, n)
factorial4(5)