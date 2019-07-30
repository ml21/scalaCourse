def gcd(a: Int, b: Int): Int =
  if(b == 0) a else gcd(b, a % b)

gcd(14, 21)
gcd(1112323, 1224)

//@tailrec
//def factorial(a: Int): Int =
//  if(a == 0) 1 else a * factorial(a - 1)

//factorial(5)

def factorial(n: Int): Int = {
  def factorialInternal(n: Int, acum: Int): Int =
    if(n == 0) acum else factorialInternal(n - 1, n * acum)

  factorialInternal(n, 1)
}

factorial(5)


