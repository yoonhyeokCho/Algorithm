import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.*

private val br = BufferedReader(InputStreamReader(System.`in`))
private val bw = BufferedWriter(OutputStreamWriter(System.out))

private var arr = Array(3, { IntArray(3) })
private var T = 0
private lateinit var visited:BooleanArray

fun main() {
    T = br.readLine().toInt()
    while (T > 0) {
        visited = BooleanArray(512)
        for (i in 0 until 3) {
            val token = StringTokenizer(br.readLine(), " ")
            for (j in 0 until 3) {
                if (token.nextToken() == "H") {
                    arr[i][j] = 1
                } else
                    arr[i][j] = 0
            }
        }
        solution()

        T--
    }
    bw.flush()
    bw.close()
}

private fun reverse(case: Int, num: Int) {
    when (case) {
        //row
        1 -> {
            for (i in 0 until 3) {
                if (arr[num][i] == 1) {
                    arr[num][i] = 0
                } else {
                    arr[num][i] = 1
                }
            }
        }
        //col
        2 -> {
            for (i in 0 until 3) {
                if (arr[i][num] == 1) {
                    arr[i][num] = 0
                } else {
                    arr[i][num] = 1
                }
            }
        }
        //대각선
        3 -> {
            for (i in 0 until 3) {
                if (num == 0) {
                    if (arr[i][i] == 1) {
                        arr[i][i] = 0
                    } else {
                        arr[i][i] = 1
                    }
                } else {
                    if (arr[i][2 - i] == 1) {
                        arr[i][2 - i] = 0
                    } else {
                        arr[i][2 - i] = 1
                    }
                }

            }
        }
    }
}

private fun check(): Boolean {
    var temp = arr[0][0]
    for (i in 0 until 3) {
        for (j in 0 until 3) {
            if (temp != arr[i][j]) {
                return false
            }
        }
    }
    return true
}

//2차원 배열 -> 1차원 배열
fun toOneDimension(): Int {
    var now = 0
    for (i in 0..2) {
        for (j in 0..2) {
            now = now * 2 + arr[i][j]
        }
    }
    return now
}

//1차원 배열 - > 2차원 배열
fun toTwoDimension(number: Int) {
    var number = number
    for (i in 2 downTo 0) {
        for (j in 2 downTo 0) {
            arr[i][j] = number % 2
            number /= 2
        }
    }
}

private fun solution() {
    var queue: Queue<Pair<Int, Int>> = LinkedList()
    var first = toOneDimension()
    visited[first] = true

    queue.add(Pair(first, 0))
    while (!queue.isEmpty()) {
        var cur = queue.peek().first
        var cnt = queue.peek().second
        queue.poll()

        toTwoDimension(cur)

        if (check()) {
            bw.write("$cnt\n")
            return
        }

        for (i in 0 until 3) {
            reverse(1, i)
            val next = toOneDimension()
            if (!visited[next]) {
                visited[next] = true
                queue.add(Pair(next,cnt+1) )
            }
            reverse(1,i)
        }

        for (i in 0 until 3) {
            reverse(2, i)
            val next = toOneDimension()
            if (!visited[next]) {
                visited[next] = true
                queue.add(Pair(next,cnt+1))
            }
            reverse(2,i)
        }

        for (i in 0 .. 1) {
            reverse(3, i)
            val next = toOneDimension()
            if (!visited[next]) {
                visited[next] = true
                queue.add(Pair(next,cnt+1))
            }
            reverse(3,i)
        }
    }
    bw.write("-1\n")
}