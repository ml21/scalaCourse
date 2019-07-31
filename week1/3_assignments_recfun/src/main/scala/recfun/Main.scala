package recfun

object Main {
  def main(args: Array[String]) {
    println("Pascal's Triangle")
    for (row <- 0 to 10) {
      for (col <- 0 to row)
        print(pascal(col, row) + " ")
      println()
    }
  }

  /**
   * Exercise 1
   */
    def pascal(c: Int, r: Int): Int = {
      def isFirstElement: Boolean = c == 0 && r ==0
      def isOutsideElement: Boolean = (c < 0 ||  c > r + 1) || (r < 0)

      if(isFirstElement) 1
      else if (isOutsideElement) 0
      else pascal(c, r - 1) + pascal(c - 1, r - 1)
    }
  
  /**
   * Exercise 2
   */
    def balance(chars: List[Char]): Boolean = {
      def balanceInternal(chars: List[Char], cb: Int): Boolean =
        if (cb < 0) false
        else if (chars.isEmpty) !(cb > 0)
        else if (chars.head == ')') balanceInternal(chars.tail, cb - 1)
        else if (chars.head == '(') balanceInternal(chars.tail, cb + 1)
        else balanceInternal(chars.tail, cb)

      balanceInternal(chars, 0)
    }
  
  /**
   * Exercise 3
   */
    def countChange(money: Int, coins: List[Int]): Int = {
      if(money == 0)
        1
      else if(money > 0 && !coins.isEmpty)
        countChange(money - coins.head, coins) + countChange(money, coins.tail)
      else
        0
    }
  }
