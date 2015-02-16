class Rational(val n:Int, val dn:Int) {
    private val num = n / gcd(n, dn)
    private val denum = dn / gcd(n, dn)

    override def toString() = num.toString() + "/" + denum.toString()
    
    def +(other:Rational) = new Rational(num*other.denum + other.num*denum, other.denum*denum)
    
    def *(other:Rational) = new Rational(num*other.num, num*other.denum)
    
    private def gcd(a:Int, b:Int):Int =
        if (b == 0) a
        else gcd(b, a % b)
}

object Rational {
  def apply(n:Int, dn:Int) = new Rational(n, dn)
  def apply(n:Int) = new Rational(n, 1)  
}

class RationalEx(f:Float) extends Rational(Math.round(f * 100), 100) {
}
