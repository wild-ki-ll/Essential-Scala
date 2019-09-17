case class Director(firstName: String, lastName: String, year: Int);

object Director {
  def older(dir1: Director, dir2: Director): Director =
    if (dir1.year < dir2.year) dir1 else dir2
}

case class Film(name: String, year: Int, rating: Double, director: Director) {
  def directorsAge = this.year - director.year
  def isDirectedBy(dir: Director) = director == dir
}

object Film {
  def newer(film1: Film, film2: Film): Film =
    if (film1.year < film2.year) film1 else film2
  def highestRating(film1: Film, film2: Film): Double =
    if (film1.rating > film2.rating) film1.rating else film2.rating
  def oldestDirectorAtTheTime(film1: Film, film2: Film): Director =
    if(film1.directorsAge > film2.directorsAge) film1.director else film2.director
}

object Lesson extends App {
  val d1 = Director("A", "A", 1950);
  val d2 = Director("B", "B", 1970);
  val f1 = Film("F1", 2018, 100.0, d1);
  val f2 = Film("F2", 2015, 340.0, d2);
  println(f1.isDirectedBy(d1) == true);
  println(f1.isDirectedBy(d2) == false);
  println(Film.newer(f1, f2) == f2);
  println(Film.highestRating(f1, f2) == 340.0);
  println(Film.oldestDirectorAtTheTime(f1, f2) == d1);
}
