package general

import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.module.scala.DefaultScalaModule
import scala.io.Source.fromFile

case class Bike(color: Option[String], make: Option[String])

case class AnomalyCheckParameters(w: Double, f: Double, d: Double)
case class AnomalyCheckParametersOverride(w: Option[Double], f: Option[Double], d: Option[Double])
case class AnomalyCheckParametersOverrideConfig(anomalyCheckParameters: AnomalyCheckParametersOverride,
                                                   metricSpecificParameters: Option[Map[String, AnomalyCheckParametersOverride]])


object ObjectMapperTest {
  def run() = {
    val mapper = new ObjectMapper()
    mapper.registerModule(DefaultScalaModule)
    val json = fromFile("/Users/parkzsp/Dev/scala-study/src/main/scala/resources/parameters.json")
    val parameter = mapper.readValue(json.reader(), classOf[AnomalyCheckParametersOverrideConfig])

    println(parameter)
  }
}
