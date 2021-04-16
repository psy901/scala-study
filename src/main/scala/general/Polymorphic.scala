package general

object Polymorphic {
  def run() = {

    val arr = Array(1,2,3,4,5,6,7)
    println(findFirst(arr, 4))
  }

  def findFirst[A](arr: Array[A], key: A) = {
   arr.indexOf(key)
  }
}
