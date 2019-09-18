package chapter4

object Lesson4_2_2_1 extends App {

  sealed trait Shape {
    def sides: Int
    def perimeter: Double
    def area: Double
  }

  case class Circle (r: Double) extends Shape {
    val sides = 1;
    val perimeter =  2 * math.Pi * r;
    val area = math.Pi * r * r;
  }

  sealed trait Rectangular extends Shape {
    def width: Double
    def height: Double
    val sides = 4
    def perimeter = 2 * (width + height);
    def area = width * height;
  }

  case class Square(val size: Double) extends Rectangular {
    val width = size;
    val height = size;
  }

  case class Rectangle(val width: Double, val height: Double) extends Rectangular

  object Draw {
    def apply(shape: Shape): String = {
      shape match {
        case Circle(r) => s"A circle of radius $r cm";
        case Rectangle(width, height) => s"A rectangle of width $width cm and height $height cm";
        case Square(size) => s"A square of size $size cm";
      }
    }
  }

  println(Draw(Circle(3)) == "A circle of radius 3.0 cm")
  println(Draw(Rectangle(2, 3)) == "A rectangle of width 2.0 cm and height 3.0 cm")
  println(Draw(Square(2)) == "A square of size 2.0 cm")
}
