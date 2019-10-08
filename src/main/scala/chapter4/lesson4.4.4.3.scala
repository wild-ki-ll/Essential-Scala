package chapter4

object Lesson4_4_4_3 extends App {

  sealed trait Source
  case object Well extends Source
  case object Spring extends Source
  case object Tap extends Source

  final case class BottledWater(size: Int, source: Source, carbonated: Boolean)
}
