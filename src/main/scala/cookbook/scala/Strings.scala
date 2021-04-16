package cookbook.scala


object Strings {
  implicit class StringImprovement(os: Option[String]) {
    def unpack(): String = {
      os match {
        case Some(value) => value
        case None => "default"
      }
    }
  }

  def processStringOneChar(): Unit = {
    val hello = "Hello"

    // Different syntax { } or ( )
    println(hello.map(c => c.toUpper))
    println(hello.map{c => c.toUpper})
  }

}
