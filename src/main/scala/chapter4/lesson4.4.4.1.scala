package chapter4

object Lesson4_4_4_1 extends App {

  sealed trait TrafficLight;
  case object  Red extends TrafficLight;
  case object  Green extends TrafficLight;
  case object  Yellow extends TrafficLight;
}
