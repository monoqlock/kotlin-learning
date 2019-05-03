package sample

fun succ(n: Int) = n + 1

fun contains(ints: List<Int>, predicate: (Int) -> Boolean): Boolean {
    for (i in ints) {
        if (predicate(i)) return true
    }
    return false
}

fun isGraterThanFive(n: Int) = n > 5
fun isMultipleOfThree(n: Int) = n % 3 == 0

fun sum(ints: List<Int>): Int {
    tailrec fun go(ints: List<Int>, acc: Int): Int =
        if (ints.isEmpty()) acc
        else go(ints.drop(1), acc + ints.first())
    return go(ints, 0)
}

fun maximum(vararg ints: Int): Int {
    var max = 0
    for (n in ints) {
        if (n > max) max = n
    }
    return max
}

fun main() {
    val myFunction = ::succ
    val got = myFunction(5)
    println(got)

    println(contains(listOf(2,4,6), ::isGraterThanFive))
    println(contains(listOf(7,5,4), ::isMultipleOfThree))

    println(contains(listOf(2,4,6), { n -> n > 5}))
    println(contains(listOf(7,5,4)) {it % 3 == 0})

    println(contains(listOf(2,4,6), fun(n: Int): Boolean { return n > 5 }))
    println(contains(listOf(7,5,4), fun(n: Int): Boolean { return n % 3 ==0}))

    println(contains(listOf(2,4,6), fun(n) = n > 5))
    println(contains(listOf(7,5,4), fun(n) = n % 3 == 0))

    println(sum(listOf(1,2,3,4,5,6,7,8,9)))
    println(maximum(1,3,6,9,2))
}