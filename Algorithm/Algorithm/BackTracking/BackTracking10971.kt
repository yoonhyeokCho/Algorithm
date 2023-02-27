import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.StringTokenizer

private val br = BufferedReader(InputStreamReader(System.`in`))
private val bw = BufferedWriter(OutputStreamWriter(System.out))
private lateinit var arr: Array<IntArray>
private lateinit var visited: BooleanArray
private var N = 0
private var cnt = 1
private var min = Int.MAX_VALUE
fun main() {
    N = br.readLine().toInt()
    arr = Array(N, { IntArray(N) })
    visited = BooleanArray(N)

    for (i in 0 until N) {
        val token = StringTokenizer(br.readLine(), " ")
        for (j in 0 until N) {
            arr[i][j] = token.nextToken().toInt()
        }
    }
    visited[0] = true
    solution(0, 0, 0)
    bw.write(min.toString())
    bw.flush()
    bw.close()
}

private fun solution(start: Int, cur: Int, total: Int) {
    if (cnt == N && arr[cur][start] != 0) {
        min = Math.min(min, total + arr[cur][start])
        return
    }
    for (i in 0 until N) {
        if (!visited[i] && arr[cur][i] != 0) {
            if (total + arr[cur][i] < min) {
                visited[i] = true
                cnt++
                val sum = total + arr[cur][i]
                solution(start, i, sum)
                cnt--
                visited[i] = false
            }
        }
    }
}