package general

object Currying {

  val numbers = List(1,2,3,4,5,6,7,8,9,10)

  def run() = {
    val res = mapEvenNumbers(numbers){ num =>
      s"$num + $num = $num$num"
    }

    println(res)
  }

  def mapEvenNumbers[A](nums: List[Int])(doThis: Int => A): List[A] = {

    // filter even numbers, then do an operation passed by 'doThis'
    val evenNums = nums.filter(_ % 2 == 0)
    evenNums.map(num => doThis(num))
  }


//  def foldLeft[B](z: B)(op: (B,A) => B): B
  def foldLeft1[A,B](as: List[A], b0: B, op: (B,A) => B) = ???

  //  def notPossible = foldLeft1(numbers, 0, _ + _)
  def possible = foldLeft1[Int, Int](numbers, 0, _ + _)


  def foldLeft2[A,B](as: List[A], b0: B)(op: (B,A) => B) = {
    as.foldLeft(b0)(op)
  }
  def possible2() = foldLeft2(numbers, 0)(_ + _)
}
