package general

import java.time.LocalDate

import scala.util.{Failure, Success, Try}

case class TestException(message: String) extends Exception(message)

object TryTest {
  def run() = {
    val date = LocalDate.parse("2020-08-01")
    println(date)

    val nums = List("1", "2", "3", "asdfjk", "5050", "aaab")

    val results = List((date, Failure(TestException("hmm"))))
    val combined = combineTryResultsMessages(results)
    println(combined)

    val list = List(Some(1, "aaa"), None, Some(2, "bbb"))
    println(list.flatten)
    println(list.flatten.toMap)

//    val nums = List("1", "2", "3", "5050" )

//    nums.map(num => Try(parseInt(num)))

//    val results = nums.map(num => Try(parseInt(num)))
//    val results = List(Failure(CustomException("failure1")), Success("success"), Failure(CustomException("failure2")))

//    val combined = combineTryResultsMessages(results)
//    println(s"Result: $results")
//    println(s"Combined: $combined")

// handleResults(results)


  }

  def combineTryResultsMessages(results: List[(LocalDate, Try[Any])]): String = {

    results.flatMap {
      case (date, Failure(error)) =>
        Some(s"$date: $error")
      case _ =>
        None
    }.mkString(" | ")
  }

  def parseInt(num: String): Int = Integer.parseInt(num)

  def handleResults(results: List[Try[Any]]): Unit = {
    // group all error message
    val finalResult = results.flatMap {
      case Failure(e) =>
        Some(e.getMessage)
      case _ =>
        None
    }

    val combinedMessages = finalResult.mkString("\n")
    println(combinedMessages)
    println(combinedMessages.isEmpty)
    throw TestException(combinedMessages)

  }

}
