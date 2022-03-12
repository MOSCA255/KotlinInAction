package kotlininaction.episode2.intration

import java.io.BufferedReader
import java.io.StringReader
import java.lang.IllegalArgumentException
import java.lang.NumberFormatException

fun main () {
    val reader = BufferedReader(StringReader("239"))
    println(readNumber(reader))
    val reader_2 = BufferedReader(StringReader("Not a Number"))
    println(readNumber_2(reader_2)) // 아무것도 출력되지 않는다.
}

fun readNumber( reader : BufferedReader) : Int? {
    try {
        //함수가 던질 수 있는 예외를 명시할 필요가 없다. ? 로 nullable 을 명시한다.
        val line = reader.readLine()
        return Integer.parseInt(line)
    } catch (e : NumberFormatException) {
        // 예외 타입을 : 의 오른쪽에 쓴다.
        return null
    } finally {
        // finally 는 자바와 똑같이 동작한다.
        reader.close()
    }
}

fun readNumber_2( reader : BufferedReader){
    val number = try {
        Integer.parseInt(reader.readLine()) // 이 식의 값이 "try" 식의 값이 된다
    } catch (e : NumberFormatException) {
        null
    }
    println(number)
}


fun checkPercentageNumber(number : Int){
    val percentage =
        if(number in 0..100)
            number
        else
            throw IllegalArgumentException("A percentage value must be between 0 and 100 : $number")

}