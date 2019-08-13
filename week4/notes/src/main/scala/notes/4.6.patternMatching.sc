// https://www.coursera.org/learn/progfun1/lecture/cdHAM/lecture-4-6-pattern-matching
// задача сделать иерархию для выполнения операции сложения над числами: sum, prod, var, simplify

trait Expr
case class Number(n: Int) extends Expr
case class Sum(e1: Expr, e2: Expr) extends Expr

/*
неявно здесь добавляется

object Number {
    def apply(n: Int) = new Number(n)
}

поэтому можно написать так:
*/

Number(1) // это тоже самое, что и new Number(1)

/*
Pattern matching - это обобщение привычного switch. Он используется в Scala с помощью слова match
*/

def eval(e: Expr): Int = e match {
    case Number(n) => n
    case Sum(e1, e2) => eval(e1) + eval(e2)
}

eval(Sum(Number(1), Number(2)))

/*
Несколько правил
- после match следует последовательность кейсов в виде pattern => expression
- каждый кейс связывает паттерн pattern и выражение expression
- если нет подходящего кейса, будет сгенерировано исключение MatchError
*/

case class Prod(e1: Expr, e2: Expr) extends Expr
case class Var(x: String) extends Expr

def eval1(e: Expr): Int = e match {
    case Number(n) => n
    case Sum(e1, e2) => eval(e1) + eval(e2)
    case Prod(e1, e2) => eval(e1) * eval(e2)
}

def show(e: Expr): String = e match {
    case Number(n) => n.toString()
    case Sum(e1, e2) => show(e1) + " + " + show(e2)
    case Prod(Sum(e1, e2), e3: Expr) => "(" + show(e1) + " + " + show(e2) + ") * " + show(e3)
    case Prod(e3: Expr, Sum(e1, e2)) => show(e3) + " * (" + show(e1) + " + " + show(e2) + ")"
    case Prod(e1, e2) => show(e1) + " * " + show(e2)
    case Var(x) => x
}

show(Number(1))
show(Sum(Number(1), Number(2)))
show(Prod(Number(1), Number(2)))
show(Sum(Prod(Number(2), Number(3)), Prod(Number(2), Number(5))))

show(Var("x"))
show(Sum(Var("x"), Var("y")))
show(Prod(Var("x"), Var("y")))
show(Sum(Number(2), Var("x")))
show(Prod(Number(2), Var("x")))
show(Prod(Prod(Var("x"), Var("y")), Var("z")))
show(Prod(Sum(Number(2), Var("x")), Var("y")))
show(Prod(Var("y"), Sum(Number(2), Var("x"))))