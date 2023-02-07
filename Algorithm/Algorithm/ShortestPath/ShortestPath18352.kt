import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.*
import kotlin.collections.ArrayList

private val br = BufferedReader(InputStreamReader(System.`in`))
private val bw = BufferedWriter(OutputStreamWriter(System.out))
private var N = 0
private var M = 0
private var K = 0
private var X = 0
private lateinit var arr: Array<ArrayList<Int>>
private lateinit var dist: IntArray
fun main() {
    val token = StringTokenizer(br.readLine(), " ")
    N = token.nextToken().toInt()
    M = token.nextToken().toInt()
    K = token.nextToken().toInt()
    X = token.nextToken().toInt()

    var a = 0
    var b = 0
    arr = Array(N + 1, { ArrayList() })
    dist = IntArray(N + 1)
    Arrays.fill(dist, Int.MAX_VALUE)

    for (i in 0 until M) {
        val token = StringTokenizer(br.readLine(), " ")
        a = token.nextToken().toInt()
        b = token.nextToken().toInt()

        arr[a].add(b)
    }
    solution()

    var count = 0
    for (i in dist.indices) {
        if (dist[i] == K) {
            bw.write(i.toString() + "\n")
            count++
        }
    }
    if (count == 0) {
        bw.write("-1")
    }

    bw.flush()
    bw.close()
}

fun solution() {
    var queue: Queue<Int> = LinkedList()
    dist[X] = 0
    queue.offer(X)

    while (!queue.isEmpty()) {
        var cur = queue.poll()
        for (i in arr[cur].indices) {
            val next = arr[cur][i]
            if (dist[next] > dist[cur] + 1) {
                dist[next] = dist[cur] + 1
                queue.offer(next)
            }
        }
    }
}
