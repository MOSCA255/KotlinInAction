package kotlininaction.episode2.intration

fun fizzBuzz(i : Int) = when {
    i%15 == 0 -> "FizzBuzz"
    i%3 == 0 -> "Fizz"
    i%5 == 0 -> "Buzz"
    else -> "$i"
}

fun main(){
    reverseEven();

}

fun onetoHund(){
    for( i in 1..100){
        println(fizzBuzz(i))
    }
}

fun reverseEven(){
    for(i in 100 downTo 1 step 2){
        print(fizzBuzz(i))
    }
}