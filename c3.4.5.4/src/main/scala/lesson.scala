case class Person(val firstName: String, val lastName: String);

object Person {
  def apply(name: String): Person = {
    val parts = name.split(" ")
    apply(parts(0), parts(1))
  }
}

object Lesson extends App {
  println(Person("John Doe").firstName == "John")
}
