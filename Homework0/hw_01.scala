/*
 * Шаблон для Worksheet

object WS extends Homework0 {
  //здесь можно запускать написанные функции из Worksheet
  sum(1, 3) == 4
  sum(3, 4) == 7
}

*/

// =========================================
// Домашнее задание начинается тут

trait Homework0 {
  //напишите функцию, складывающую 2 числа
  def sum(a: Int, b: Int) = {
    ???
  }
}  

// Домашнее задание заканчивается тут
//==========================================

// !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
// код ниже не трогаем

object Application extends App with Homework0 {
  //input
  def run() = {
    var Array(a, b) = scala.io.StdIn.readLine().split(" ").map(_.toInt)
    //solve and output
    println(sum(a, b))
  }

  run()
}
