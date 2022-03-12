package kotlininaction.episode2.smartcast

import javafx.beans.binding.When
import java.lang.IllegalArgumentException

interface Expr
class Num(val value : Int) : Expr
class Sum(val left: Expr , val right: Expr) : Expr

fun main (){
    println( eval(Sum( Sum( Num(1), Num(2) ) , Num(4))))
    println( eval_2(Sum( Sum( Num(3), Num(4) ) , Num(5))))
    println( eval_3(Sum( Sum( Num(1), Num(1) ) , Num(1))))

    evalWithLogging(Sum( Sum( Num(1), Num(1) ) , Num(1)))
}

fun eval(e: Expr): Int {
    if ( e is Num) {
        val n = e as Num // 여기서 Num 타입으로 변환하는데 불필요한 중복이다.
        return n.value
    }

    if ( e is Sum) {
        return eval(e.right) + eval(e.left)
    }
    throw IllegalArgumentException("Unknown Expression")
}

fun eval_2(e: Expr): Int =
    if ( e is Num) {
        e.value
    } else if ( e is Sum) {
        eval_2(e.right) + eval_2(e.left)
    } else {
        throw IllegalArgumentException("Unknown Expression")
    }

fun eval_3(e : Expr) : Int =
    when(e){
        is Num -> e.value
        is Sum -> eval_3(e.left) + eval_3(e.right)
        else -> throw IllegalArgumentException("Unknown Expression")
    }

fun evalWithLogging( e: Expr) : Int =
    when (e){
        is Num -> {
            println("num: ${e.value}")
            e.value
    }
        is Sum -> {
            val left = evalWithLogging(e.left)
            val right = evalWithLogging(e.right)
            println("sum: $left + $right")
            left + right;
    }
        else -> throw IllegalArgumentException("Unknown Expression")

}