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

    (0..9).forEach{
        if(it == 5){
            return@forEach
        }
    }
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

private fun toRegexTest(){
    println("(0*)".toRegex())
}

private fun deepCopyTest(){
    val a = intArrayOf(1,2,3,4,5)
    val b = a
    val c = a.copyOf()

    a[0] = 999

    a.forEach(::print)
    println()
    b.forEach(::print)
    println()
    c.forEach(::print)
    println("\n결론 = 으로는 깊은 복사 안됨 copyOf() 사용해야 함")
}

private fun nullTest(){
    val a = intArrayOf(1,2,3,4,5)
    val b = intArrayOf(5,1,2,3,5)
    val c = intArrayOf(5,5,5,5,5)
    val d = intArrayOf()

    println(a.maxOrNull())
    println(b.maxOrNull())
    println(c.maxOrNull())
    println(d.maxOrNull())

    val result1:Int = d.maxOrNull() ?: -1
    println(result1)

//    실행시 오류
//    val result2:Int = d.maxOrNull()!!
//    println(result2)
}

private fun subListTest(){
    val arr1 = mutableListOf<Int>(1,2,3,4,5)
    val arr2 = arr1.subList(1,3)
    val arr3 = arr1.slice(1..3)

//    slice 는 깊은 복사 되는 느낌
//    subList 는 그냥 잘라서 잠시 보는 용도
    println(arr2)
    println(arr3)
}

private fun capitalizeTest(){
    val arr1 = arrayOf("test1", "test2", "test3")
    val arr2 = arrayOf("TTest1", "Ttest2", "tTest3")
    val arr3 = arrayOf("1test1", "2test2", "3test3")

    arr1.forEach { it.capitalize() }
    arr2.forEach { it.capitalize() }
    arr3.forEach { it.capitalize() }

    for(i in arr1.indices){
        println("${arr1[i].capitalize()}, ${arr2[i].decapitalize()}, ${arr3[i].capitalize()}")
    }
}

private fun arrCntTest(){
    val a = intArrayOf(1,1,1,1,2,3,4,5)

    println(a.count{ it == 1 })
}

private fun stringIsDigit(){
    val a = "123a"
    println(a.all{ it.isDigit() })
    val b = "123"
    println(b.all{it.isDigit()})
}

private fun filterIndexedTest(){
    val a = intArrayOf(1,2,3,4,5,6)
    val b = a.filterIndexed { idx, i -> idx % 2 == 0 }.count()
    println(b)
}

private fun toLowerUpperTest(){
    val a = "TESTe"
    var b = false
    a.toLowerCase().apply { b = this.count { it == 't' } == this.count{it == 'e'}}
    println(b)
}

private fun hashCodeTest(){
    val str = "teststring!!!"
    val str0 = "teststring!!!"
    val str1 = "dd"
    val str2 = "d"
    println("${str} : ${str.hashCode().toLong()} : ${str0.hashCode().toLong()}")
    println("${str1} : ${str1.hashCode().toLong()}")
    println("${str2} : ${str2.hashCode().toLong()}")
}

private fun main(){
    var testNumber:Int
    print("input number : ")
    Scanner(System.`in`).apply { testNumber = nextInt() }.close()

    when(testNumber){
        0 -> println("초기값 입니다.")
        1 -> whenTest()
        2 -> forEachTest()
        3 -> mapTest()
        4 -> coerceAtMostTest()
        5 -> reflection()
        6 -> indicesTest()
        7 -> initTest()
        8 -> swap()
        9 -> cntTest()
        10 -> compareTest()
        11 -> priorityQueueTest()
        12 -> toRegexTest()
        13 -> deepCopyTest()
        14 -> nullTest()
        15 -> subListTest()
        16 -> capitalizeTest()
        17 -> arrCntTest()
        18 -> stringIsDigit()
        19 -> filterIndexedTest()
        20 -> toLowerUpperTest()
        21 -> hashCodeTest()
        else -> println("해당 숫자가 없습니다.")
    }
}