package chapter4

object Lesson4_7_0_2 extends App {
  sealed trait JSON {
    def print: String = {
      def seqPrint (s: jSeqCell): String = s match {
        case jSeqCell(h, `jSeqEnd`) => h.print;
        case jSeqCell(h, t @ jSeqCell(_, _)) => h.print ++ ", " ++ seqPrint(t)
      }

      def objPrint (o: jObjectCell): String = o match {
        case jObjectCell(k, v, `jObjectEnd`) => k ++ ": " ++ v.print
        case jObjectCell(k, v, t @ jObjectCell(_, _, _)) => k ++ ": " ++ v.print ++ ", " ++ objPrint(t)
      }

      this match {
        case jNumber(v) => v.toString; 
        case jString(v) => '"'.toString ++ v + '"'.toString;
        case jBoolean(v) => v.toString;
        case `jNull` => "Null";
        
        case s @ jSeqCell(_, _) => "[" ++ seqPrint(s) ++ "]";
        case `jSeqEnd` => "[]";
        
        case o @ jObjectCell(_, _, _) => "{" ++ objPrint(o) ++ "}";
        case `jObjectEnd` => "{}";
      }
    }
  }
  final case class jNumber (v: Double) extends JSON;
  final case class jString (v: String) extends JSON;
  final case class jBoolean (v: Boolean) extends JSON;
  case object jNull extends JSON;

  sealed trait jSequence extends JSON;
  final case class jSeqCell (head: JSON, tail: jSequence) extends jSequence;
  case object jSeqEnd extends jSequence;

  sealed trait jObject extends JSON;
  final case class jObjectCell (k: String, v: JSON, tail: jObject) extends jObject;
  case object jObjectEnd extends jObject;

  println(jNumber(1.0).print == "1.0");
  println(jString("string").print == "\"string\"");
  println(jBoolean(false).print == "false");
  println(jNull.print == "Null");
  println(jSeqEnd.print == "[]");
  println(jObjectEnd.print == "{}");

  println(jSeqCell(jString("a string"), jSeqCell(jNumber(1.0), jSeqCell(jBoolean(true), jSeqEnd)))
    .print == "[\"a string\", 1.0, true]")

  println(jObjectCell("a", 
   jSeqCell(jNumber(1.0), jSeqCell(jNumber(2.0), jSeqCell(jNumber(3.0), jSeqEnd))), 
   jObjectCell("b", 
   jSeqCell(jString("a"), jSeqCell(jString("b"), jSeqCell(jString("c"), jSeqEnd))), 
   jObjectCell("c", 
   jObjectCell("doh", jBoolean(true), jObjectCell("ray", jBoolean(false), jObjectCell("me", jNumber(1.0), jObjectEnd))), 
   jObjectEnd)))
   .print == "{a: [1.0, 2.0, 3.0], b: [\"a\", \"b\", \"c\"], c: {doh: true, ray: false, me: 1.0}}")
}