object Lesson3_5_3_2 extends App {

  case class Director(firstName: String, lastName: String, year: Int);
  case class Film(name: String, year: Int, rating: Double, director: Director);

  object Dad  {
    def rate(film: Film): Double =
      film match {
        case Film(_, _, _, Director("Clint", "Eastwood", _)) => 10.0
        case Film(_, _, _, Director("John", "McTiernan", _)) => 7.0
        case _ => 3.0
      }
  }

  println(Dad.rate(Film("A", 2018, 10.0, Director("Clint", "Eastwood", 1955))) == 10.0)
  println(Dad.rate(Film("A", 2018, 10.0, Director("John", "McTiernan", 1930))) == 7.0)
  println(Dad.rate(Film("A", 2018, 10.0, Director("Nikita", "Mikhalkov", 1940))) == 3.0)
}
