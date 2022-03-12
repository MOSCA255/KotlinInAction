package kotlininaction.episode2

fun main ( args : Array<String>){

    println("Hello, world")

    println(max(1,2))

    val name= if (args.size > 0 ) args[0] else "Kotlin"
    println("Hello, $name")

    if(args.size > 0){
        println("Hello, ${args[0]}!")
    }

    val person = Person("bob", true)
    println("name ${person.personName} & ${person.isMarried}")
    person.isMarried = false
    println("married ${person.isMarried}")

    val rectangle = Rectangle(41,43)
    println("isSquare : ${rectangle.isSquare}")
}

fun max(a:Int, b:Int) : Int {
    return if (a>b) a else b
}

fun max_2 ( a:Int, b:Int ) : Int = if ( a > b ) a else b

fun max_3 ( a:Int, b:Int ) = if ( a > b ) a else b

fun vals (){
    val message : String
    if(true){
        message = "Success"
    } else {
        message = "Fail"
    }
    //message = "a"; <- val cannot be reassigned
}