import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.StringTokenizer

private val br = BufferedReader(InputStreamReader(System.`in`))
private val bw = BufferedWriter(OutputStreamWriter(System.out))
private lateinit var arr: Array<IntArray>
private var N = 0

fun main() {
    N = br.readLine().toInt()
    arr = Array(N, { IntArray(N) })
    for (i in 0 until N) {
        val token = StringTokenizer(br.readLine(), " ")
        for (j in 0 until N) {
            arr[i][j] = token.nextToken().toInt()
        }
    }
    solution()
}

private fun solution() {
    var dp = Array(N, { LongArray(N) })
    dp[0][0] = 1

    for (i in 0 until N) {
        for (j in 0 until N) {
            if (i == N - 1 && j == N - 1) continue
            val nextRow = i + arr[i][j]
            val nextCol = j + arr[i][j]

            if (nextRow < N) {
                dp[nextRow][j] += dp[i][j]
            }
            if (nextCol < N) {
                dp[i][nextCol] += dp[i][j]
            }
        }
    }
    bw.write(dp[N-1][N-1].toString())
    bw.flush()
    bw.close()
}