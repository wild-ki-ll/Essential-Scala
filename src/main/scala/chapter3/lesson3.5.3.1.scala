package chapter3

object Lesson3_5_3_1 extends App {

  case class Cat(color: String, food: String);

  object ChipShop {
    def willServe(cat: Cat): Boolean =
      cat match {
        case Cat(_, "chips") => true
        case _ => false
      }
  }

  println(ChipShop.willServe(Cat("a", "milk")) == false)
  println(ChipShop.willServe(Cat("a", "chips")) == true)
}
