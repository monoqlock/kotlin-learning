
open class Person(var name: String) {

    val initial: Char
        get() = name[0]

    open fun show() {
        println("Person. name=$name")
    }
}

class Student(val id: Long, name: String): Person(name) {
    override fun show() {
        println("Student. id=$id, name=$name")
    }
}

abstract class Greeter {
    abstract val name: String

    open fun sayHello() {
        println("Hello")
    }
    abstract fun sayGoodBye()
}

class JapaneseGreeter(override val name: String): Greeter() {
    override fun sayHello() {
        println("こんちには. ${name}です")
    }

    override fun sayGoodBye() {
        println("さようなら")
    }
}

interface Greeter2 {
    fun sayHello()
}

class EnglishGreeter2: Greeter2 {
    override fun sayHello() {
        println("Hello")
    }
}

interface InterfaceA {
    fun foo() {
        println("A")
    }
}

interface InterfaceB {
    fun foo() {
        println("B")
    }
}

class MultiInterface: InterfaceA, InterfaceB {
    override fun foo() {
        super<InterfaceA>.foo()
    }
}

object SingletonGreeter: Greeter2 {
    override fun sayHello() {
        println("Hello from singleton")
    }
}

fun main() {
    val taro = Person("taro")
    taro.show()
    println(taro.initial)
    taro.name = "太郎"
    taro.show()
    println(taro.initial)

    val haruko = Student(1, "haruko")
    haruko.show()
    println(haruko.initial)


    val greeter = JapaneseGreeter("taro")
    greeter.sayHello()
    greeter.sayGoodBye()

    val englishGreeter = EnglishGreeter2()
    englishGreeter.sayHello()

    val multi = MultiInterface()
    multi.foo()

    SingletonGreeter.sayHello()
}