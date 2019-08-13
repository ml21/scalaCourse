//https://www.coursera.org/learn/progfun1/lecture/8ZaPo/lecture-4-5-decomposition
// задача сделать иерархию для выполнения операции сложения над числами

trait Expr {
    def isNumber: Boolean
    def isSum: Boolean
    def numValue: Int
    def leftOp: Expr
    def rightOp: Expr
}

class Number(n: Int) extends Expr {
    def isNumber: Boolean = true
    def isSum: Boolean = false
    def numValue: Int = n
    def leftOp: Expr = throw new Error("Number.leftOp")
    def rightOp: Expr = throw new Error("Number rightOp")
}

class Sum(e1: Expr, e2: Expr) extends Expr {
    def isNumber = false
    def isSum = true
    def numValue = throw new Error("Sum.numValue")
    def leftOp: Expr = e1
    def rightOp: Expr = e2
}

def eval(e: Expr): Int = {
    if (e.isNumber) e.numValue
    else if (e.isSum) eval(e.leftOp) + eval(e.rightOp)
    else throw new Error("Unknow expression " + e)
}

eval(new Sum(new Number(1), new Number(2)))

// проблема в том, что слишком многословно и утомительно писать столько кода ради такой простой операции

//решение 1: использовать isInstanceOf и asInstanceOf, тогда не нужны будут методы isSum, isNumber, операнды в Number, numValue в Sum
// но это слишком низкий уровень и так лучше не делать

// решение 2:

trait Expr2 {
    def eval: Int
}

class Number2(n: Int) extends Expr2 {
    def eval: Int = n
}

class Sum2(e1: Expr2, e2: Expr2) extends Expr2 {
    def eval: Int = e1.eval + e2.eval
}

val a = new Sum2(new Number2(1), new Number2(2)).eval


/*
Все хорошо, но допустим мы добавим операцию умножения и будем работать с выражением, которое хотим упростить
a * b + a * c = a * (b + c)

Здесь нам снова понадобятся методы из первоначальной реализации, так тут понадобится знание о всем дереве операций, а не только
о текущей ветке.

Это ограничение объектно ориентированной декомпозиции - она хороша для реализаций функции eval, но не для других вещей,
требующих не локального, но общего знания. Это проблема будет решена в лекции 4.6 про паттерн матчинг.
*/