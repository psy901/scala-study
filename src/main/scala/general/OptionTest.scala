package general

case class PersonTwo(first: String, middle: Option[String] = None, last: String)

object OptionTest {

  def run(): Unit = {

    val p1 = PersonTwo("MJ", Some("SangYun"), "Park")
    val p2 = PersonTwo(first = "Kimmy", last = "Kim")

    List(p1, p2).foreach(p => {
      println(getFullName(p))
    })
  }


  def getFullName(person: PersonTwo): String = {
    s"${person.first} ${person.middle.getOrElse("")} ${person.last}"
  }
}


