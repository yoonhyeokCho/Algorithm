import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.StringTokenizer

private val br = BufferedReader(InputStreamReader(System.`in`))
private val bw = BufferedWriter(OutputStreamWriter(System.out))
private lateinit var arr: Array<IntArray>
private lateinit var visited: Array<BooleanArray>
private var N = 0
private var M = 0
private var ans = 0

fun main() {
    var token = StringTokenizer(br.readLine(), " ")
    N = token.nextToken().toInt()
    M = token.nextToken().toInt()

    arr = Array(N, { IntArray(M) })
    visited = Array(N, { BooleanArray(M) })

    for (i in 0 until N) {
        token = StringTokenizer(br.readLine(), " ")
        for (j in 0 until M) {
            arr[i][j] = token.nextToken().toInt()
        }
    }

    solution(0,0,0)
    bw.write(ans.toString())
    bw.flush()
    bw.close()
}

private fun solution(row: Int, col: Int, total: Int) {
    var curRow = row
    var curCol = col

    if (col == M) {
        curCol = 0
        curRow = row + 1
    }
    if (curRow == N) {
        ans = Math.max(ans, total)
        return
    }

    val double_degree = arr[curRow][curCol] * 2

    if (!visited[curRow][curCol]) {
        //ㄱ
        if (curCol - 1 >= 0 && !visited[curRow][curCol - 1] &&
            curRow + 1 < N && !visited[curRow + 1][curCol]
        ) {
            visited[curRow][curCol] = true
            visited[curRow][curCol - 1] = true
            visited[curRow + 1][curCol] = true
            val sum = total + arr[curRow][curCol - 1] + arr[curRow + 1][curCol] + double_degree
            solution(curRow, curCol + 1, sum)
            visited[curRow][curCol] = false
            visited[curRow][curCol - 1] = false
            visited[curRow + 1][curCol] = false
        }
        //ㄴ
        if (curCol - 1 >= 0 && !visited[curRow][curCol - 1] &&
            curRow - 1 >= 0 && !visited[curRow - 1][curCol]
        ) {
            visited[curRow][curCol] = true
            visited[curRow][curCol - 1] = true
            visited[curRow - 1][curCol] = true
            val sum = total + arr[curRow][curCol - 1] + arr[curRow - 1][curCol] + double_degree
            solution(curRow, curCol + 1, sum)
            visited[curRow][curCol] = false
            visited[curRow][curCol - 1] = false
            visited[curRow - 1][curCol] = false
        }
        // ㅣ-
        if (curRow + 1 < N && !visited[curRow + 1][curCol] &&
            curCol + 1 < M && !visited[curRow][curCol + 1]
        ) {
            visited[curRow][curCol] = true
            visited[curRow + 1][curCol] = true
            visited[curRow][curCol + 1] = true
            val sum = total + arr[curRow + 1][curCol] + arr[curRow][curCol + 1] + double_degree
            solution(curRow, curCol + 1, sum)
            visited[curRow][curCol] = false
            visited[curRow + 1][curCol] = false
            visited[curRow][curCol + 1] = false
        }

        // ㅣ_
        if (curRow - 1 >= 0 && !visited[curRow - 1][curCol] &&
            curCol + 1 < M && !visited[curRow][curCol + 1]
        ) {
            visited[curRow][curCol] = true
            visited[curRow - 1][curCol] = true
            visited[curRow][curCol + 1] = true
            val sum = total + arr[curRow - 1][curCol] + arr[curRow][curCol + 1] + double_degree
            solution(curRow, curCol + 1, sum)
            visited[curRow][curCol] = false
            visited[curRow - 1][curCol] = false
            visited[curRow][curCol + 1] = false
        }
    }

    solution(curRow, curCol + 1, total)

}