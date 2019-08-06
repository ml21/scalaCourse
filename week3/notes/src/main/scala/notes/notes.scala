package notes

import week3._

object notes {
    def argsToString(args: Array[String]): String =
    if (args.isEmpty) ""
    else args.head + " " + argsToString(args.tail)

    var r = new Rational(1, 2)

    def main(args: Array[String]) = println("Hello world " + r + argsToString(args))
}
