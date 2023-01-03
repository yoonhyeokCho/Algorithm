import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.Collections.min

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val n = br.readLine().toInt()

    val dp = IntArray(1001)
    dp[0] = 0
    dp[1] = 1
    dp[2] = 2
    for (i in 3..n) {
        if (dp[i - 1] + 1 <= dp[i - 3] + 1) {
            dp[i] = dp[i - 1] + 1
        } else {
            dp[i] = dp[i - 3] + 1
        }
    }

    if (dp[n] % 2 == 0) {
        println("CY")
    } else {
        println("SK")
    }

}