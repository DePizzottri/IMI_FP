/*
 * Шаблон для Worksheet

object WS extends Homework13 {
  //здесь можно запускать написанные функции из Worksheet
  sum(List(1, 6, 3)) == 6
}

*/

// =========================================
// Домашнее задание начинается тут

trait Homework13 {
  //напишите рекурсивную функцию, вычисляющую сумму списка
  def max(l: List[Int]): Int = {
    ???
  }
}

// Домашнее задание заканчивается тут
//==========================================

// !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
// код ниже не трогаем

object Application extends App with Homework13 {

  def next(x: Int) = {
    (16807 * x + 13666) % 2147483647
  }

  def run() = {
    var Array(x, n) = scala.io.StdIn.readLine().split(" ").map(_.toInt)

    val l = (1 to n).foldLeft(List[Int](x))((l, e) => { (next(l.head) % 10000) :: l });
    
    println(max(l))
  }

  run()
}
