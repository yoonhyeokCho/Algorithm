import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.LinkedList
import java.util.Queue
import java.util.StringTokenizer

private val br = BufferedReader(InputStreamReader(System.`in`))
private val bw = BufferedWriter(OutputStreamWriter(System.out))
private var n = 0
private var m = 0
private lateinit var arr: Array<IntArray>
private lateinit var queue: Queue<Dot>

data class Dot(var row: Int, var col: Int)

fun main() {
    var token = StringTokenizer(br.readLine(), " ")
    m = token.nextToken().toInt()
    n = token.nextToken().toInt()

    arr = Array(n + 1, { IntArray(m + 1) })
    queue = LinkedList()
    for (i in 0 until n) {
        token = StringTokenizer(br.readLine(), " ")
        for (j in 0 until m) {
            arr[i][j] = token.nextToken().toInt()
            if (arr[i][j] == 1) {
                queue.add(Dot(i, j))
            }
        }
    }

    bfs()
    bw.flush()
    bw.close()

}

private fun bfs() {
    val drow = arrayOf(1, 0, -1, 0)
    val dcol = arrayOf(0, 1, 0, -1)

    while (queue.size != 0) {
        var dot = queue.poll()

        for (i in 0 until 4) {
            var nextRow = dot.row + drow[i]
            var nextCol = dot.col + dcol[i]

            if (0 <= nextCol && m > nextCol && 0 <= nextRow && n > nextRow) {
                if (arr[nextRow][nextCol] == 0) {
                    arr[nextRow][nextCol] = arr[dot.row][dot.col] + 1
                    queue.add(Dot(nextRow, nextCol))
                }
            }
        }
    }

    var answer = -1

    for (i in 0 until n) {
        for (j in 0 until m) {
            if (arr[i][j] == 0) {
                bw.write("-1")
                return
            } else if (answer < arr[i][j]) {
                answer = arr[i][j]
            }
        }
    }
    if (answer == 1) {
        bw.write("0")
        return
    } else {
        bw.write((answer - 1).toString())
        return
    }

}
