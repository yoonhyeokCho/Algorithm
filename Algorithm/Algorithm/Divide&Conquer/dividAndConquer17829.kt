import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*

private var arr = Array(1024, { IntArray(1024) })

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))


    val n = br.readLine().toInt()
    for (i in 0 until n) {
        val token = StringTokenizer(br.readLine(), " ")
        for (j in 0 until n) {
            arr[i][j] = token.nextToken().toInt()
        }
    }
    println(mergeSort(0, 0, n))
}

fun mergeSort(row: Int, col: Int, size: Int): Int {
    if (size == 2) {
        var partitionArr = IntArray(4)
        var index = 0

        for (i in row until row + size) {
            for (j in col until col + size) {
                partitionArr[index++] = arr[i][j]
            }
        }

        partitionArr.sort()
        return partitionArr[2]
    }else{
        var newSize = size / 2

        var answerArr = IntArray(4)

        answerArr[0] = mergeSort(row, col, newSize)
        answerArr[1]= mergeSort(row, col + newSize, newSize)
        answerArr[2]= mergeSort(row + newSize, col, newSize)
        answerArr[3]= mergeSort(row + newSize, col + newSize, newSize)


        answerArr.sort()
        return answerArr[2]
    }
}