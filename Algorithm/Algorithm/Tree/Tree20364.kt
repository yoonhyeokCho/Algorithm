import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.StringTokenizer

private val br = BufferedReader(InputStreamReader(System.`in`))
private val bw = BufferedWriter(OutputStreamWriter(System.out))

private lateinit var arr: IntArray
private lateinit var visited: BooleanArray
private var N = 0
private var Q = 0

fun main() {
    val token = StringTokenizer(br.readLine(), " ")
    N = token.nextToken().toInt()
    Q = token.nextToken().toInt()

    arr = IntArray(Q)
    visited = BooleanArray(N + 1)

    for (i in 0 until Q) {
        arr[i] = br.readLine().toInt()
        val cur = arr[i]
        var ans = 0
        var next = cur
        while (next != 1) {
            if (visited[next]) {
                ans = next
            }
            next = next / 2
        }
        visited[cur] = true
        bw.write(ans.toString()+"\n")
    }
    bw.flush()
    bw.close()
}