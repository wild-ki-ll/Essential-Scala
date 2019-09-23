package chapter4

object Lesson4_5_6_3 extends App {
  sealed trait Calculation;
  final case class Success(result: Int) extends Calculation
  final case class Failure(reason: String) extends Calculation

  case object Calculator extends  Calculation {
    def + (calc: Calculation, oper: Int): Calculation = {
      calc match {
        case Success(i) => Success(i + oper);
        case Failure(r) => Failure(r)
      }
    }
    def - (calc: Calculation, oper: Int): Calculation = {
      calc match {
        case Success(i) => Success(i - oper);
        case Failure(r) => Failure(r)
      }
    }

    def / (calc: Calculation, oper: Int): Calculation = {
      calc match {
        case Success(i) => {
          oper match {
            case 0 => Failure("Division by zero")
            case _ => Success(i / oper)
          }
        }
        case Failure(r) => Failure(r)
      }
    }
  }

  println(Calculator.+(Success(1), 1) == Success(2))
  println(Calculator./(Success(4), 0) == Failure("Division by zero"))
  println(Calculator./(Failure("Badness"), 0) == Failure("Badness"))

  println(Calculator.+(Success(1), 1) == Success(2))
  println(Calculator.-(Success(1), 1) == Success(0))
  println(Calculator.+(Failure("Badness"), 1) == Failure("Badness"))
}
