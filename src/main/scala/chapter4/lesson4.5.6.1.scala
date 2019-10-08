package chapter4

object Lesson4_5_6_1_1 extends App {

  sealed trait TrafficLight {
    def next: TrafficLight;
  }
  case object Red extends TrafficLight {
    override def next: TrafficLight = Green;
  }

  case object Green extends TrafficLight {
    override def next: TrafficLight = Yellow;
  }
  case object Yellow extends TrafficLight {
    override def next: TrafficLight = Red;
  }
}

object Lesson4_5_6_1_2 extends App {

  sealed trait TrafficLight {
    def next: TrafficLight =
      this match {
        case Red => Green;
        case Green => Yellow;
        case Yellow => Red;
      }
  }
  case object Red extends TrafficLight;
  case object Green extends TrafficLight;
  case object Yellow extends TrafficLight;
}
