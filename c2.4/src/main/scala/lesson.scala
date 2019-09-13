class Counter(val count: Int) {
    def dec = new Counter(count - 1)
    def inc = new Counter(count + 1)
}

object lesson extends App {
  println(new Counter(10).inc.dec.inc.inc.count)
}