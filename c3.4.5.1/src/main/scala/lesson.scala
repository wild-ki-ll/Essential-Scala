case class Cat(color: String, food: String);

object Lesson extends App {
  println(Cat("grey", "milk").food == "milk")
}
