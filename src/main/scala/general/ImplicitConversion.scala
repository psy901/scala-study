package general

object ImplicitConversion {

  class Prefixer(val prefix: String)
  def addPrefix(s: String)(implicit p: Prefixer) = p.prefix + s



  def run(): Unit = {
    implicit val implicitPrefixer = new Prefixer("***")
    println(addPrefix("abc"))
  }
}
