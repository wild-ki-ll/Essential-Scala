object Lesson3_3_2_1 extends App {

  class Person(val firstName: String, val lastName: String);

  object Person {
    def apply(name: String): Person = {
      val parts = name.split(" ")
      new Person(parts(0), parts(1))
    }
  }

  println(Person("John Doe").firstName == "John")
}