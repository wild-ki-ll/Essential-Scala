object Lesson2_6 extends App {
  class Adder(amount: Int) {
    def add(in: Int) = in + amount
  }

  class Counter(val count: Int) {
    def dec = new Counter(count - 1)
    def inc = new Counter(count + 1)
    def adjust(adder: Adder) = new Counter(adder.add(count))
  }

  println(new Counter(10).dec.inc.adjust(new Adder(10)).count == 20)
}