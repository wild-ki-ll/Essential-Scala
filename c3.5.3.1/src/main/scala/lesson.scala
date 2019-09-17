case class Cat(color: String, food: String);

object ChipShop {
  def willServe(cat: Cat): Boolean =
    cat match {
      case Cat(_, "chips") => true
      case _ => false
    }
}

object Lesson extends App {
  println(ChipShop.willServe(Cat("a", "milk")) == false)
  println(ChipShop.willServe(Cat("a", "chips")) == true)
}
