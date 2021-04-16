
import org.scalatest._
import Matchers._
import general.Hello
import org.mockito.Mockito._
import org.mockito.ArgumentMatchers._


class Person {
  val age = 10
  def speak(): String = {
    "com.amazon.Hello"
  }

  def getAge: Int = {
    age
  }

  def getStatus(): Boolean = {
    Human.tellTrue()
  }

  def yell(word: String): String = {

    if (getStatus()) {
      s"ERROR ERROR"
    } else {
      s"$word $word"
    }
  }
}

object Human {
  def tellTrue(): Boolean = {
    true
  }
}


class HelloTest extends UnitTest {

  describe("Matcher test") {
    it("should pass this") {
      val string = "com.amazon.Hello World seven"
      string should startWith("com.amazon.Hello")
      string should endWith("seven")

    }

    it("should ignore this test") {
      val result = 3
      result shouldBe 3
      result should equal(3)

    }
  }

  describe("Spy and Verify test") {
    it ("spy and doReturn Test") {
      val spiedPerson = spy(new Person)
      doReturn(20).when(spiedPerson).getAge

      spiedPerson.getAge shouldBe 20
      verify(spiedPerson, times(1)).getAge

      spiedPerson.getAge shouldBe 20
      verify(spiedPerson, times(2)).getAge

    }
  }

  describe("Mock Test!") {
    it("should play with mock") {

      val spiedPerson = spy(new Person)

      spiedPerson.getAge shouldBe 10

      doReturn(20).when(spiedPerson).getAge
      spiedPerson.getAge shouldBe 20

      when(spiedPerson.getAge).thenReturn(50)
      spiedPerson.getAge shouldBe 50

      val mockedPerson = mock[Person]
      when(mockedPerson.getAge).thenReturn(10)

      mockedPerson.getAge shouldBe 10

      doReturn(30).when(mockedPerson).getAge
      mockedPerson.getAge shouldBe 30
    }
  }

  describe("ArgumentMatcher Test") {
    it("should match any input string") {
      val mockedPerson = mock[Person]

      when(mockedPerson.yell(anyString())).thenReturn("Hey Bro!")

//      when(mockedPerson.getStatus).thenReturn(false)
      mockedPerson.yell(("Hey Hey")) shouldBe "Hey Bro!"
    }

    it("should SPY succed?") {
      val spiedPerson = spy(new Person)
      when(spiedPerson.getStatus()).thenReturn(false)
      spiedPerson.yell("hey") shouldBe "hey hey"
    }

    it("real test") {
      val spiedPerson = spy(new Person)
      when(spiedPerson.getStatus()).thenReturn(false)
      spiedPerson.yell("Yo!")
    }
  }
}