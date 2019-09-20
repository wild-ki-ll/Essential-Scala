package chapter4

object Lesson4_4_4_3 extends App {

  sealed trait Source
  final case object Well extends Source
  final case object Spring extends Source
  final case object Tap extends Source

  final case class BottledWater(size: Int, source: Source, carbonated: Boolean)
}
