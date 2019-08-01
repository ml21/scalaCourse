def sum(a: Int, b: Int): Int = a + b

sum(1, 2)

// каррируем


// def plus1 = curr(
// plus1(a) = a + 1

def f(f1: () => Int, f2: () => Int): Int = f1() + f2()

def f1 = () => 1;
def f2 = () => 2;
f(f1, f2)

def g(a: Int, f: Int => Int): Int => Int = (b: Int) => a + f(b)

g(1, x => x)(3)

def plus1 = g(1, x => x)
plus1(2)

def p(x: Int) = (y: Int) => x + y
def p1 = p(1)
p1(5)

def p2(a: Int)(b: Int) = ???


def k = (a: Int) => (b: Int) => a + b

def k1 = k;
def plusOne = k1(1)
plusOne(3)

