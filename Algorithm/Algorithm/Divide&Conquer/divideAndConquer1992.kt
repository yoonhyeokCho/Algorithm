import java.io.BufferedReader
import java.io.InputStreamReader

private lateinit var arr : Array<CharArray>
fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val n = br.readLine().toInt()
    arr = Array(n,{ CharArray(n) })
    for (i in 0 until n) {
        val token = br.readLine().toCharArray()
        for (j in 0 until n) {
            arr[i][j] = token[j]
        }
    }
    recur(0,0,n)
}

fun recur(row: Int, col: Int, size: Int) {

    var check = true
    for (i in row until row + size) {
        for (j in col until col + size) {
            if (arr[i][j] != arr[row][col]){
                check = false
            }
        }
    }

    if(check){
        print(arr[row][col])
        return
    }
    var newSize = size / 2
    print("(")
    recur(row, col, newSize)
    recur(row, col + newSize, newSize)
    recur(row + newSize, col, newSize)
    recur(row + newSize, col + newSize, newSize)
    print(")")
}