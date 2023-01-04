import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    var bw = BufferedWriter(OutputStreamWriter(System.out))
    val n = br.readLine().toInt()
    var dp = IntArray(301)
    var scoreArr = IntArray(10001)

    for (i in 1..n) {
        val score = br.readLine().toInt()
        scoreArr[i] = score
    }

    dp[1] = scoreArr[1]
    dp[2] = Math.max(scoreArr[1] + scoreArr[2], scoreArr[2])
    dp[3] = Math.max(scoreArr[1] + scoreArr[3], scoreArr[2] + scoreArr[3])

    for (i in 4..n) {
        dp[i] = Math.max(dp[i - 3] + scoreArr[i - 1] + scoreArr[i], dp[i - 2] + scoreArr[i])
    }
    bw.write(dp[n].toString())
    bw.flush()
}