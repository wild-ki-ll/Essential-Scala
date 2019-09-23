package chapter4

import scala.annotation.tailrec

object Lesson4_6_3_1 extends App {
  @tailrec
  def lengthTailRec (acc: Int, lst: IntList): Int = {
    lst match {
      case End => acc;
      case Pair(h, t) => lengthTailRec(acc+1, t)
    }
  }

  sealed trait IntList {
    def length: Int = lengthTailRec(0, this)
  }
  case object End extends IntList
  final case class Pair(head: Int, tail: IntList) extends IntList

  val example = Pair(1, Pair(2, Pair(3, End)))
  println(example.length == 3)
  println(example.tail.length == 2)
  println(End.length == 0)
}
