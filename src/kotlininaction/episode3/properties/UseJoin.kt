package kotlininaction.episode3.properties
// chap 2.3.3

val UNIX_LINE_SEPARATOR = "\n"
const val UNIX_ROW_SEPARATOR = "\r" // public static final UNIX_ROW_SEPARATOR = "\r"

var opCount = 0
fun performOperation(){
    opCount++
}

fun main(){
    performOperation();
    println("Operation performed $opCount times")
}

