import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.StringTokenizer


private var r = 0
private var c = 0
fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val token = StringTokenizer(br.readLine(), " ")
    var n = token.nextToken().toInt()
    r = token.nextToken().toInt()
    c = token.nextToken().toInt()

    var arrSize = Math.pow(2.0, n.toDouble()).toInt()

    recur(0, 0, arrSize, 0)
}

private fun recur(row: Int, col: Int, size: Int, cnt: Int) {

    var answer = cnt
    if (size == 2) {
        for (i in row until row + size) {
            for (j in col until col + size) {
                if (i == r && j == c) {
                    println(answer)
                    return
                }
                answer++
            }
        }

    } else {
        val newSize = size / 2
        if (row <= r && r < row + newSize && col <= c && c < col + newSize) {
            recur(row, col, newSize, answer)
        } else if (row <= r && r < row + newSize && col + newSize <= c && c < col + size) {
            recur(row, col + newSize, newSize, answer + newSize * newSize)
        } else if (row + newSize <= r && r < row + size && col <= c && c < col + newSize) {
            recur(row + newSize, col, newSize, answer + newSize * newSize * 2)
        } else {
            recur(row + newSize, col + newSize, newSize, answer + newSize * newSize * 3)
        }
    }
}