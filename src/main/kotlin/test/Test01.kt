package test

import java.util.Scanner
import java.util.PriorityQueue

private fun whenTest(){
    val a = 2
    val b = intArrayOf(1,2,3,4,5)
    val c = intArrayOf(1,3,4,5,6)

    println(a in b)
    println(a in c)

    when {
        a == 2 -> println("2")
        a % 2 == 0 -> println("짝수")
        else -> println("else")
    }
}

private fun forEachTest(){
    (0..9).forEach { print(it) }
}

private fun mapTest(){
    (0..9).map { i -> print(i) }
    println()
    (0..9).map { print(it) }
}

private fun coerceAtMostTest(){
    val a = 10
    val b = 5
    println(a.coerceAtMost(b))
    println(b.coerceAtMost(a))
    println(a.coerceAtLeast(b))
    println(b.coerceAtLeast(a))
}

private fun reflection(){
    fun isOdd(num : Int):Boolean = num % 2 != 0

    val numbers = intArrayOf(1,2,3,4,5,6)
    numbers.filter(::isOdd).map { print(it) }
    println()
    val a = intArrayOf(1,2,3,4,3,3)
    val b = intArrayOf(1,3,3)

    //여기가 핵심
    a.filter(b::contains).map(::print)
    println()
    a.filter { b.contains(it) }.map(::print)
    println()

    b.filter(a::contains).map(::print)
    println()
    a.map(3::equals).map(::print)
    println()
    b.map(3::equals).map(::print)
}

private fun indicesTest(){
    val a = intArrayOf(1,2,3,4,5)
    for(i in a.indices - 2){
        println(i)
    }
}

private fun initTest(){
    val a = "1"
    println(String.format("%5s", a))
    println("${"%5s".format(a)}")
}

private fun swap(){
    var a = 1
    var b = 2
    a = b.also { b = a }
    println("${a}, ${b}")
}

private fun cntTest(){
    var s = "11110"
    println(s.replace("0", "").count())
}

private fun compareTest(){
    val a = 1
    val b = 2
    println(a.compareTo(b))
    println(a.compareTo(a))
    println(b.compareTo(a))
}

private fun priorityQueueTest(){
    val pq1 = PriorityQueue<Pair<Int, Int>>(compareBy { it.first })
    val pq2 = PriorityQueue<Pair<Int, Int>>(compareByDescending{ it.first })

    (10 downTo 1).map {
        pq1.offer(it to 88)
        pq2.offer(it to 77)
    }

    for(i in 1..10){
        println("pq1 = ${pq1.poll()}, pq2 = ${pq2.poll()}")
    }
    println("||||||||")

    (1..10).map {
        pq1.offer(it to 88)
        pq2.offer(it to 77)
    }

    for(i in 1..10){
        println("pq1 = ${pq1.poll()}, pq2 = ${pq2.poll()}")
    }
}

private fun main(){
    var testNumber = 0
    Scanner(System.`in`).apply { testNumber = nextInt() }.close()

    when(testNumber){
        0 -> println("초기값 입니다.")

        else -> println("해당 숫자가 없습니다.")
    }

    println("---test when---")
    whenTest()
    println("======")

    println("---test foreach---")
    forEachTest()
    println("======")

    println("---test map---")
    mapTest()
    println("======")

    println("---test coerceAtMost---")
    coerceAtMostTest()
    println("======")

    println("---test :: reflection---")
    reflection()
    println("======")

    println("---test indices---")
    indicesTest()
    println("======")

    println("---test init array---")
    initTest()
    println("======")

    println("---test swap---")
    swap()
    println("======")

    println("---test cnt---")
    cntTest()
    println("======")

    println("---test compare---")
    compareTest()
    println("======")

    println("---test priorityQueue")
    priorityQueueTest()
    println("======")

    println(testNumber)
}