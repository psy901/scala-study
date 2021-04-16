package general

import java.io.{ByteArrayInputStream, FileInputStream, FileReader, InputStreamReader}
import java.nio.charset.StandardCharsets.UTF_8

object ReadFile {
  def testReadingFile(): Unit = {
    val path = "/Users/parkzsp/Dev/Scala-Test/src/main/scala/resources/test.txt"
    val stream = new InputStreamReader(new FileInputStream(path), UTF_8)
    var str = stream.read()

    while (str != -1) {
      println(str)
      str = stream.read()
    }
  }

  def testByteArrayInputStream(): Unit = {
    val myString = "Hello World!"
    val inputStream = new ByteArrayInputStream(myString.getBytes(UTF_8))
    var data = inputStream.read()
    while (data != -1) {
      println(data.toChar)
      data = inputStream.read()
    }
  }

  def testInputStreamReader(): Unit = {
    val myString = "Hello, World!"
    val byteArrayInputStream = new ByteArrayInputStream(myString.getBytes(UTF_8))
    val reader = new InputStreamReader(byteArrayInputStream, UTF_8)

    var data = reader.read()
    while (data != -1) {
      println(data)
      data = reader.read()
    }
  }

  def testCsv(): Unit = {
    val myString = "Hello, World!"
    val byteArrayInputStream = new ByteArrayInputStream(myString.getBytes(UTF_8))
    val reader = new InputStreamReader(byteArrayInputStream, UTF_8)


  }
}
