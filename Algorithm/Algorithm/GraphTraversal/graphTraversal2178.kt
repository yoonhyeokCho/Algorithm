import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.*
import kotlin.collections.ArrayList

private lateinit var arr: Array<CharArray>
private val br = BufferedReader(InputStreamReader(System.`in`))
private val bw = BufferedWriter(OutputStreamWriter(System.out))
private lateinit var visited: Array<BooleanArray>
private lateinit var answer: Array<IntArray>
private var n = 0
private var m = 0


data class Dot(var row: Int, var col: Int)

fun main() {

    val token = StringTokenizer(br.readLine(), " ")
    n = token.nextToken().toInt()
    m = token.nextToken().toInt()
    answer = Array(n+2,{ IntArray(m+2,{1}) })
    arr = Array(n + 2, { CharArray(m + 2) })
    visited = Array(n+2,{ BooleanArray(m+2) })

    for (i in 0 until n) {
        val token = br.readLine().toCharArray()
        for (j in 0 until m) {
            arr[i][j] = token[j]
        }
    }

    bfs(0,0)
    bw.write(answer[n-1][m-1].toString())
    bw.flush()
    bw.close()
//    dfs(1, 1, 1)
//    bw.write(answer.toString())
//    bw.flush()
//    bw.close()
}

private fun bfs(row: Int, col: Int) {

    var drow = arrayOf(1,0,-1,0)
    var dcol = arrayOf(0,1,0,-1)
    
    var queue: Queue<Dot> = LinkedList()

    visited[row][col] = true
    queue.add(Dot(row, col))

    while (queue.size != 0) {
        var dot = queue.poll()
        var newRow = dot.row
        var newCol = dot.col

        for (i in 0 until 4) {
            var nextRow = newRow + drow[i]
            var nextCol = newCol + dcol[i]

            if (0 <= nextCol && m > nextCol && 0 <= nextRow && n > nextRow){

                if(arr[nextRow][nextCol] == '1' && !visited[nextRow][nextCol]){
                    answer[nextRow][nextCol] = answer[newRow][newCol] + 1
                    visited[nextRow][nextCol] = true
                    queue.add(Dot(nextRow,nextCol))
                }
            }
        }
    }
}


//private fun dfs(row: Int, col: Int, count: Int) {
//
//    if (row == n && col == m) {
//        if (answer > count)
//            answer = count
//
//        return
//    }
//    arr[row][col] = '0'
//    if (arr[row - 1][col] == '1' && (row > 1)) {  //위쪽
//        dfs(row - 1, col, count + 1)
//
//    }
//    if (arr[row + 1][col] == '1' && (row < n)) { //아래쪽
//        dfs(row + 1, col, count + 1)
//    }
//    if (arr[row][col - 1] == '1' && (col > 1)) { //왼쪽
//        dfs(row, col-1,count + 1)
//
//    }
//    if (arr[row][col + 1] == '1' && (col < m)) { //오른쪽
//        dfs(row, col + 1, count + 1)
//
//    }
//    arr[row][col] = '1'
//}




