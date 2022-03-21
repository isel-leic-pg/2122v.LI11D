fun main() {
   print("Símbolo? ")
   val sym = readln().first()
   val upperLetter = sym in 'A'..'Z' || sym in "ÇÃÕÁÉÍÓÚÀÂÊ"
   val lowerLetter = sym in 'a'..'z' || sym in "çãõáéíóúàâê"
   val digit = sym in '0'..'9'
   val cls = when {
     digit -> "digíto"
	 upperLetter || lowerLetter -> "letra"
	 else -> ""
   }
   if ( cls.isNotEmpty() ) {
	 var msg = "O símbolo $sym é $cls"
	 when {
       upperLetter -> msg = msg + ", é maiúscula, minúscula = ${sym+('a'-'A')}"
	   lowerLetter -> msg = msg + ", é minúscula, maiúscula = ${sym-('a'-'A')}"
     }
     println(msg)   	 
   }
}