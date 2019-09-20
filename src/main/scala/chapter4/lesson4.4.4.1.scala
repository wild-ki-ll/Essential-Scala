package chapter4

object Lesson4_4_4_1 extends App {

  sealed trait TrafficLight;
  final case object  Red extends TrafficLight;
  final case object  Green extends TrafficLight;
  final case object  Yellow extends TrafficLight;
}
