package chapter4

object Lesson4_2_2_2 extends App {

  sealed trait Color {
    def r: Double;
    def g: Double;
    def b: Double;

    def isLight = (r + g + b) / 3.0 > 0.5
    def isDark = !isLight
  }

  final case object Red extends Color {
    val r: Double = 1.0;
    val g: Double = 0.0;
    val b: Double = 0.0;
  }

  final case object Yellow extends Color {
    val r: Double = 1.0;
    val g: Double = 1.0;
    val b: Double = 0.0;
  }

  final case object Pink extends Color {
    val r: Double = 1.0;
    val g: Double = 1.0;
    val b: Double = 1.0;
  }

  final case class CustomColor (val r: Double, val g: Double, val b: Double) extends Color;

  sealed trait Shape {
    def sides: Int
    def perimeter: Double
    def area: Double
    def color: Color
  }

  final case class Circle (val r: Double, val color: Color) extends Shape {
    val sides = 1;
    val perimeter =  2 * math.Pi * r;
    val area = math.Pi * r * r;
  }

  sealed trait Rectangular extends Shape {
    def width: Double
    def height: Double
    def color: Color
    val sides = 4
    def perimeter = 2 * (width + height);
    def area = width * height;
  }

  final case class Square(val size: Double, val color: Color) extends Rectangular {
    val width = size;
    val height = size;
  }

  final case class Rectangle(val width: Double, val height: Double, val color: Color) extends Rectangular

  object Draw {
    def apply(shape: Shape): String = {
      shape match {
        case Circle(r, c) => s"A ${Draw(c)} circle of radius ${r}cm";
        case Rectangle(width, height, c) => s"A ${Draw(c)} rectangle of width ${width}cm and height ${height}cm";
        case Square(size, c) => s"A ${Draw(c)} square of size ${size}cm";
      }
    }

    def apply(color: Color): String = color match {
      case Red => "red"
      case Yellow => "yellow"
      case Pink => "pink"
      case color => if(color.isLight) "light" else "dark"
    }
  }

  println(Draw(Circle(3, Yellow))== "A yellow circle of radius 3.0cm")
  println(Draw(Rectangle(2, 3, Red)) == "A red rectangle of width 2.0cm and height 3.0cm")
  println(Draw(Square(2, Pink)) == "A pink square of size 2.0cm")
  println(Draw(Circle(3, CustomColor(0.4, 0.4, 0.6)))== "A dark circle of radius 3.0cm")
}
