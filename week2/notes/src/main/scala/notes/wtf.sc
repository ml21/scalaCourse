// Что мне показалось странным

// определяем функцию, которая возвращает Int
def sum(a: Int, b: Int): Int = a + b

sum(1, 2)

// определяем метод, который возвращает константу
def f = sum(1, 2)
f

// вот этот момент был для меня неожиданным: я ожидал, что этот метод g при вызове
// вне зависимости от значений переданных ему агрументов a, b будет возвращать 3.
// он же ведет себя так, как я ожидал бы от примерно такого определения:
// def g(a: Int, b: Int) = sum
def g(a: Int, b: Int) = sum(a, b)
g(2,2)
