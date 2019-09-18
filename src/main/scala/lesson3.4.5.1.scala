object Lesson3_4_5_1 extends App {

  case class Cat(color: String, food: String);

  println(Cat("grey", "milk").food == "milk")
}
