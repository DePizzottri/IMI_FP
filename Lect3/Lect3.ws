object Test {

  trait Printable {
    def print: Unit
  }

  abstract class MyListBase {
    def isEmpty: Boolean
    def head: Int
    def tail: MyListBase
  }

  object EmptyList extends MyListBase {
    def isEmpty = true
    def head = throw new Exception
    def tail = throw new Exception
    override def toString = "Nil"
    def toSequance: Seq[Int] = ???
  }

  class Cons(e: Int, t: MyListBase) extends MyListBase with Printable {
    def isEmpty = false
    def head = e
    def tail = t
    override def toString = {
      e.toString() + ", " + tail.toString()
    }

    def print = println(this)
  }

  val e = EmptyList
  val l1 = new Cons(1, EmptyList)
  val l2 = new Cons(1, new Cons(2, EmptyList))
  val l3 = new Cons(1, new Cons(2, new Cons(3, EmptyList)))

  val p:Printable = l3
  p.print
}