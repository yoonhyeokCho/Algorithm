import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.StringTokenizer

private val br = BufferedReader(InputStreamReader(System.`in`))
private val bw = BufferedWriter(OutputStreamWriter(System.out))

private lateinit var arr: Array<IntArray>
private lateinit var dp: Array<IntArray>
private var N = 0
private var M = 0
private var K = 0

private lateinit var range: Array<ArrayList<Int>>

fun main() {
    var token = StringTokenizer(br.readLine(), " ")
    N = token.nextToken().toInt()
    M = token.nextToken().toInt()
    arr = Array(N + 1, { IntArray(M + 1) })
    dp = Array(N + 1, { IntArray(M + 1) })
    for (i in 1..N) {
        token = StringTokenizer(br.readLine(), " ")
        for (j in 1..M) {
            arr[i][j] = token.nextToken().toInt()
            dp[i][j] = dp[i - 1][j] + dp[i][j - 1] + arr[i][j] - dp[i - 1][j - 1]
        }
    }
    K = br.readLine().toInt()
    range = Array(K, { ArrayList() })
    for (i in 0 until K) {
        token = StringTokenizer(br.readLine(), " ")
        for (j in 0 until 4) {
            range[i].add(token.nextToken().toInt())
        }
        bw.write(solution(range[i][0], range[i][1], range[i][2], range[i][3]).toString())
        bw.write("\n")
    }
    bw.flush()
    bw.close()
}

private fun solution(x1: Int, y1: Int, x2: Int, y2: Int): Int {
    var answer = dp[x2][y2] - dp[x2][y1 - 1] - dp[x1 - 1][y2] + dp[x1 - 1][y1 - 1]
    return answer
}


//시간 초과
//private fun solution(x1: Int, y1: Int, x2: Int, y2: Int):Int{
//    var sum = 0
//    val rRange = x2-x1+1
//    val cRange = y2-y1+1
//    for(i in 0 until rRange ){
//        for(j in 0 until cRange){
//            sum += arr[x1+i][y1+j]
//        }
//    }
//    return sum
//}
