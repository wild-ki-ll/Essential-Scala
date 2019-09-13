class Adder(amount: Int) {
  def add(in: Int) = in + amount
}

class Counter(val count: Int) {
  def dec = new Counter(count - 1)
  def inc = new Counter(count + 1)
  def adjust(adder: Adder) = new Counter(adder.add(count))
}

object lesson extends App {
  println(new Counter(10).dec.inc.adjust(new Adder(10)).count == 20)
}