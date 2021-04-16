package general

object General {
  def run() = {
    IfThenElse()
    ForLoop()
  }

  def IfThenElse(): Unit = {
    val a = 10
    val b = 20

    // assign C with ternary operator
    val c = if (a < b) 30 else 40
    println(c)
  }

  def ForLoop() = {
    val c = for (i <- 1 to 5) yield {
      i * 2
    }
    println(c)


    val list = List(1, 2, 3, 4, 5, 6)
    val result = for (i <- list) yield {
      if (i % 2 == 0) i else 0
    }
    println(result)

  }

}
