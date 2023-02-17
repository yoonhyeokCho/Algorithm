import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.StringTokenizer

private val br = BufferedReader(InputStreamReader(System.`in`))
private val bw = BufferedWriter(OutputStreamWriter(System.out))
private var N = 0
private lateinit var dist: LongArray
private lateinit var price: LongArray
fun main() {
    N = br.readLine().toInt()
    dist = LongArray(N - 1)
    price = LongArray(N)
    var token = StringTokenizer(br.readLine(), " ")
    for (i in 0 until N - 1) {
        dist[i] = token.nextToken().toLong()
    }
    token = StringTokenizer(br.readLine(), " ")
    for (i in 0 until N) {
        price[i] = token.nextToken().toLong()
    }

    solution()
}

private fun solution() {
    var total: Long = 0
    for (i in 0 until N - 1) {
        if (price[i] < price[i + 1]) {
            price[i + 1] = price[i]
        }
    }

    for (i in 0 until N - 1) {
        total += price[i] * dist[i]
    }

    bw.write(total.toString())
    bw.flush()
    bw.close()
}
