package general

// DataType case class
case class Ec2Api(name: String, value: Int)
case class Ec2(name: String, value: Int)



// trait for service that contains an overriding method and its serviceName
trait Service[T] {
  val serviceName: String
  def callService: List[T]
}


object Ec2ApiService extends Service[Ec2Api] {
  override val serviceName = "EC2PI"

  override def callService: List[Ec2Api] = {
    List(Ec2Api("ec2api", 100))
  }
}


object Ec2 extends Service[Ec2] {
  override val serviceName: String = "EC2"

  override def callService: List[Ec2] = {
    List(Ec2("ec2", 20))
  }
}


class TraitExample {
  def run = {
    Ec2ApiService.callService
  }
}
