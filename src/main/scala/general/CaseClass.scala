package general

object CaseClass {
  def run() = {
    copying()
  }

  def copying() = {
    case class Message(sender: String, recipient: String, body: String)

    val msg4 = Message("MJ@amazon.com", "Kimmy@gmail.com", "Hi")
    val msg5 = msg4.copy(sender = "newSender@amazon.com")

    println(msg5)
    println(msg4)
  }

}
