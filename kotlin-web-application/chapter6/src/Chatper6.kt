package sample

fun Int.isEven(): Boolean = (this % 2 == 0)

val Int.isOdd: Boolean
    get() = (this % 2 != 0)


interface Greeter {
    val name: String
    fun introduceMyself()
    fun sayHello()
}

class EnglishGreeter(override val name: String): Greeter {
    override fun sayHello() {
        println("Hello")
    }

    override fun introduceMyself() {
        sayHello()
        println("My name is $name")
    }
}

class CountingGreeter(val greeter: Greeter) : Greeter by greeter {
    var helloCount: Int = 0
        private set

    override fun sayHello() {
        helloCount++
        greeter.sayHello()
    }
}

// インライン関数
inline fun fuga() {
    throw RuntimeException()
}

// データクラス
data class Person(val id: Long, val name: String)

data class Container<T>(var value: T)

class MyInt(val value: Int) {
    override fun toString(): String = value.toString()
    operator fun plus(that: MyInt): MyInt = MyInt(value + that.value)
}

// compaion object
class Circle(val radius: Double, val x: Double = 0.0, val y: Double = 0.0) {
    companion object {
        val PI = 3.14
    }
    val area: Double
        get() = radius * radius * PI
}

fun main() {

    println(5.isEven())
    println(5.isOdd)

    var bar: String? = "Hello"
    println(bar)
    bar = null
    println(bar)
    bar = "bar"

    val ints: List<Int> = mutableListOf(1,2,3)
    if (ints is MutableList<Int>) {
        ints.add(4)
    }
    println(ints)

    if (bar != null) {
        println(bar.toUpperCase())
    }

    // 演算子　!!
    val hoge: String? = "forbidden magic"
    val fuga: String = hoge!!
    println(fuga.toUpperCase())

    // 安全呼び出し
    val piyo: String? = null
    println(bar?.toUpperCase()) // BAR
    println(piyo?.toUpperCase()) // null

    // エルビス演算子
    println(bar?.toUpperCase() ?: "default") // BAR
    println(piyo?.toUpperCase()  ?:"default") // default


    val enGreeter = EnglishGreeter("taro")
    val cntGreeter = CountingGreeter(enGreeter)
    println(cntGreeter.helloCount)
    cntGreeter.sayHello()
    println(cntGreeter.helloCount)

    // fuga()

    val taro = Person(123, "taro")
    val taro2 = Person(123, "taro")
    println(taro.toString()) // Person(id=123, name=taro)
    println(taro == taro2) // true
    println(taro === taro2) // false

    val taro3 = taro.copy(name = "taro3")
    println(taro3.toString())
    println(taro.component1()) // 123
    println(taro.component2()) // taro

    val (id, name) = Person(345, "hanako")
    println(id) // 345
    println(name) // hanako

    listOf(taro, taro3).map { (_, name) -> println(name.toUpperCase())}

    val con: Container<Int> = Container(5)
    println(con)

    val myObject = object {
        override fun toString(): String = "MyObject"
    }
    println(myObject)

    println(MyInt(4) + MyInt(9)) // 13

    println(Circle(3.0).area)
}