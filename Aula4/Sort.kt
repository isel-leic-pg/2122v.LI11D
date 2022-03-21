fun main() {
   print("Valor 1? ")
   val a = readln().toInt()
   print("Valor 2? ")
   val b = readln().toInt()
   print("Valor 3? ")
   val c = readln().toInt()

   val x:Int
   val y:Int
   val z:Int   
   if (a<=b && a<=c) {
      x = a
	  if (b<=c) { y=b; z=c }
	  else { y=c ; z=b }
   } else
      if (b<=a && b<=c) {
	     x = b
		 if (a<=c) { y=a; z=c }
		 else { y=c; z=a }
	  }
	  else {
	     x = c
		 if (a<=b) { y=a; z=b }
		 else { y=b ; z=a }
	  }
   println("$x $y $z")
   
   /*
   when {
     a <= b && b <= c -> println("$a $b $c")
     a <= c && c <= b -> println("$a $c $b")
     b <= a && a <= c -> println("$b $a $c")
     b <= c && c <= a -> println("$b $c $a")
     c <= a && a <= b -> println("$c $a $b")
     c <= b && b <= a -> println("$c $b $a")
   }
   */
}