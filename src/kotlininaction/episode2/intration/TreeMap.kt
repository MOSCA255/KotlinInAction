package kotlininaction.episode2.intration

import java.util.TreeMap

val binaryReps = TreeMap<Char, String>()
val strList = arrayListOf("10", "11", "1001")

fun initTreeMap(){
    for ( c in 'A'..'F'){
        val binary = Integer.toBinaryString(c.toInt());
        binaryReps[c] = binary // 자바코드로는 binaryReps.put(c, binary) 와 같다.
    }
}

fun iterationMap(){
    for((letter, binary) in binaryReps){
        println("$letter = $binary")
    }
}

fun iterationList(){
    for((index, element) in strList.withIndex()){ // withIndex 로 인덱스와 함께 컬렉션을 이터레이션 한다.
        println("$index: $element")
    }
}

fun main (){
    initTreeMap()
    iterationMap()
    iterationList()
}