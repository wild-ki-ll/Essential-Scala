package chapter3

object Lesson3_4_5_3 extends App {

  case class Counter (val count: Int = 0) {
    def dec: Counter = copy(count-1);
    def inc: Counter = copy(count+1);
  }

  println(Counter().count == 0)
  println(Counter().inc.count == 1)
  println(Counter(2).dec.count == 1)
  println(Counter().dec.inc == Counter().inc.dec)
}
