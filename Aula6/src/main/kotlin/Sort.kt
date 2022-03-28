fun main() {
   val a = readInt(base=10)
   val b = readInt(base=2, quest="Valor 2")
   val c = readInt("Valor 3", base=10)

   val txt = sortValues(a, b, c)
   println(txt)
}

fun sortValues(a: Int, b: Int, c: Int) =
	if (a <= b)
		if (b <= c) "$a $b $c"
		else
			if (c <= a) "$c $a $b"
			else "$a $c $b"
	else
		if (a <= c) "$b $a $c"
		else
			if (b <= c) "$b $c $a"
			else "$c $b $a"




