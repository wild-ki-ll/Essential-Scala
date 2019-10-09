package chapter5

object Lesson5_1_3_1 extends App {
  sealed trait LinkedList[A]
  final class End[A] () extends LinkedList[A]
  final case class Pair[A](head: A, tail: LinkedList[A]) extends LinkedList[A]
}
