package general

import java.text.SimpleDateFormat

import scalaz._

import scala.util.Random

case class Pair(num: Int, str: String)

object ForYield {

  def run: Unit = {
    val hourFormat = new SimpleDateFormat()
    val result = for (i <- 0 to 4) yield Pair(generateInt, generateString)
    println(result)


  }

  def generateInt: Int = {
    Random.nextInt(3)
  }

  def generateString: String = {
    val list = List("hey", "hello", "yo")
    list(Random.nextInt(3))
  }
}
