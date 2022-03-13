package kotlininaction.episode3.collection

// chap 3.1

fun main( args : Array<String>){
    makeCollection()
    lastMaximumOne()
}

fun makeCollection(){
    val set = hashSetOf(1, 7, 53)
    val list = arrayListOf(1, 7, 53)
    val map = hashMapOf(1 to "one", 7 to "seven", 53 to "fifty-three")

    println(set.javaClass) //class java.util.HashSet
    println(list.javaClass) //class java.util.ArrayList
    println(map.javaClass) //class java.util.HashMap
}

fun lastMaximumOne(){
    val strings = listOf("first", "secode", "fourteenth")
    println(strings.last()) // fourteenth
    val numbers = setOf(1, 14, 2)
    println(numbers.max()) // 14
}