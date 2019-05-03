package sample


fun main() {
    val str: String = "Kotlin is fun!!"
    println(str)
    println(str.length) // 15
    println(str.isBlank()) // false
    println(str[0]) // K
    println(str.toUpperCase()) // KOTLIN IS FUN!!

    println("5 + 2 は ${5 + 2} です")

    val message = """
        love
        Kotlin
    """
    println(message)

    val strs: Array<String> = arrayOf("foo", "bar", "baz")
    println(strs[0])
    strs[2] = "qux"
    println(strs[2])
    strs.forEach { x -> println(x) }
    val ints: IntArray = intArrayOf(1, 2, 3)
    println(ints[0])


    val intList: List<Int> = listOf(1, 2, 3)
    println(intList)
    val mutableList: MutableList<String> = mutableListOf("fuga")
    println(mutableList)
    mutableList.add("piyo")
    println(mutableList)
    mutableList.remove("fuga")
    println(mutableList)

    val b : List<String> = mutableList
    println(b)
    mutableList.add("fuga")
    println(b)
    (b as MutableList<String>).add("fuga")  // downcast
    println(b)

    val map: MutableMap<String, Int> = mutableMapOf("one" to 1)
    println(map)
    map["two"] = 2
    println(map)

    println(5 in 1..10) // true
    println((1..10).toList()) // [1,2,3,4,5]
    println((10 downTo 1 step 2).toList()) // [10,8,6,4,2]

    val result = when(3) {
        1 -> "ONE"
        in 2..5 -> "TWO..FIVE"
        else -> "OTHER"
    }
    println(result)
    val target: Any = 2
    println(
        when(target) {
            is Double -> "Double"
            is Int -> "Int"
            else -> "Other"
        }
    )

    for (i in 10 downTo 3 step 2) { println(i) }

    println("--------FizzBuzz")
    for (i in 1..100) {
        val output = when {
            i % 15 == 0 -> "FizzBuzz"
            i % 5 == 0 -> "Buzz"
            i % 3 == 0 -> "Fizz"
            else -> "$i"
        }
        println(output)
    }
}