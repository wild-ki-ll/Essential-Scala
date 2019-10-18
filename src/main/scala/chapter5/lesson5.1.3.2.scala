package chapter5

import scala.annotation.tailrec

object Lesson5_1_3_2 extends App {
  sealed trait LinkedList[A] {
    def length: Int = {
     @tailrec
     def impl(l: LinkedList[A], len: Int): Int= l match {
       case Pair(h, t) => impl(t, len+1);
       case End() => len
      }
      impl(this, 0)
    }
  }
  final case class End[A] () extends LinkedList[A]
  final case class Pair[A](head: A, tail: LinkedList[A]) extends LinkedList[A]

  val example = Pair(1, Pair(2, Pair(3, End())))
  println(example.length == 3)
  println(example.tail.length == 2)
  println(End().length == 0)

}
