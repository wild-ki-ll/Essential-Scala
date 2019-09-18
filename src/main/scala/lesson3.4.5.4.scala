object Lesson3_4_5_4 extends App {

  case class Person(val firstName: String, val lastName: String);

  object Person {
    def apply(name: String): Person = {
      val parts = name.split(" ")
      apply(parts(0), parts(1))
    }
  }

  println(Person("John Doe").firstName == "John")
}
