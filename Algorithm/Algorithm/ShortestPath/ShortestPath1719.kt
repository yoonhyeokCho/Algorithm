import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.*

private val br = BufferedReader(InputStreamReader(System.`in`))
private val bw = BufferedWriter(OutputStreamWriter(System.out))
private var n = 0
private var m = 0
private lateinit var arr: Array<IntArray>
private lateinit var point: Array<IntArray>
private val MAX = 200 * 10000

fun main() {
    var token = StringTokenizer(br.readLine(), " ")
    n = token.nextToken().toInt()
    m = token.nextToken().toInt()
    arr = Array(n + 1, { IntArray(n + 1) })

    for (i in 1..n) {
        for (j in 1..n) {
            arr[i][j] = MAX
        }
    }

    var a = 0
    var b = 0
    var c = 0
    for (i in 0 until m) {
        token = StringTokenizer(br.readLine(), " ")
        a = token.nextToken().toInt()
        b = token.nextToken().toInt()
        c = token.nextToken().toInt()

        arr[a][b] = c
        arr[b][a] = c
    }

    point = Array(n + 1, { IntArray(n + 1) })
    for (i in 1..n) {
        for (j in 1..n) {
            point[i][j] = j
        }
    }

    for (k in 1..n) {
        for (i in 1..n) {
            for (j in 1..n) {
                if (arr[i][j] > arr[i][k] + arr[k][j]) {
                    arr[i][j] = arr[i][k] + arr[k][j]
                    point[i][j] = point[i][k]
                }
            }
        }
    }

    var sb = StringBuilder();
    for (i in 1..n) {
        for (j in 1..n) {
            if (i == j) {
                sb.append('-').append(' ');
                continue;
            }
            sb.append(point[i][j]).append(' ');
        }
        sb.append('\n');
    }
    bw.write(sb.toString());
    bw.flush()
    bw.close()
}
