import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.LinkedList
import java.util.Queue
import java.util.StringTokenizer
import kotlin.math.floor
import kotlin.math.hypot
import kotlin.math.pow
import kotlin.math.sqrt

private val br = BufferedReader(InputStreamReader(System.`in`))
private val bw = BufferedWriter(OutputStreamWriter(System.out))
private var N = 0
private var W = 0
private var M = 0.0
private lateinit var arr: Array<Point>
private lateinit var check: Array<BooleanArray>

private data class Point(val x: Int, val y: Int)

fun main() {
    var token = StringTokenizer(br.readLine(), " ")
    N = token.nextToken().toInt()
    W = token.nextToken().toInt()
    M = br.readLine().toDouble()

    arr = Array(N + 1, { Point(0, 0) })
    check = Array(N + 1, { BooleanArray(N + 1) })
    var a = 0
    var b = 0
    for (i in 1..N) {
        token = StringTokenizer(br.readLine(), " ")
        a = token.nextToken().toInt()
        b = token.nextToken().toInt()
        arr[i] = Point(a, b)
    }
    for (i in 0 until W) {
        token = StringTokenizer(br.readLine(), " ")
        a = token.nextToken().toInt()
        b = token.nextToken().toInt()
        check[a][b] = true
        check[b][a] = true
    }
    bw.write(solution().toInt().toString())
    bw.flush()
    bw.close()
}

private fun getDist(pointA: Int, pointB: Int): Double {
    val dist = sqrt(
        ((arr[pointA].x - arr[pointB].x).toDouble()).pow(2) +
                ((arr[pointA].y - arr[pointB].y).toDouble()).pow(2)
    )

    return dist
}


private fun solution(): Double {
    var dist: DoubleArray = DoubleArray(N + 1)
    var visited: BooleanArray = BooleanArray(N + 1)
    var minDistIndex = 0

    for (i in 1..N) {
        dist[i] = Double.MAX_VALUE
    }
    var queue: Queue<Int> = LinkedList()
    dist[1] = 0.0
    queue.offer(1)

    while (!queue.isEmpty()) {
        var cur = queue.poll()
        if (cur == N) {
            break
        }

        visited[cur] = true
        var minDist = Double.MAX_VALUE

        for (i in 1..N) {
            val next = i
            if (check[cur][next]) {
                dist[next] = dist[cur]
            }

            if (!visited[i] && dist[next] > dist[cur] + getDist(cur, next) && getDist(cur, next) < M) {
                dist[next] = dist[cur] + getDist(cur, next)
            }

            if (!visited[i] && minDist > dist[i]) {
                minDist = dist[i]
                minDistIndex = i
            }
        }
        queue.offer(minDistIndex)
    }
    return floor(dist[N] * 1000)
}