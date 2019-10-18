package chapter5

import scala.annotation.tailrec

object Lesson5_2_3_1 extends App {

  sealed trait IntList{
    def fold(result: Int, f: (Int, Int) => Int): Int = 
      this match {
        case End => result;
        case Pair(head, tail) => f(head, tail.fold(result, f)) 
      }
    def sum (): Int = this.fold(0, (head, tail) => head + tail)
    def length(): Int = this.fold(0, (_, tail) => 1 + tail)
    def product (): Int = this.fold(1, (head, tail) => head * tail)
  }
  
  case object End extends IntList
  final case class Pair(head: Int, tail: IntList) extends IntList

  val example = Pair(1, Pair(2, Pair(3, End)))
  println(example.length == 3)
  println(example.tail.length == 2)
  println(End.length == 0)

  println(example.product == 6)
  println(example.tail.product == 6)
  println(End.product == 1)

  println(example.sum == 6)
  println(example.tail.sum == 5)
  println(End.sum == 0)
}
