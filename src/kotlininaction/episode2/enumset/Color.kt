package kotlininaction.episode2.enumset

enum class Color (
    val r: Int,
    val g: Int,
    val b: Int // 상수 프로퍼티 정의
){
    RED(255,0,0), // 각 상수 생성시 그에 대한 프로퍼티 값 지정
    ORANGE(255,165,0),
    YELLOW(255,255,0),
    GREEN(0,255,0),
    BLUE(0,0,255),
    INDIGO(75,0,130),
    VIOLET(238,130,238); // 반드시 세미콜론 사용

    fun rgb() = (r * 256 + g ) * 256 + b // enum 클래스 내부 메소드


}



fun getMnemonic(color:Color) = when (color){
    Color.RED -> "Richard"
    Color.ORANGE -> "Of"
    Color.YELLOW -> "York"
    Color.GREEN -> "Gave"
    Color.BLUE -> "Battle"
    Color.INDIGO -> "In"
    Color.VIOLET -> "Vain"
}

fun getWarmth(color:Color) = when(color){
    Color.RED, Color.ORANGE, Color.YELLOW -> "Warm"
    Color.GREEN -> "neutral"
    Color.BLUE, Color.INDIGO, Color.VIOLET -> "cold"
}

fun mix(c1:Color, c2:Color) =
    when(setOf(c1, c2)){ // when 식의 인자로 아무 객체나 사용가능
        setOf(Color.RED, Color.YELLOW) -> Color.ORANGE
        setOf(Color.YELLOW, Color.BLUE) -> Color.GREEN
        setOf(Color.BLUE, Color.VIOLET) -> Color.INDIGO
        else -> throw Exception("Dirty color")
    }

fun mixOptimized(c1 : Color, c2: Color) =
    when {
        (c1 == Color.RED && c2==Color.YELLOW) || (c1 == Color.YELLOW && c2 == Color.RED) -> Color.ORANGE
        (c1 == Color.YELLOW && c2==Color.BLUE) || (c1 == Color.BLUE && c2 == Color.YELLOW) -> Color.GREEN
        (c1 == Color.BLUE && c2==Color.VIOLET) || (c1 == Color.VIOLET && c2 == Color.BLUE) -> Color.INDIGO
        else -> throw Exception("Dirty Color")
    }

fun main () {
    println(getMnemonic(Color.BLUE)) // Battle
    println(getWarmth(Color.ORANGE)) // Warm
    println(mix(Color.BLUE, Color.YELLOW)) // GREEN
    println(mixOptimized(Color.RED, Color.YELLOW)); // ORANGE
}