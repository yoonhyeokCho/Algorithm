import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.StringTokenizer

private val br = BufferedReader(InputStreamReader(System.`in`))
private val bw = BufferedWriter(OutputStreamWriter(System.out))

data class plan(val time: Int, val pay: Int)

private lateinit var arr: Array<plan>

private var max = 0
private var N = 0

fun main() {
    N = br.readLine().toInt()
    arr = Array(N + 1, { plan(0, 0) })

    for (i in 1..N) {
        val token = StringTokenizer(br.readLine(), " ")
        arr[i] = plan(token.nextToken().toInt(), token.nextToken().toInt())
    }

    max = 0

    for (i in 1..N) {
        if (i + arr[i].time <= N + 1) {
            solution(i, arr[i].pay)
        }
    }
    bw.write(max.toString())
    bw.flush()
    bw.close()
}   

private fun solution(selected: Int, total: Int) {

    if (total >= max) {
        max = total
    }

    var start = selected + arr[selected].time
    for (i in start..N) {
        if (i + arr[i].time <= N + 1) {
            solution(i, total + arr[i].pay)
        }
    }
}