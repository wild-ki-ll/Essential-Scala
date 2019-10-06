package chapter4

object Lesson4_7_0_1 extends App {
  sealed trait Expression {
    def eval: Double = 
      this match {
        case Addition(l, r) => l.eval + r.eval 
        case Substruction(l, r) => l.eval - r.eval
        case Number (v) => v
      }
  }

  final case class Addition(l: Expression, r: Expression) extends Expression
  final case class Substruction(l: Expression, r: Expression) extends Expression
  final case class Number (value: Double) extends Expression;

  val e1: Expression = Addition(Number(1.0), Number(2.0))
  val e2: Expression = Substruction(Number(5.0), Number(3.0))
  val e3: Expression = Number(5.0)

  println(e1.eval == 3.0)
  println(e2.eval == 2.0)
  println(e3.eval == 5.0)
}