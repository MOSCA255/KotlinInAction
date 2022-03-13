package kotlininaction.episode3.string

fun main() {
    println("12.345-6.A".split("\\.|-".toRegex()))

    println("12.345-6.A".split(".", "-"))

    parsePath("/user/yole/kotlin-book/chapter.adoc");
    parsePathReg("/user/yole/kotlin-book/chapter.adoc");
}


fun parsePath(path:String){
    val directory = path.substringBefore("/")
    val fullname = path.substringAfterLast("/")

    val fileName = path.substringBeforeLast(".")
    val extension = path.substringAfterLast(".")

    println("Dir : $directory, name : $fileName , ext : $extension")
}

fun parsePathReg(path:String){
    val regex = """(.+)/(.+)\.(.+)""".toRegex()
    val matchResult = regex.matchEntire(path);
    if(matchResult != null){
        val (directory, fileName, extension) = matchResult.destructured
        println("Dir : $directory, name : $fileName , ext : $extension")
    }
}