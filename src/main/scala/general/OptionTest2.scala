package general


/**
 * Using Option in Scala, Part 2: map and flatmap
 * https://freecontent.manning.com/using-option-in-scala-part-2-map-and-flatmap/
 */
case class Car(model: String, owner: Option[Person], registrationPlate: Option[String])
case class Person(name: String, age: Int, drivingLicense: Option[String])

object OptionTest2 {

  def run(): Unit = {
    val p1 = Person("James", 30, Some("LIS1234"))
    val car1 = Car("honda", None, None)
    val car2 = Car("bmw", Some(p1), Some("BBBAAA"))


    // driverLicense of an owner of a car?
    println(ownerDrivingLicense(car2))

    // Flatten
    /*

     */
    println(List(Some(1), None, Some(2)).flatten)
    println(ownerBelowAge(car2, 40))
  }

  // returns the license of the owner
  def powerOfFlatMap(car: Option[Car]): Option[String] = {
    car.flatMap {car =>
      car.owner.flatMap { p =>
        p.drivingLicense
      }
    }
  }

  // returns optional string containing the name of the car owner whose age is below 'age'
  def ownerBelowAge(car: Car, age: Int): Option[String] = {
    car.owner.flatMap {p =>
      if (p.age < age)
        Some(p.name)
      else
        None
    }
  }

  def supperFlatten(opt: Option[Option[Option[String]]]): Option[String] = {
    // 'flatten' if the outer optional value is Some, return the inner instance
    // else if None, return None
    opt.flatten.flatten
  }

  def ownerDrivingLicense(car: Car): Option[String] = {
    // map applies function and returns it wrapped by Some
    // car.owner.map(_.drivingLicense) : Option[Option[String]]
    car.owner.map(_.drivingLicense).flatten

    // flatten.. if the outer optional value is Some(x), it returns its inner instance x.
    // if the outer optional value is None, it returns None


    // flatMap
    // if an optional value is present, applies a function and returns its inner instance
    // if an optional value is None, returns None

    // car.owner.map(_.drivingLicense).flatten can be written as
    // version 1
    car.owner.flatMap(_.drivingLicense)

    // version 2
    car.owner.flatMap(p => p.drivingLicense)


    // version 3 -- with curly braces
    car.owner.flatMap{p =>
      println("hi")
      p.drivingLicense
    }

    // version 4
    car.owner.flatMap(_.drivingLicense)

  }

  def ownerName(car: Car): Option[String] = {
    car.owner match {
      case Some(owner) => Some(owner.name)
      case None => None
    }
  }
  /*
   map = applying a function to the content of an optional value
   */
  def ownerName2(car: Car): Option[String] = {
    // if the optional value is present, it applies the function f to it and return it wrapped as optional value
    car.owner.map(p => p.name)
  }
  def extractRegistrationPlate(car: Car): Option[String] = {
    car.registrationPlate.map(reg => reg.toUpperCase())
  }

}
