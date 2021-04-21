package cookbook.scala

object Ch10_Collections {

  def transformOneCollectionToAnotherWithMap(): Unit = {
    val helpers = Vector("adam", "kim", "melissa")

    // 1. apply 'map' on a collection to transform
    var capitalizedHelpers = helpers.map(item => item.capitalize)
    println(capitalizedHelpers)

    // 1-b: in a short form
    capitalizedHelpers = helpers.map(_.capitalize)
    println(capitalizedHelpers)
  }

  def flatteningAListOfListsWithFlatten(): Unit = {

    // "flatten" flattens the lists held inside the outer list into one resulting list
    val lol = List(List(1,2), List(3,4))
    println(lol.flatten)

  }

  def combiningMapAndFlattenWithFlatMap(): Unit = {
    val bag = List("1", "2", "three", "4", "one hundred seventy five")

    def toInt(in: String): Option[Int] = {
      try {
         Some(Integer.parseInt(in.trim))
      } catch {
        case e: Exception => None
      }
    }

    println(bag.map(toInt))
  }

  def run(): Unit = {
//    transformOneCollectionToAnotherWithMap()
    flatteningAListOfListsWithFlatten()
  }
}
