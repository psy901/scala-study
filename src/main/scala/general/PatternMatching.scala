package general

abstract class Notification

case class Email(sender: String, title: String, body: String) extends Notification
case class SMS(caller: String, message: String) extends Notification



object PatternMatching {
  def run(): Unit = {
    classMatch()


  }

  def classMatch(): Unit = {
    val email = Email("MJ", "first email", "This is the first email")
    val sms = SMS("kimmy", "hey MJ!")

    callNotification(email)
    callNotification(sms)
  }

  private def callNotification(notification: Notification): Unit = {
    notification match {
      case Email(sender, _, _) =>
        println(s"Email is sent from: $sender")
      case SMS(_,message) =>
        println(s"SMS is sent with a message: $message")
    }
  }
}
