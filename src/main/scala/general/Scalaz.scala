package general

import scalaz.{-\/, \/, \/-}

object Scalaz {

  def testEitherWithFlatmap(either: String \/ String, expectedValue: String) = {

    val result = parseRequired("accepted", "accepted").flatMap(v => {
      println(v)
      \/-(v)
    })
    result
  }

  def parseRequired(column: String, value: String): String \/ String = {
    if (value.isEmpty) -\/(s"$column cannot be empty") else \/-(value)
  }
}
