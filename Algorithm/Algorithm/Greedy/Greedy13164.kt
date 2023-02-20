import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.StringTokenizer

private val br = BufferedReader(InputStreamReader(System.`in`))
private val bw = BufferedWriter(OutputStreamWriter(System.out))
private var N = 0
private var K = 0

private lateinit var arr: IntArray
fun main() {
    var token = StringTokenizer(br.readLine(), " ")
    N = token.nextToken().toInt()
    K = token.nextToken().toInt()

    arr = IntArray(N)

    token = StringTokenizer(br.readLine(), " ")
    for (i in 0 until N) {
        arr[i] = token.nextToken().toInt()
    }
    bw.write(solution().toString())
    bw.flush()
    bw.close()
}

private fun solution(): Int {
    var result = 0
    val GroupCount = N - K
    var sub = IntArray(N - 1)

    for (i in 0 until N - 1) {
        val temp = arr[i + 1] - arr[i]
        sub[i] = temp
    }
    sub.sort()

    for (i in 0 until GroupCount) {
        result += sub[i]
    }
    return result
}
