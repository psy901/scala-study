package cookbook.scala

import cookbook.scala.NumbersUtils._
import cookbook.scala.Strings._

object Numbers {
  def testStringImprovementInOtherClass(): Unit = {
    val foo = Some("hello this is mj")
    println(foo.unpack())

    val bar = None
    println(bar.unpack())

  }

  def testComparingTwoFloats(): Unit = {
    val x = 0.3
    val y = 0.300123
    val precision = 0.001

    println(x.~=(y, precision))
  }

  def testCreatingListOfNumbers(): Unit = {
    val testList = for (i <- 0 to 10) yield i
    println(testList)
  }

//  def ~=(x: Double, y: Double, precision: Double): Boolean = {
//    (x-y).abs < precision
//  }
}

object NumbersUtils {
  implicit class FloatImprovement(x: Double) {
    def ~=(y: Double, precision: Double): Boolean = {
      (x-y).abs < precision
    }
  }
}
