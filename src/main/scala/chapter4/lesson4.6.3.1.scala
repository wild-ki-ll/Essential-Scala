package chapter4

import scala.annotation.tailrec

object Lesson4_6_3_1 extends App {
  @tailrec
  def lengthTailRec (acc: Int, lst: IntList): Int = {
    lst match {
      case End => acc;
      case Pair(_, t) => lengthTailRec(acc+1, t)
    }
  }
  @tailrec
  def propductTailRec (acc: Int, lst: IntList): Int = {
    lst match {
      case End => acc;
      case Pair(h, t) => propductTailRec(acc * h, t)
    }
  }

  sealed trait IntList {
    def length: Int = lengthTailRec(0, this)
    def product: Int = propductTailRec(1, this)
    def double: IntList =
      this match {
        case End => End;
        case Pair(h, t) => Pair(h * 2, t.double)
      }

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

  println(example.double == Pair(2, Pair(4, Pair(6, End))))
  println(example.tail.double == Pair(4, Pair(6, End)))
  println(End.double == End)

}
