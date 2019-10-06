package chapter4

object Lesson4_6_3_2 extends App {
    sealed trait Tree;

    final case class Leaf (el: Int) extends Tree;
    final case class Node (l: Tree, r: Tree) extends Tree;

    object TreeOps {
      def sum(t: Tree): Int = {
        def sumImpl (s: Int, t0: Tree): Int =
          t0 match {
            case Leaf (el) => s + el;
            case Node(l, r) => sumImpl(s, l) + sumImpl(s, r); 
          }

        sumImpl(0, t)
      }

      def double(t: Tree): Tree = 
        t match {
          case Leaf(el) => Leaf(el * 2)
          case Node(l, r) => Node(double(l), double(r))
        }
    }

    val t: Tree = Node(Node(Leaf(1), Leaf(2)), Leaf(3))
    val t1: Tree = Leaf(5)

    println(TreeOps.sum(t) == 6)
    println(TreeOps.sum(t1) == 5)
    println(TreeOps.double(t) == Node(Node(Leaf(2), Leaf(4)), Leaf(6)))
    println(TreeOps.double(t1) == Leaf(10))

}