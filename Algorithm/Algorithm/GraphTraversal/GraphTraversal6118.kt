import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.LinkedList
import java.util.Queue
import java.util.StringTokenizer

private val br = BufferedReader(InputStreamReader(System.`in`))
private val bw = BufferedWriter(OutputStreamWriter(System.out))

private lateinit var arr: Array<ArrayList<Int>>

private var N = 0
private var M = 0
fun main() {
    val token = StringTokenizer(br.readLine(), " ")
    N = token.nextToken().toInt()
    M = token.nextToken().toInt()

    arr = Array(N + 1, { ArrayList() })

    repeat(M){
        val (a,b) = br.readLine().split(" ").map { it.toInt() }
        arr[a].add(b)
        arr[b].add(a)
    }

    var answerArr = bfs(1)
    var temp = answerArr.copyOf()
    temp.sort()
    var max = temp[N]
    var indexArr = mutableListOf<Int>()
    var count = 0

    for (i in 1..N) {
        if (answerArr[i] == max) {
            indexArr.add(i)
            count++
        }
    }
    indexArr.sort()
    bw.write("${indexArr[0]} ${max} ${count}")
    bw.flush()
    bw.close()

}

private fun bfs(v: Int): IntArray {
    var answer = IntArray(N + 1)
    var visited = BooleanArray(N + 1)
    val queue: Queue<Int> = LinkedList()
    queue.add(v)
    visited[v] = true

    while (!queue.isEmpty()) {
        val cur = queue.poll()
        for (i in 0 until arr[cur].size) {
            val next = arr[cur].get(i)
            if (!visited[next]) {
                queue.add(next)
                answer[next] = answer[cur] + 1
                visited[next] = true
            }
        }
    }
    return answer
}