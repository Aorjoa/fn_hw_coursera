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
      if (r == 0) {1}
      else if (c == 0) {1}
      else if (c == r) {1}
      else {
        pascal(c-1,r-1) + pascal(c,r-1)
      }
    }
  
  /**
   * Exercise 2
   */
    def balance(chars: List[Char]): Boolean = {
      def loop(chars: List[Char],foundC: Boolean): Boolean = {
        if (chars.isEmpty) !foundC
        else if (chars.head == '(') {
          false || !loop(chars.tail,true)
        }
        else if (chars.head == ')') {
          true && loop(chars.tail,true)
        }else
        loop(chars.tail,false)
      }
      loop(chars,false)
    }
  
  /**
   * Exercise 3
   */
    def countChange(money: Int, coins: List[Int]): Int = {
      if (coins.isEmpty) 0
      else if (money == 0) 1
      else if (money < 0 ) 0
      else
      countChange(money,coins.tail) + countChange(money - coins.head,coins)
    }
  }