import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.StringTokenizer

private var br = BufferedReader(InputStreamReader(System.`in`))
private val bw = BufferedWriter(OutputStreamWriter(System.out))
private var N = 0
private lateinit var arr: DoubleArray

fun main() {
    N = br.readLine().toInt()
    arr = DoubleArray(N)

    val token = StringTokenizer(br.readLine(), " ")
    for (i in 0 until N) {
        arr[i] = token.nextToken().toDouble()
    }
    arr.sort()

    for (i in 0 until N - 1) {
        arr[N - 1] += arr[i] / 2
    }
    var sb = StringBuilder()
    sb.append(arr[N - 1])
    var divide = sb.split(".")
    if (divide[1].equals("0")) {
        println(arr[N - 1].toInt())
    } else {
        println(arr[N - 1])
    }
}