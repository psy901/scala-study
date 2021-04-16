package general

case class User(name: String, age: Int)


object ForComprehension {
  val userBase = List(
    User("Travis", 28),
    User("Kelly", 33),
    User("Jennifer", 44),
    User("Dennis", 23))
  val s = "hi"

  def run() = {
    val result = for (user <- userBase) yield user.name
    println(result)
  }
}
