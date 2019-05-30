import java.io.*
import java.math.*
import java.security.*
import java.text.*
import java.util.*
import java.util.concurrent.*
import java.util.function.*
import java.util.regex.*
import java.util.stream.*
import kotlin.collections.*
import kotlin.comparisons.*
import kotlin.io.*
import kotlin.jvm.*
import kotlin.jvm.functions.*
import kotlin.jvm.internal.*
import kotlin.ranges.*
import kotlin.sequences.*
import kotlin.text.*

fun  inversion(arr:Array<Int>): Long{
    var inv = 0L
    if (arr.size <= 0) {
        return  inv
    }
    var sorted = Array<Int>(arr.size){0}
    inv += mergeInversion(arr, sorted, 0, arr.size - 1)

    return inv
}

private fun mergeInversion(arr: Array<Int>, sorted: Array<Int>, left: Int, right: Int): Long {
    var  mcount = 0L
    if (right > left) {
        var mid = (left + right) / 2
        mcount += mergeInversion(arr, sorted, left, mid)
        mcount += mergeInversion(arr, sorted,  mid + 1, right)
        mcount += merge(arr, sorted, left, mid + 1, right)
    }
    return mcount
}
private fun merge(arr: Array<Int>, sorted: Array<Int>, left:Int, mid:Int, right: Int): Long {
    var count = 0L
    var i = left
    var j = mid
    var k = left
    while (i <= mid-1 && j <= right) {
        val  a = arr[i]
        val b = arr[j]
        if (a <= b) {
            sorted[k] = a
            i ++
        } else {
            sorted[k] = b
            j ++
            count += mid  - i
//                    println("count = $count")
        }
        k ++
    }

    while (i <= mid-1) {
        //println("i = $i  ${mid - 1} k=$k")
        sorted[k] = arr[i]
        k ++
        i ++
    }
    while (j <= right) {
        sorted[k] = arr[j]
        k ++
        j ++
    }
    for (i in left..right) {
        arr[i] = sorted[i]
    }
    return count
}

fun countInversions(arr: Array<Int>): Long {

    return inversion(arr)
}


fun main(args: Array<String>) {
    val scan = Scanner(System.`in`)

    val t = scan.nextLine().trim().toInt()

    for (tItr in 1..t) {
        val n = scan.nextLine().trim().toInt()

        val arr = scan.nextLine().split(" ").map{ it.trim().toInt() }.toTypedArray()

        val result = countInversions(arr)

        println(result)
    }
}
