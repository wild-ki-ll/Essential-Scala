package chapter4

object Lesson4_7_0_1 extends App {
    sealed trait Expression;

    final case class Addition(l: Expression, r: Expression) extends Expression
    final case class Substruction(l: Expression, r: Expression) extends Expression
    final case class Number (value: Double) extends Expression;
}