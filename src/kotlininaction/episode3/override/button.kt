package kotlininaction.episode3.override

open class View {
    open fun click() = println("View clicked")
}

class Button: View(){ // button 은 view 를 확장한다.
    override fun click() = println("Button clicked")
}

fun main (){
    val button : View = Button()
    button.click() // Button clicked
    val view : View = View()
    view.click() // View clicked
}

