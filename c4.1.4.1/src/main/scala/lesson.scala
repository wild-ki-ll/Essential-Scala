trait Feline {
  def color: String;
  def sound: String;
}

case class Cats (val color: String, val food: String) extends Feline {
   override val sound = "meow";
}

trait BigCat extends Feline {
   override val sound = "roar";
}

case class Tigers(val color: String) extends BigCat;
case class Panthers(val color: String) extends BigCat;
case class Lions(val color: String, val maneSize: Int) extends BigCat;

object Lesson extends App {
  println(Cats("grey", "milk").sound == "meow")
  println(Tigers("striped").sound == "roar")
  println(Lions("yellow", 15).sound == "roar")
  println(Panthers("pink").sound == "roar")
}
