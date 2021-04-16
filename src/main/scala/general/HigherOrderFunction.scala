package general

object HigherOrderFunction {
  def run() = {

  }


}

object SalaryRaiser {

  def smallPromotion(salaries: List[Double]): List[Double] =
    salaries.map(salary => salary * 1.1)

  def greatPromotion(salaries: List[Double]): List[Double] =
    salaries.map(salary => salary * math.log(salary))

  def hugePromotion(salaries: List[Double]): List[Double] =
    salaries.map(salary => salary * salary)
}

object RefactoredSalaryRaiser {
  def doPromotion(salaries: List[Double], promotionFunction: Double => Double): List[Double] = {
    salaries.map(promotionFunction)
  }
}
