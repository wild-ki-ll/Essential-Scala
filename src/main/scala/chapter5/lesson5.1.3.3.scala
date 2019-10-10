package chapter5

import scala.annotation.tailrec

object Lesson5_1_3_3 extends App {
  sealed trait LinkedList[A] {
    @tailrec
    def contains (i: A): Boolean =
      this match {
        case Pair(h, t) => if (h == i) true else t.contains(i)
        case End() => false
      }
  }
  final case class End[A] () extends LinkedList[A]
  final case class Pair[A](head: A, tail: LinkedList[A]) extends LinkedList[A]

  val example = Pair(1, Pair(2, Pair(3, End())))
  println(example.contains(3) == true)
  println(example.contains(4) == false)
  println(End().contains(0) == false)
}
