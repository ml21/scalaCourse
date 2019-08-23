// https://www.coursera.org/learn/progfun1/lecture/weqsE/lecture-6-4-maps

// Map[key, value]

val romanNumerals = Map("I" -> 1, "V" -> 5, "X" -> 10)
romanNumerals("I")

val capitalOfCountry = Map("US" -> "Washington", "USSR" -> "Moscow")
capitalOfCountry("USSR")

capitalOfCountry("Andora")

// если мы не знаем, если ключ или нет, то можно использовать get
capitalOfCountry get "Andora"
val usCapital = capitalOfCountry.get("US").getOrElse("absent")
val usCapital1l = capitalOfCountry.getOrElse("US", "absent")

capitalOfCountry.getOrElse("Andora", "absent")
capitalOfCountry get "Andora" getOrElse "absent"

// sort и groupBy
val fruit = List("apple", "pear", "orange", "pineapple")

fruit.sortBy(a => a.head)

val groupped = fruit.groupBy(a => a.head)
groupped.get('z').getOrElse("")

// Polynomial
class Poly(val terms0: Map[Int, Double]) {

    def this(bindings: (Int, Double)*) = this(bindings.toMap)

    val terms = terms0 withDefaultValue 0.0

    def + (other: Poly): Poly = {
        def adjust(term: (Int, Double)): (Int, Double) = {
          val (exp, coeff) = term
          exp -> (coeff + terms(exp))
        }
        new Poly(terms ++ (other.terms map adjust))
    }

    override def toString =
        (for ((exp, coef) <- terms) yield coef + "x^" + exp) mkString " + "
}

// 2x + 4x^3 + 6.2x^5
val p1 = new Poly(1 -> 2, 3 -> 4, 5 -> 6.2)
// 3 + 7x^3
val p2 = new Poly(0 -> 3, 3 -> 7)
p1 + p2