import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.LinkedList
import java.util.Queue
import java.util.StringTokenizer

private lateinit var arr: Array<CharArray>
private lateinit var visited: Array<BooleanArray>
private val br = BufferedReader(InputStreamReader(System.`in`))
private val bw = BufferedWriter(OutputStreamWriter(System.out))
private var n = 0
private lateinit var eachArea: ArrayList<Int>
private var countArea = 0

private val drow = arrayOf(1, 0, -1, 0)
private val dcol = arrayOf(0, 1, 0, -1)

data class Dot(var row: Int, var col: Int)

fun main() {
    val token = StringTokenizer(br.readLine(), " ")
    n = token.nextToken().toInt()

    arr = Array(n + 1, { CharArray(n + 1) })
    visited = Array(n + 1, { BooleanArray(n + 1) })
    eachArea = arrayListOf()
    for (i in 0 until n) {
        val token = br.readLine().toCharArray()
        for (j in 0 until n) {

            arr[i][j] = token[j]
        }
    }

    for (i in 0 until n) {
        for (j in 0 until n) {
            if (arr[i][j] == '1' && !visited[i][j]) {
                //eachArea.add(1)
                //dfs(i,j)
                eachArea.add(0)
                bfs(i, j)
                countArea++
            }
        }
    }
    bw.write(countArea.toString() + "\n")
    eachArea.sort()
    for (i in 0 until countArea) {
        bw.write(eachArea[i].toString() + "\n")
    }
    bw.flush()
    bw.close()
}

//private fun dfs(row: Int, col: Int) {
//    visited[row][col] = true;
//    for (i in 0 until 4) {
//        val nextRow = row + drow[i]
//        val nextCol = col + dcol[i]
//
//        if (0 <= nextCol && n > nextCol && 0 <= nextRow && n > nextRow) {
//            if (arr[nextRow][nextCol] == '1' && !visited[nextRow][nextCol]) {
//                eachArea[countArea]++
//                visited[nextRow][nextCol] = true
//                dfs(nextRow, nextCol)
//            }
//        }
//    }
//
//}

private fun bfs(row: Int, col: Int) {
    var drow = arrayOf(1, 0, -1, 0) //반시계
    var dcol = arrayOf(0, 1, 0, -1)

    var queue: Queue<Dot> = LinkedList()

    visited[row][col] = true
    queue.add(Dot(row, col))
    eachArea[countArea]++

    while (queue.size != 0) {
        var dot = queue.poll()

        for (i in 0 until 4) {
            var nextRow = dot.row + drow[i]
            var nextCol = dot.col + dcol[i]

            if (0 <= nextCol && n > nextCol && 0 <= nextRow && n > nextRow) {
                if (arr[nextRow][nextCol] == '1' && !visited[nextRow][nextCol]) {
                    visited[nextRow][nextCol] = true
                    queue.add(Dot(nextRow, nextCol))
                    eachArea[countArea]++
                }
            }
        }
    }

}
