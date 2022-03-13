package kotlininaction.episode3.collection

fun main(){
    val list = listOf(1, 2, 3);
    println(list) // [ 1, 2, 3 ]

    println(joinToString(list, ";", "(", ")")) // (1;2;3)
    println(joinToString(list, separator = " ", prefix = " ", postfix = "."))

    println(list.joinToString_2( separator = "; ", prefix = "(", postfix = ")")) // (1; 2; 3)

    println(listOf("one", "two", "eight").join("|"));
}

fun <T> joinToString(
    collection: Collection<T>,
    separator: String = ", ",
    prefix : String = "",
    postfix : String = ""
) : String{
    val result = StringBuilder(prefix)

    for ((index, element) in collection.withIndex()){
        if( index > 0) result.append(separator)
        result.append(element)
    }
    result.append(postfix)
    return result.toString()
}


fun <T> Collection<T>.joinToString_2( // collection<T> 에 대한 확장함수 선언
    separator: String = ", ",
    prefix : String = "",
    postfix : String = "" // 파라미터 디폴트 값 지정
) : String{
    val result = StringBuilder(prefix)

    for ((index, element) in this.withIndex()){
        if( index > 0) result.append(separator)
        result.append(element)
    }
    result.append(postfix)
    return result.toString()
}

fun Collection<String>.join(
    separator: String = ", ",
    prefix : String = "",
    postfix : String = ""
) = joinToString_2(separator, prefix, postfix)