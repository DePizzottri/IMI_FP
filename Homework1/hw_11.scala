/*
 * ������ ��� Worksheet

object WS extends Homework11 {
  //����� ����� ��������� ���������� ������� �� Worksheet
  sum(List(1, 2, 3)) == 6
}

*/

// =========================================
// �������� ������� ���������� ���

trait Homework11 {
  //�������� ����������� �������, ����������� ����� ������
  def sum(l: List[Int]): Int = {
    ???
  }
}

// �������� ������� ������������� ���
//==========================================

// !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
// ��� ���� �� �������

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
