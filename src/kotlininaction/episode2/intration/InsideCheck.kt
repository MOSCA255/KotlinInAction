package kotlininaction.episode2.intration

fun isLetter (c : Char) : Boolean = c in 'a'..'z' || c in 'A'..'Z'
fun isNotDigit ( c: Char ) : Boolean = c !in '0'..'9'

fun recognize ( c : Char ) : String = when (c){
    in '0'..'9' -> "It's a digit!"
    in 'a'..'z' , in 'a'..'Z' -> "It's a letter"
    else -> "I don't know..."
}

fun main (args : Array<String> ){
    println(isLetter('q'))
    println(isNotDigit('x'))

    println("Kotlin" in "JAVA".."Scala") // true
    println("Kotlin" in setOf("JAVA", "Scala")) // false

}