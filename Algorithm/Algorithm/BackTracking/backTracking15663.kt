import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.StringTokenizer

private lateinit var arr: IntArray
private lateinit var answer: IntArray
private lateinit var visited: BooleanArray
private val br = BufferedReader(InputStreamReader(System.`in`))
private val bw = BufferedWriter(OutputStreamWriter(System.out))
private var n = 0
private var m = 0
fun main() {
    var token = StringTokenizer(br.readLine(), " ")
    n = token.nextToken().toInt()
    m = token.nextToken().toInt()

    arr = IntArray(n + 1)
    visited = BooleanArray(n + 1)
    answer = IntArray(m + 1)
    token = StringTokenizer(br.readLine(), " ")
    for (i in 0 until n) {
        arr[i] = token.nextToken().toInt()
    }

    arr.sort()
    dfs(0)
    bw.flush()
    bw.close()
}

private fun dfs(depth: Int) {

    if (depth == m) {
        for (i in 0 until m) {
            bw.write(answer[i].toString() + " " )
        }
        bw.write("\n")
        return
    }
    var check =0
    for (i in 1..n) {

        if(!visited[i] && check != arr[i]){
            check = arr[i]
            visited[i] = true
            answer[depth] = arr[i]
            dfs(depth + 1)
            visited[i] = false
        }
    }
}
