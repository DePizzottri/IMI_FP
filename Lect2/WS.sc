object WS  {
  val r1 = Rational(1, 2)
  val r2 = Rational(3, 6)
  r1.+(r2)
  r1 + r2
  
  r1.+(r2.*(Rational(4,5)))
  r1 + r2 * Rational(4,5)
  
  Rational(3, 2)
  
  Rational(4,5) + Rational(10, 6) * Rational(5,1)
  
  new RationalEx(3.14f)
}