/*
object HW3 extends Homework3 {
  /*
   Примеры использования функций
   Помогут понять что требуется от каждой функции.
   */

    //создание
    val s1 = NonEmpty(1)
    val s2 = NonEmpty(2)
    
    //следующие утверждения должны быть верными
    s1.contains(1)
    s2.contains(2)
    
    //объединение
    val s12 = s1.union(s2)
    val s125 = s12.union(NonEmpty(5))
    
    //следующие утверждения должны быть верными
    s12.contains(1)
    s12.contains(2)
    !s12.contains(5)
    s125.contains(2)
    s125.contains(5)
    
    //фильтрация
    val s15 = s125.filter(_ % 2 == 1)
    
    //следующие утверждения должны быть верными
    s15.contains(1)
    s15.contains(5)
    !s15.contains(2)
    
    //вставка
    val s12_1 = s12.insert(1)
    val s123 = s12.insert(3)
    
    //следующие утверждения должны быть верными
    s12_1.contains(1)
    s12_1.contains(2)

    s123.contains(1)
    s123.contains(2)
    s123.contains(3)
    
    //удаление
    val s15_1 = s125.remove(2)
    val s3 = s123.remove(2).remove(1)
    
    //следующие утверждения должны быть верными
    s15.contains(1)
    s15.contains(5)
    !s15.contains(2)
    
    s3.contains(3)
    !s3.contains(1)
    !s3.contains(2)

    //преобразование в строку
    //следующие утверждения должны быть верными
    (new Empty).toList() == List[Int]()
    s123.toList() == List(1,2,3)
    s125.toList() == List(1,2,5)
}
*/

// =========================================
// Домашнее задание начинается тут

trait Homework3 {
    /*
        Базовый класс для представления множества. Элементами множества будут целые числа.
        Реализован в виде двоичного дерева поиска.
        Для каждого узла дерева должен сохранятся инвариант: все элементы левого поддерева меньше элемента текущего узла и все элементы правого поддерева больше элемента текущего узла (ссылка на википедию).
        Множество не может хранить дублирующиеся элементы.
    */

    abstract class Set {
        //определяет, является ли элемент членом данного множества
        def contains(s: Int): Boolean

        //вставляет элемент в множество
        //если элемент уже содержится во множестве 
        //возвращает текущее множество без изменений
        def insert(s: Int): Set

        //объеденяет два множества
        def union(other: Set): Set

        //возвращает множество, состоящее только из элементов, удовлетворяющим предикату p
        def filter(p: Int => Boolean): Set

        //возвращает множество без указанного элемента
        def remove(s: Int): Set

        //преобразует множество в список
        //элементы должны следовать в возрастающем порядке
        def toList(): List[Int]
        
        override def toString() = toList.toString
    }

    //напишите соответствующие функции для пустого множества
    class Empty extends Set {
        def contains(s: Int): Boolean = ???

        def insert(s: Int): Set = ???

        def union(other: Set): Set = ???

        def filter(p: Int => Boolean): Set = ???

        def remove(s: Int): Set = ???

        def toList(): List[Int] = ???
    }

    //напишите соответствующие функции для непустого множества
    class NonEmpty(val elem:Int, val left:Set, val right:Set) extends Set {
        def contains(s: Int): Boolean = ???
        
        def insert(s: Int): Set = ???

        def union(other: Set): Set = ???

        def filter(p: Int => Boolean):Set = ???

        def remove(s: Int): Set = ???
        
        def toList(): List[Int] = ???
    }

    object NonEmpty {
        def apply(e: Int) = new NonEmpty(e, new Empty, new Empty)
    }    
}

// Домашнее задание заканчивается тут
//==========================================

// !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
// код ниже не трогаем

object Application extends App with Homework3 {
  def inputSet(): Set = {
    val ints = scala.io.StdIn.readLine().split(" ").map(_.toInt)
    ints.foldLeft[Set](new Empty)((set, i) => { set.union(NonEmpty(i)) })
  }

  def run() = {

    scala.io.StdIn.readLine() match {
      case "union" => {
        val s1 = inputSet()
        val s2 = inputSet()
        val s3 = s1.union(s2)
        println(s3.toList)
      }
      case "filter" => {
        val s = inputSet()
        val Array(n1, n2) = scala.io.StdIn.readLine().split(" ").map(_.toInt)
        val s1 = s.filter(_ % n1 == n2)
        println(s1.toList)
      }
      case "insert" => {
        var s = inputSet()
        val incs = scala.io.StdIn.readLine().split(" ").map(_.toInt)
        val ns = incs.foldLeft[Set](s)((set, i) => {set.insert(i)})
        println(ns.toList);
      }
      case "remove" => {
        var s = inputSet()
        val incs = scala.io.StdIn.readLine().split(" ").map(_.toInt)
        val ns = incs.foldLeft[Set](s)((set, i) => {set.remove(i)})
        println(ns.toList);
      }
      case "toString" => {
        val s = inputSet()
        println(s.toString)
      }
    }
  }

  run()
}