import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

private val br = BufferedReader(InputStreamReader(System.`in`))
private val bw = BufferedWriter(OutputStreamWriter(System.out))
private lateinit var arr: CharArray

fun main() {
    var T = br.readLine().toInt()

    for (i in 0 until T) {
        val token = br.readLine().toCharArray()
        arr = CharArray(token.size)

        if ((arr.size % 2) == 0) {
            bw.write("NO")
            bw.write("\n")
            continue
        }
        for (j in 0 until token.size) {
            arr[j] = token[j]
        }
        if (solution(0, arr.size - 1)) {
            bw.write("YES")
            bw.write("\n")
        } else {
            bw.write("NO")
            bw.write("\n")
        }
    }
    bw.flush()
    bw.close()
}

private fun solution(start: Int, end: Int): Boolean {
    var l = start
    var r = end
    if (start >= end) {
        return true
    }

    while (l < r) {
        if (arr[l] == arr[r]) {
            return false
        }
        l++
        r--
    }
    return solution(start, r - 1)
}