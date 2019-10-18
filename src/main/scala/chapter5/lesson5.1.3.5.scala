package chapter5

import scala.annotation.tailrec

object Lesson5_1_3_5 extends App {
  sealed trait LinkedList[A] {
    def apply (idx: Int): Result[A] = {
      @tailrec
      def impl (i: Int, lst: LinkedList[A]): Result[A]= lst match {
        case Pair(h, t) => if (i == idx) Success(h) else impl(i + 1, t)
        case End() => Failure("Index out of bounds")
      }

      impl(0, this)
    }
  }
  final case class End[A] () extends LinkedList[A]
  final case class Pair[A](head: A, tail: LinkedList[A]) extends LinkedList[A]

  sealed trait Result[A]
  final case class Success[A](result: A) extends Result[A]
  final case class Failure[A](reason: String) extends Result[A]

  val example = Pair(1, Pair(2, Pair(3, End())))
  println(example(0) == Success(1))
  println(example(1) == Success(2))
  println(example(2) == Success(3))
  println(example(3) == Failure("Index out of bounds"))
}
