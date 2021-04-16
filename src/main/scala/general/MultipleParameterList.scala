package general

object MultipleParameterList {

  val numbers = List(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
  val res = numbers.foldLeft(0)((m, n) => m + n)

  def run = {

    /*
    "in Scala, type inference proceeds one parameter list at a time."
     */
    def foldLeft1[A,B](as: List[A], b0: B, op: (B,A) => B) = ???

    // This is not possible because 'A' and 'B' is already being inferred, so "_ + _" is not able to be inferred
    // => Think as .. A and B are already in the parameter list, so it is not possible to infer _ + _ as A + B since
    // A and B are already being inferred (= in the parameter list)
//      def notPossible= foldLeft1(numbers, 0, _ + _)

//    def firstWay = foldLeft1[Int, Int](numbers, 0, _ + _)


    def foldLeft2[A,B,C,D](as: List[A], b0: B, c0: C)(op: (B,A) => B) = ???
    def possible = foldLeft2(numbers, 0, 0)(_ + _)

  }
}
