
fun readString(quest: String): String {
  print("${quest}? ")
  return readln()
}

fun readInt(quest: String = "Valor", base:Int = 10) = readString(quest).toInt(base)

fun readFloat(quest: String = "Valor"): Float =
  readString(quest).toFloat()


