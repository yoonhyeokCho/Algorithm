import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.*

private val br = BufferedReader(InputStreamReader(System.`in`))
private val bw = BufferedWriter(OutputStreamWriter(System.out))

private var N = 0
private lateinit var arr: Array<LinkedList<Int>>

fun main() {
    N = br.readLine().toInt()
    arr = Array(N + 1, { LinkedList<Int>() })

    var a = 0
    var b = 0
    for (i in 0 until N - 1) {
        val token = StringTokenizer(br.readLine(), " ")
        a = token.nextToken().toInt()
        b = token.nextToken().toInt()

        arr[a].add(b)
        arr[b].add(a)
    }
    val q = br.readLine().toInt()
    var t = 0
    var k = 0
    for (i in 0 until q) {
        val token = StringTokenizer(br.readLine(), " ")
        t = token.nextToken().toInt()
        k = token.nextToken().toInt()
        solution(t, k)
    }
    bw.flush()
    bw.close()
}

private fun solution(t: Int, k: Int) {
    if (t == 1) {
        if (arr[k].size <= 1 ) {
            bw.write("no\n")
        } else {
            bw.write("yes\n")
        }
    } else {
        bw.write("yes\n")
    }
}