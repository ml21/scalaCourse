package notes

object notes {
    def argsToString(args: Array[String]): String = 
    if (args.isEmpty) ""
    else args.head + " " + argsToString(args.tail)
    
    def main(args: Array[String]) = println("Hello world " + argsToString(args))
}
