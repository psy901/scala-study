package general

import java.io.StringWriter
import java.sql.Timestamp
import java.time.{Instant, LocalDate, LocalDateTime, LocalTime, ZoneOffset}

import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.module.scala.DefaultScalaModule

case class FirstException(message: String) extends Exception(message)
case class SecondException(message: String) extends Exception(message)

class CustomException(msg: String) extends Exception(msg)
case class CarTest(color: String, maker: String) extends Vehicle(color)
class Vehicle(name: String)
class Test(msg: String) extends Exception(msg)

object RandomThings {


  def doubleAndShout(num: Int) = {

    if (num % 2 > 0) throw new Exception("Wrong!")
    val doubled = num * 2


    () => {
      println(doubled)
    }
  }


  def testReturnFunction: Unit = {

    val list = List(1,2,3,4,5)
    val newList = list.map(num => {

    })

    println(newList)

  }

  def testObjectMapper: Unit = {
    val mapper = new ObjectMapper()
    mapper.registerModule(new DefaultScalaModule)
    val out = new StringWriter()
    val car = CarTest("white", "honda")


    mapper.writeValue(out, car)
    println(out.toString)

    val carJson = out.toString
    val car2 = mapper.readValue(carJson, classOf[CarTest])
    println(car2)

  }






  def testListFlatten = {
    val list = List(Some(1), None, Some(2))
    println(list)

    println(list.flatten)
  }

  def testReplace = {
    val key = "2020/07/22/sustain/2020-07-22T03:06:18.617Z-feedback.csv"
    val newKey = key.replace(".csv", "-validated.csv").replaceAll("[:]", "-")
    println(newKey)

  }

  def unempty(s: String): Option[String] = {
    if (s == null || s.isEmpty) None
    else Some(s)
  }


  def testFlatMap: Unit = {
    val names = List("MJ", "KiMmy")
    val result = names.flatMap(s => s.toLowerCase())
    println(result)

    val nums = List(List(1,2,3), List(4,5,6), List(List(7,8), List(9)))
    val result2 = nums.flatten
    println(result2)

    val op1 = List(Option("hmm"))
    val result3 = op1.flatMap(a => a)
  }

  def testForYield: Unit= {
    val result = for (i <- 1 to 5)
      yield i

    println(result)
  }


  def yieldMultiples(num: Integer) = {

  }


  def testEither: Unit = {
    val a = "1b"
    val result: Either[String, Int] = try {
      Right(a.toInt)
    } catch {
      case e: Exception => {
        Left("nope")
      }
    }
  }

  def testDifferentTime = {
    val maxTime = LocalDate.now().atTime(LocalTime.MAX)
    val minTime = LocalDate.now().atTime(LocalTime.MIN)
    val startTime = LocalDate.now().atStartOfDay()

    println(s"Max $maxTime / Min: $minTime / start: $startTime")

  }


  def testListForAll = {
    val names = List("a", "bb", "c")
    val result = names.forall(name => {
      println(s"$name: ${name.length}")
      name.length == 1
    })
    println(result)

  }

  def testTimeConversion = {

    val utc = ZoneOffset.UTC
    val i = LocalDateTime.now().toInstant(utc)
    val inst = Instant.now()

    val localDate = inst.atZone(utc).toLocalDate
    println(localDate)

    println(i)

    val dt = LocalDateTime.ofInstant(i, utc)
    println(dt)

    //    dateTimeFilter
  }

  def dateTimeFilter = {
    val dt1 = LocalDateTime.of(2020, 6, 1, 0, 0)
    val dt2 = LocalDateTime.of(2020, 6, 1, 23, 55)
    val dt4 = LocalDateTime.of(2020, 6, 2, 0,0)
    val dt3 = LocalDateTime.of(2020, 6, 2, 23, 59)

    val runDate = LocalDate.of(2020, 6, 2)
    //    val startTime = runDate.minusDays(1).atTime(23,59)
    val startTime = runDate.atStartOfDay()
    val endTime = runDate.plusDays(1).atStartOfDay()
    println(s"$startTime ~ $endTime")

    val dataMap = Map(dt1 -> 1, dt2 -> 2, dt3 -> 3, dt4 -> 4)
    val result = dataMap.filter(x =>{
      val time = x._1

      time.isAfter(startTime) && time.isBefore(endTime)
    })
    println(s"\rResult: $result")

  }

  def helper(): Option[Int] = {
    try {
      val map = Map("a" -> 1, "b" -> 2)
      val firstResult = map.getOrElse("a", throw new FirstException(("First Exceptin!!!")))
      val secondResult = map.getOrElse("d", throw new SecondException("Second Exception"))
      Some(secondResult)

    } catch {
      case e: FirstException => {
        println(e.getMessage)
        None
      } case e2: SecondException => {
        println(e2.getMessage)
        None
      }
    }
  }


  def toInt(s: String): Option[Int] = {
    try {
      Some(Integer.parseInt(s.trim))
    } catch {
      case e: Exception => None
    }
  }

  def dateTest = {
    val d1 = LocalDate.of(2020, 1, 20)
    val d2 = LocalDate.of(2020, 6, 2)
    val d3 = LocalDate.of(2020, 1, 3)
    val d4 = LocalDate.of(2020, 6, 4)
    val d5 = LocalDate.of(2020, 3, 5)

    val map = Map(d1 -> 1, d2 -> 2, d3 -> 3, d4 -> 4, d5 -> 5)
    //    val map = Map(d1 -> 2)
    println(map)


    val result = map.keysIterator.reduceLeft((d1, d2) => if (d1.isAfter(d2)) d1 else d2)
    println(result)

    val result2 = map.keys.max
    println(result2)


    // TESTING
    val runDate: LocalDate = LocalDate.of(2020, 6, 23)
    val now: LocalDateTime = LocalDateTime.of(2020, 6, 23, 0, 20)
    val timestamp = now.minusHours(1)
    val timestampDate = timestamp.toLocalDate

    val cappedMetricDateTime = if (timestampDate.isAfter(runDate)) {
      runDate.atTime(23, 59)
    } else if (timestampDate.isBefore(runDate)) {
      runDate.atTime(0, 0)
    } else {
      timestamp
    }
    val time = Timestamp.valueOf(cappedMetricDateTime)
    println(time)
  }

}
