package program

import scala.annotation.tailrec

object Main extends App {
  println("notes app")
  loop

  def loop: Int = {
    while(true) println(loop)

    return 2;
  }
}
