import java.util


import org.mockito.Mockito._
import org.mockito.ArgumentMatchers._

class MyList extends util.AbstractList[String] {


  override def get(index: Int): String = {
    "0"
  }

  override def size(): Int = {
    0
  }

  override def add(index: Int, elem: String) {

  }

}

class Robot {
  def talk(msg: String): String = {
    s"$msg $msg"
  }
}

case class TestException(msg: String) extends Exception(msg)

class TutorialTest extends UnitTest {


  describe("Simple Mocking and Verifying") {
    val myListMock = mock[MyList]
    val robotMock = mock[Robot]

    it ("should succeed!") {
      doNothing().when(myListMock).add(anyInt(), anyString())

      myListMock.add(1, "hey")

      verify(myListMock, times(1)).add(1, "hey")
    }

    it ("should throw an exception") {
//      doThrow(TestException("hmm")).when(robotMock).talk("wow!")
//      humanMock.wow
    }

    it ("should compare two strings") {
      val a = "test"
      val b = "test2"

      a shouldBe b
    }


  }
}
