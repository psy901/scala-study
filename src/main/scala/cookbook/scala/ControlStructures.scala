package cookbook.scala

import scalaz.{-\/, \/, \/-}

// Chapter 3
object ControlStructures {
  def testUsingForLoopWithGuards(): Unit = {
    // In Scala, "Guards" refers to if statement

    // creating a list of even numbers with a ternary statement
    val foo = for (i <- 1 to 10 if (i % 2 == 0)) yield i
    println(foo)

    // re-writing the code using "Guards"
    val bar = for {
      i <- 1 to 10
      if (i % 2 == 0)
    } yield i
    println(bar)

    // using multipel "guards"
    val qoo = for {
      i <- 1 to 100
      if (i % 2 == 0)
      if (i > 10 && i < 40)
      if (i % 4 == 0)
    } yield i
    println(qoo)
  }

  def testForYieldGuardsWithScalaz(): Unit = {
    val names = List("MJ", "Kimmy", "")

    val result = names.map { name =>
      for {
        validName <- validationUtils.parseRequired(name)
      } yield Person(validName)
    }
    println(result)
  }

  def testMultipleCases(): Unit = {
    val i = 5
    i match {
      case 1 | 2 | 3 | 4 | 5 => println(">= 5")
      case 6 | 7 | 8 | 9 | 10 => println("< 5")
    }
  }

  def testPatternMatchingInMatchExpressions(): Unit = {

    def matchTest[A](x: Any): Unit = {
      x match {
        case (_: List[Integer]) => println("Int List")
        case (_: List["String"]) => println("String list")
        case (_: String) => println("String")
        case _ => println("something else!")
      }
    }

    val intList = List(1, 2, 3)
    val stringList = List("mj", "kimmy", "yunnie")


  }


}

object validationUtils {
  def parseRequired(value: String): String \/ String = {
    if (value.isEmpty) -\/(s"value cannot be empty") else \/-(value)
  }
}
case class Person(name: String)