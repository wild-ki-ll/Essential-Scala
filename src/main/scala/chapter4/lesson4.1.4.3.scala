package chapter4

object Lesson4_1_4_3 extends App {

  trait Shape {
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

  println(Circle(3).sides == 1)
  println(Circle(3).area == 28.274333882308138)
  println(Circle(3).perimeter == 18.84955592153876)

  println(Rectangle(2, 3).sides == 4)
  println(Rectangle(2, 3).area == 6.0)
  println(Rectangle(2, 3).perimeter == 10.0)

  println(Square(2).sides == 4)
  println(Square(2).area == 4.0)
  println(Square(2).perimeter == 8.0)
}
