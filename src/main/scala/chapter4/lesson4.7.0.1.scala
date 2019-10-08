package chapter4

object Lesson4_7_0_1 extends App {
  sealed trait Expression {

    def eval: Calculation = {
      def evalImpl(l: Expression, r: Expression): Calculation = 
        l.eval match {
          case Success(res1) => 
            r.eval match {
              case Success(res2) =>
                this match {
                 case Addition(_, _) => Success(res1 + res2) 
                 case Substruction(_, _) => Success(res1 - res2) 
                 case Division(_, _) => if (res2 == 0.0) 
                    Failure("Division by zero")
                  else 
                    Success(res1 / res2) 
                }
              case Failure(reason) => Failure(reason)
            }
            case Failure(reason) => Failure(reason)
          }
      
      this match {
        case Addition(l, r) => evalImpl(l, r); 
        case Substruction(l, r) => evalImpl(l, r);
        case Division(l, r) => evalImpl(l, r)
        case SquareRoot(v) => v.eval match {
            case Success(res) =>
              if (res < 0) 
                Failure("Square root of negative number")
              else 
                Success(Math.sqrt(res))
           case Failure(reason) => Failure(reason)
          }    
        case Number (v) => Success(v)
      }
    }
  }

  final case class Addition(l: Expression, r: Expression) extends Expression
  final case class Substruction(l: Expression, r: Expression) extends Expression
  final case class Division(l: Expression, r: Expression) extends Expression
  final case class SquareRoot(v: Expression) extends Expression
  final case class Number (value: Double) extends Expression;
   
  sealed trait Calculation
  final case class Success(r: Double) extends Calculation
  final case class Failure(r: String) extends Calculation
    
  val e1: Expression = Addition(Number(1.0), Number(2.0))
  val e2: Expression = Substruction(Number(5.0), Number(3.0))
  val e3: Expression = Number(5.0)

  println(e1.eval == Success(3.0))
  println(e2.eval == Success(2.0))
  println(e3.eval == Success(5.0))

  println(Addition(SquareRoot(Number(-1.0)), Number(2.0)).eval == Failure("Square root of negative number"))
  println(Addition(SquareRoot(Number(4.0)), Number(2.0)).eval == Success (4.0))
  println(Division(Number(4), Number(0)).eval == Failure("Division by zero"))

}