package general

object ImplicitParameters {
  def run() = {

    // implicit = the values will be taken from the context in which they are called
    class Prefixer(val prefix: Any)

    def addPrefix(s: String)(implicit p: Prefixer) = p.prefix + s
    implicit val implicitString = new Prefixer("hi")
    print(addPrefix("abc"))

  }
}

object ImplicitParametersInScalaDoc {
  abstract class Monoid[A] {
    def add(x: A, y: A): A
    def default: A
  }

  implicit val hey: Monoid[String] = new Monoid[String] {
    def add(x: String, y: String): String = x concat y
    def default: String = ""
  }

//  implicit val hmm: Monoid[Int] = new Monoid[Int] {
//    def add(x: Int, y: Int): Int = x + y
//    def default: Int = 0
//  }
  implicit val hmm2: Monoid[Int] = new Monoid[Int] {
    def add(x: Int, y: Int): Int = x + x
    def default: Int = 0
  }

  def sum[A](xs: List[A])(implicit m: Monoid[A]):A = {
    if (xs.isEmpty) m.default else m.add(xs.head, sum(xs.tail))
  }

  def run() = {
    println(sum(List("a", "b", "c", "d", "e")))
    println(sum(List(1,2,3,4,5)))

//    val banana = Banana()
//    println(banana.isInstanceOf[Banana])
//    val fruit = banana.asInstanceOf[Fruit]
//    println(fruit.isInstanceOf[Fruit])


  }
}

trait Fruit {
  val name: String
}


case class Banana(name: String = "banana") extends Fruit

