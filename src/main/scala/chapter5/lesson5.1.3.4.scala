package chapter5

object Lesson5_1_3_4 extends App {
  sealed trait LinkedList[A] {
    def apply (idx: Int) = {
      def impl (i: Int, lst: LinkedList[A]): A = lst match {
        case Pair(h, t) => if (i == idx) h else impl(i + 1, t)
        case End() => throw new Exception("Bad things happened")
      }

      impl(0, this)
    }
  }
  final case class End[A] () extends LinkedList[A]
  final case class Pair[A](head: A, tail: LinkedList[A]) extends LinkedList[A]

  val example = Pair(1, Pair(2, Pair(3, End())))
  println(example(0) == 1)
  println(example(1) == 2)
  println(example(2) == 3)
  println(try {
    example(3)
    false
  } catch {
    case e: Exception => true
  })
}
