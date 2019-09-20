package chapter4

object Lesson4_2_2_3 extends App {

  sealed trait DivisionResult;
  final case class Finite (res: Int) extends DivisionResult;
  case object Infinite extends DivisionResult;

  object divide {
    def apply(a: Int, b: Int): DivisionResult = {
      b match {
        case 0 => Infinite;
        case _ => Finite(a/b);
      }
    }
  }

  println(divide(15, 5) == Finite(3))
  println(divide(1, 0) == Infinite)
}
