class Person(val firstName: String, val lastName: String);

object Person {
  def apply(name: String): Person = {
    val parts = name.split(" ")
    new Person(parts(0), parts(1))
  }
}

object Lesson extends App {
  val parts = "John Doe".split(" ")
  println(parts(0) == "John")
}
