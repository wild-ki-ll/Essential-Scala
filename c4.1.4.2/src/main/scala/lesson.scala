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
case class Rectangle (w: Int, h:Int) extends Shape {
  val sides = 4;
  val perimeter = 2 * (w + h);
  val area = w * h;
}
case class Square (s: Double) extends Shape {
  val sides = 4;
  val perimeter = 4 * s;
  val area = s * s;
}

object Lesson extends App {
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
