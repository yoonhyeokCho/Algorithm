import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.lang.StringBuilder
import java.util.*

private var br = BufferedReader(InputStreamReader(System.`in`))
private val bw = BufferedWriter(OutputStreamWriter(System.out))
private var n = 0

private lateinit var arr: Array<IntArray>
private lateinit var eachAnswer: Array<IntArray>

fun main() {
    n = br.readLine().toInt()

    arr = Array(n + 1, { IntArray(n + 1) })
    eachAnswer = Array(n + 1, { IntArray(n + 1) })
    var a = 0
    var b = 0
    for (i in 1..n) {
        Arrays.fill(arr[i], n)
    }
    while (true) {
        val token = StringTokenizer(br.readLine(), " ")
        a = token.nextToken().toInt()
        b = token.nextToken().toInt()

        if (a == -1) break

        arr[a][b] = 1
        arr[b][a] = 1
    }

    for (i in 1..n) {
        solution(i)
    }

    var answer = IntArray(n + 1)
    for (i in 1..n) {
        answer[i] = eachAnswer[i].max()
    }
    answer[0] = Int.MAX_VALUE
    val answerValue = answer.min()
    var answerCount = 0
    var answerIndex = arrayListOf<Int>()
    for (i in 1..n) {
        if (answer[i] == answerValue) {
            answerCount++
            answerIndex.add(i)
        }
    }
    answerIndex.sort()
    var str = answerValue.toString() + " " + answerCount.toString()
    bw.write(str)
    bw.write("\n")
    for (i in answerIndex.indices) {
        bw.write(answerIndex[i].toString() + " ")
    }
    bw.flush()
    bw.close()
}

private fun solution(start: Int) {
    var queue: Queue<Int> = LinkedList()
    queue.offer(start)

    var visited: BooleanArray = BooleanArray(n + 1)
    var dist: IntArray = IntArray(n + 1)

    for (i in 1..n) {
        dist[i] = n
    }

    dist[start] = 0

    var minDistIndex = 0
    var count = 0
    while (count != n) {
        var minDist = Int.MAX_VALUE
        val cur = queue.poll()
        visited[cur] = true
        for (i in 1..n) {
            val next = i
            if (!visited[next]) {
                if (dist[next] > dist[cur] + arr[cur][next]) {
                    dist[next] = dist[cur] + arr[cur][next]
                }
                if (minDist > dist[next]) {
                    minDist = dist[next]
                    minDistIndex = next
                }
            }
        }
        eachAnswer[start][cur] = dist[cur]
        count++
        queue.offer(minDistIndex)
    }
}
