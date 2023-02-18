import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.LinkedList
import java.util.PriorityQueue
import java.util.Queue
import java.util.StringTokenizer

private var br = BufferedReader(InputStreamReader(System.`in`))
private val bw = BufferedWriter(OutputStreamWriter(System.out))
private lateinit var arr: Array<LectureTime>
private var n = 0

data class LectureTime(val start: Int, val end: Int)

fun main() {
    n = br.readLine().toInt()
    arr = Array(n, { LectureTime(0, 0) })
    var a = 0
    var b = 0
    for (i in 0 until n) {
        val token = StringTokenizer(br.readLine(), " ")
        a = token.nextToken().toInt()
        b = token.nextToken().toInt()

        arr[i] = LectureTime(a, b)
    }
    solution()
}

private fun solution() {
    arr.sortBy { it.start }

    val queue = PriorityQueue<Int>()
    queue.add(arr[0].end)

    for (i in 1 until n) {
        if (queue.peek() <= arr[i].start) {
            queue.poll()
            queue.add(arr[i].end)
        } else {
            queue.add(arr[i].end)
        }
    }
    bw.write(queue.size.toString())
    bw.flush()
    bw.close()
}


//          시간초과 코드
//import java.io.BufferedReader
//import java.io.BufferedWriter
//import java.io.InputStreamReader
//import java.io.OutputStreamWriter
//import java.util.LinkedList
//import java.util.Queue
//import java.util.StringTokenizer
//
//private var br = BufferedReader(InputStreamReader(System.`in`))
//private val bw = BufferedWriter(OutputStreamWriter(System.out))
//private lateinit var arr: Array<LectureTime>
//private lateinit var lectureRoom: Array<ArrayList<Int>>
//private var n = 0
//private var lectureRoomCount = 0
//
//data class LectureTime(val start: Int, val end: Int)
//
//fun main() {
//    n = br.readLine().toInt()
//    arr = Array(n, { LectureTime(0, 0) })
//    lectureRoom = Array(n, { ArrayList() })
//    var a = 0
//    var b = 0
//    for (i in 0 until n) {
//        val token = StringTokenizer(br.readLine(), " ")
//        a = token.nextToken().toInt()
//        b = token.nextToken().toInt()
//
//        arr[i] = LectureTime(a, b)
//    }
//
//    arr.sortBy{it.start}
//
//    scheduling(arr.size)
//    var count = 0
//    for (i in 0 until n) {
//        if (lectureRoom[i].size != 0) {
//            count++
//        }
//    }
//
//    println(count)
//
//}
//
//private fun operating(start: Int): Int {
//    var cur = 0
//    if (lectureRoomCount > 0) {
//        for (i in 0 until lectureRoomCount) {
//            if (lectureRoom[i].size > 0 && arr[lectureRoom[i].get(lectureRoom[i].size - 1)].end < start) {
//                return i
//            }
//            cur = i
//        }
//        lectureRoomCount++
//        return cur
//    } else {
//        lectureRoomCount++
//        return 0
//    }
//}
//
//private fun scheduling(lectureNum: Int) {
//    for (i in 0 until lectureNum) {
//        val lectureRoomNum = operating(arr[i].start)
//        lectureRoom[lectureRoomNum].add(i)
//    }
//}