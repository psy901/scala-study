package general

import java.time.temporal.ChronoUnit
import java.time.{Duration, Instant, LocalDate, Period, ZoneOffset}

object DateTest {
  def run() = {
    val start = Instant.now()

    val end = Instant.now().plus(20, ChronoUnit.MINUTES).plus(10, ChronoUnit.SECONDS).plus(Duration.ofDays(1))
    val duration = Duration.between(start, end)
    println(duration.toMinutes.asInstanceOf[Double])

  }

  def testLocalDate = {
    val UtcTimeZone: ZoneOffset = ZoneOffset.UTC
    val today = LocalDate.now(UtcTimeZone)
    println(today.toString)
    println(today.getDayOfMonth)
    println(today.getDayOfMonth)
    println(today.getDayOfWeek)
    println(today.getDayOfYear)
  }




}
