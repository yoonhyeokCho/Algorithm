import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

private val br = BufferedReader(InputStreamReader(System.`in`))
private val bw = BufferedWriter(OutputStreamWriter(System.out))
private lateinit var arr: Array<CharArray>
fun main() {
    val n = br.readLine().toInt()
    arr = Array(n, { CharArray(n) })
    recur(n, 0, 0, false)
    for(i in 0 until n ){
        for(j in 0 until n ){
            bw.write(arr[i][j].toString())
        }
        bw.write("\n")
    }
    bw.flush()
    bw.close()
}

fun recur(n: Int, row: Int, col: Int, check: Boolean) {
    if (check) {
        for (i in row until row + n) {
            for (j in col until col + n){
                arr[i][j] = ' '
            }
        }
        return
    }
    if(n == 1){
        arr[row][col] = '*'
        return
    }

    val newSize = n / 3
    var count = 0
    for (i in row until row + n step (newSize)) {
        for (j in col until col + n step (newSize)) {
            count++
            if (count == 5) {
                recur(newSize, i, j, true)
            } else {
                recur(newSize, i, j, false)
            }
        }
    }

}