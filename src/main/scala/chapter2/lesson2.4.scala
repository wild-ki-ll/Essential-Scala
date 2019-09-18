package chapter2

object Lesson2_4 extends App {

  class Counter(val count: Int) {
      def dec = new Counter(count - 1)
      def inc = new Counter(count + 1)
  }

  println(new Counter(10).inc.dec.inc.inc.count)
}