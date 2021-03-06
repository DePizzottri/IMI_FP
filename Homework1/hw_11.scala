/*
 * Шаблон для Worksheet

object WS extends Homework11 {
  //здесь можно запускать написанные функции из Worksheet
  sum(List(1, 2, 3)) == 6
}

*/

// =========================================
// Домашнее задание начинается тут

trait Homework11 {
  //напишите рекурсивную функцию, вычисляющую сумму списка
  //Методы List, которые могут пригодиться
  //    isEmpty:Boolean - определяет, пуст ли список
  //    head:Int - возвращает первый элемент списка
  //    tail:List - возвращает список, без первого элемента
  def sum(l: List[Int]): Int = {
    ???
  }
}

// Домашнее задание заканчивается тут
//==========================================

// !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
// код ниже не трогаем

object Application extends App with Homework11 {

  def next(x: Int) = {
    (16807 * x + 13666) % 2147483647
  }

  def run() = {
    var Array(x, n) = scala.io.StdIn.readLine().split(" ").map(_.toInt)

    val l = (1 to n).foldLeft(List[Int](x))((l, e) => { (next(l.head) % 10000) :: l });
    
    println(sum(l))
  }

  run()
}
