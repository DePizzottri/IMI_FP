/*
object WS extends Homework2{
  /*
   Примеры использования функций

   Помогут понять что требуется от каждой функции.
   */

  val s1 = singletonSet(1)
  val s2 = singletonSet(2)
  val s4 = singletonSet(4)

  //следующие утверждения должны быть верными
  contains(s1, 1)
  contains(s2, 2)
  !contains(s4, 2)
  !contains(s2, 3)

  val s12 = union(s1, s2)
  val s124 = union(s12, s4)

  //следующие утверждения должны быть верными
  contains(s124, 1)
  contains(s124, 2)
  contains(s124, 4)
  !contains(s12, 4)

  val ss2 = intersect(s12, s2)
  val ss12 = intersect(s124, s12)

  //следующие утверждения должны быть верными
  contains(ss2, 2)
  !contains(ss2, 1)
  contains(ss12, 1)
  contains(ss12, 2)
  !contains(ss12, 4)

  val ss1 = diff(s12, s2)
  val ss4 = diff(s124, s12)

  //следующие утверждения должны быть верными
  contains(ss1, 1)
  !contains(ss1, 2)
  contains(ss4, 4)
  !contains(ss4, 1)
  !contains(ss4, 2)

  val isEven = (x:Int) => x % 2 == 0
  val isOdd = (x:Int) => x % 2 == 1

  val s_even = filter(s124, isEven)
  val s_odd = filter(s124, isOdd)

  //следующие утверждения должны быть верными
  contains(s_even, 2)
  contains(s_even, 4)
  !contains(s_even, 1)

  contains(s_odd, 1)
  !contains(s_odd, 2)
  !contains(s_odd, 4)

  forall(s_even, isEven)
  !exists(s_even, isOdd)

  forall(s_odd, isOdd)
  !exists(s_odd, isEven)

  val s3 = map(s1, _ + 2)
  val s235 = map(s124, _ + 1)

  //следующие утверждения должны быть верными
  contains(s3, 3)
  !contains(s3, 1)

  contains(s235, 5)
  contains(intersect(s235, s124), 2)

  !contains(intersect(s235, s124), 4)

  toString(s235) == "{2,3,5}"

*/

// =========================================
// Домашнее задание начинается тут

trait Homework2 {
  /**
   * Представим множество в виде характеристической функции
   */
  type Set = Int => Boolean

  /**
   * Проеверяет, явлется ли число элементом множества
   */
  def contains(s: Set, elem: Int): Boolean = ???

  /**
   * Возвращает множество из одного элемента
   */
  def singletonSet(elem: Int): Set = ???

  /**
   * Возвращает объеденение 2х множеств - множество всех элементов из s или из t
   */
  def union(s: Set, t: Set): Set = ???

  /**
   * Возвращает пересечение 2х множеств - множесто элементов которые одновременно принадлежат s и t
   */
  def intersect(s: Set, t: Set): Set = ???

  /**
   * Возвращает разность 2х множеств - множество элементов которые содерхатся в s, но не содержатся в t
   */
  def diff(s: Set, t: Set): Set = ???

  /**
   * Возвращает подмножество s, для которого выполняется предикат p
   */
  def filter(s: Set, p: Int => Boolean): Set = ???

  /**
   * Далее исползуйте переменную bound как указание минимальной (+bound) и минимальной (-bound) границы элементов
   * которые могут содержаться во множестве
   */
  val bound = 1000

  /**
   * Предикат, определяющий, что все элементы s удовлетворяют предикату p
   */
  def forall(s: Set, p: Int => Boolean): Boolean = ???

  /**
   * Предикат, определяющий, что во множестве s содержится хотябы 1 элемент, удовлетворяющий предикату p
   */
  def exists(s: Set, p: Int => Boolean): Boolean = ???

  /**
   * Возвращает множество элементов s, к каждому из которых применина функция f
   */
  def map(s: Set, f: Int => Int): Set = ???

  /**
   * Отображает множество в виде строки. В начале и в конце должны стоять фигурные скобки, а каждый элемент должен быть разделен запятыми. Элементы должны следовать в порядке возрастания.
   */
  def toString(s: Set): String = ???
}

// Домашнее задание заканчивается тут
//==========================================

// !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
// код ниже не трогаем

object Application extends App with Homework2 {
  def inputSet(): Set = {
    val ints = scala.io.StdIn.readLine().split(" ").map(_.toInt)
    val s: Set = (x) => false
    ints.foldLeft(s)((set, i) => { union(set, singletonSet(i)) })
  }

  def prn(s: Set) = {
    val xs = for (i <- -bound to bound if contains(s, i)) yield i
    xs.mkString(" ")

  }

  def run() = {

    scala.io.StdIn.readLine() match {
      case "union" => {
        val s1 = inputSet()
        val s2 = inputSet()
        val s3 = union(s1, s2)
        println(prn(s3))
      }
      case "intersect" => {
        val s1 = inputSet()
        val s2 = inputSet()
        val s3 = intersect(s1, s2)
        println(prn(s3))
      }
      case "diff" => {
        val s1 = inputSet()
        val s2 = inputSet()
        val s3 = diff(s1, s2)
        println(prn(s3))
      }
      case "filter" => {
        val s = inputSet()
        val Array(n1, n2) = scala.io.StdIn.readLine().split(" ").map(_.toInt)
        val s1 = filter(s, _ % n1 == n2)
        println(prn(s1))
      }
      case "forall" => {
        val s = inputSet()
        val Array(n1, n2) = scala.io.StdIn.readLine().split(" ").map(_.toInt)
        println(forall(s, _ % n1 == n2))
      }
      case "exists" => {
        val s = inputSet()
        val Array(n1, n2) = scala.io.StdIn.readLine().split(" ").map(_.toInt)
        println(exists(s, _ % n1 == n2))
      }
      case "map" => {
        val s = inputSet()
        val Array(n1) = scala.io.StdIn.readLine().split(" ").map(_.toInt)
        val s1 = map(s, _ + n1)
        println(prn(s1))
      }
      case "toString" => {
        val s = inputSet()
        println(toString(s))
      }
    }
  }

  run()
}
