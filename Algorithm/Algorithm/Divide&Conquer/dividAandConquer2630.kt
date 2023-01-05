import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.StringTokenizer

private var arr = Array(128, { IntArray(128) })
private var white = 0
private var blue = 0

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    var bw = BufferedWriter(OutputStreamWriter(System.out))
    val n = br.readLine().toInt()

    for (i in 0 until n) {
        val token = StringTokenizer(br.readLine(), " ")
        for (j in 0 until n) {
            arr[i][j] = token.nextToken().toInt()
        }
    }
    MergeSort(0, 0, n)

    bw.write(white.toString())
    bw.write("\n")
    bw.write(blue.toString())
    bw.flush()
}

fun MergeSort(row: Int, col: Int, size: Int) {

    var check = true
    for (i in row until row + size) {
        if (check) {
            for (j in col until col + size) {
                if (arr[i][j] != arr[row][col]) {
                    check = false
                    break
                }
            }
        } else {
            break
        }
    }
    if (check) {
        if (arr[row][col] == 1) {
            blue++
        } else {
            white++
        }
        return
    }

    var newsize = size / 2

    MergeSort(row, col, newsize)
    MergeSort(row, col + newsize, newsize)
    MergeSort(row + newsize, col, newsize)
    MergeSort(row + newsize, col + newsize, newsize)
}
