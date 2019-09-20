package chapter4

object Lesson4_4_4_2 extends App {

  sealed trait Calulator;
  final case class Succeed(r: Int) extends Calulator;
  final case class Fail(f: String) extends Calulator;

  sealed trait Oper;
  final case object + extends Oper;
  final case object - extends Oper;
  final case object / extends Oper;
  final case object * extends Oper;

  def calc (a: Int, o: Oper, b: Int): Calulator =
    o match {
      case + => Succeed(a + b);
      case - => Succeed(a - b);
      case / => if (b == 0) Fail("Division by zero") else Succeed(a/b);
      case * => Succeed(a * b)
    }

  println(calc(1, +, 0) == Succeed(1))
  println(calc(1, -, 0) == Succeed(1))
  println(calc(1, /, 1) == Succeed(1))
  println(calc(1, *, 1) == Succeed(1))
  println(calc(1, /, 0) == Fail("Division by zero"))
}
