import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.StringTokenizer

private var dp = Array(30, { IntArray(30) })

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val t = br.readLine().toInt()

    var n = 0
    var m = 0

    val arr = IntArray(t);
    for (i in 0 until t) {
        val token = StringTokenizer(br.readLine(), " ")
        n = token.nextToken().toInt()
        m = token.nextToken().toInt()
//        arr[i] = sol1(m,n)
        arr[i] = sol2(m, n)
    }
    for (i in arr.indices) {
        println(arr[i])
    }
}

// Sol 1 . 재귀 활용
//fun sol1(n: Int, r: Int): Int {
//    if (dp[n][r] > 0) {
//        return dp[n][r]
//    }
//    if (n == r || r == 0) {
//        dp[n][r] = 1
//        return dp[n][r]
//    }
//    dp[n][r] = combination(n - 1, r - 1) + combination(n - 1, r)
//    return dp[n][r]
//}

// Sol 2. 반복문 활용
fun sol2(m: Int, n: Int): Int {
    for(i in 0 .. m){
        dp[i][i] = 1
        dp[i][0] = 1
    }

    for (i in 2..m) {
        for (j in 1..n) {
            dp[i][j] = dp[i - 1][j - 1] + dp[i - 1][j]
        }
    }
    return dp[m][n]
}

