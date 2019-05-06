package chapter8

// 型エイリアス
typealias OnClickListener = (Button) -> Unit

class Button {
    var onClickListener: OnClickListener? = null
}

data class User(val id: Long, val blocked: Boolean)

sealed class Option<out T : Any>
object None: Option<Nothing>()
data class Some<out T : Any>(val value: T) : Option<T>()

fun main() {

    // lazy
    val name: String by lazy {
        println("初期化！！")
        "world"
    }
    println("Hello, $name")
    println("Hello, $name")

    val myCount: String.() -> Int = String::count
    println("Hello".myCount())
    val kotlinCount: () -> Int = "Kotlin"::count
    println(kotlinCount())
    val whiteList = listOf("Blue", "Red", "Green")
    println(listOf("Yellow", "Brown", "Blue").filter(whiteList::contains))
    println(listOf("Yellow", "Brown", "Blue").filter{whiteList.contains(it)})

    val users = listOf(User(123, false), User(234, true), User(345, true))
    println(users.filter{ (_, blocked) -> !blocked })

    val s: Option<String> = Some("Sealed Class")
    val message = when(s) {
        is Some -> "Hello, ${s.value}!"
        is None -> "Hello!"
    }
    println(message)

}