/*
 * ������ ��� Worksheet

object WS extends Homework0 {
  //����� ����� ��������� ���������� ������� �� Worksheet
  sum(1, 3) == 4
  sum(3, 4) == 7
}

*/

// =========================================
// �������� ������� ���������� ���

trait Homework0 {
  //�������� �������, ������������ 2 �����
  def sum(a: Int, b: Int) = {
    ???
  }
}  

// �������� ������� ������������� ���
//==========================================

// !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
// ��� ���� �� �������

object Application extends App with Homework0 {
  //input
  def run() = {
    var Array(a, b) = scala.io.StdIn.readLine().split(" ").map(_.toInt)
    //solve and output
    println(sum(a, b))
  }

  run()
}
