import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

private val br = BufferedReader(InputStreamReader(System.`in`))
private val bw = BufferedWriter(OutputStreamWriter(System.out))

fun main() {
    var dp = Array(65, { LongArray(10) })
    var answer:Long = 0

    var T = br.readLine().toInt()

    dp[0][0] = 1
    for (i in 0..9) {
        dp[1][i] = 1
    }

    val seleted = IntArray(T)
    for (i in 0 until T) {
        seleted[i] = br.readLine().toInt()
    }

    seleted.max()
    val max = seleted.max()
    for (i in 2 until max) {
        for (j in 0..9) {
            if (j == 0) {
                dp[i][j] = 1
                continue
            }
            dp[i][j] = dp[i][j - 1] + dp[i - 1][j]
        }
    }

    for (i in 0 until T) {
        val seletedNum = seleted[i]
        for (j in 0..9) {
            if (j == 0) {
                dp[seletedNum][j] = 1
                answer = dp[seletedNum][j]
                continue
            }
            dp[seletedNum][j] = dp[seletedNum][j - 1] + dp[seletedNum - 1][j]
            answer += dp[seletedNum][j]
        }
        bw.write(answer.toString() + "\n")
        answer = 0
    }

    bw.flush()
    bw.close()
}