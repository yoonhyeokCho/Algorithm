import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.StringTokenizer

private lateinit var arr: IntArray
private lateinit var answer:Array<StringBuffer>


fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    var bw = BufferedWriter(OutputStreamWriter(System.out))
    val k = br.readLine().toInt()

    val sumOfnode = (Math.pow(2.0, k.toDouble()) - 1).toInt()
    arr = IntArray(sumOfnode)
    answer = Array(k,{StringBuffer(k)})

    val token = StringTokenizer(br.readLine(), " ")

    for (i in 0 until sumOfnode) {
        arr[i] = token.nextToken().toInt()
    }
    makeTree(0, 0, sumOfnode)

    for (i in 0 until k) {
        bw.write(answer[i].toString() + "\n")

    }
    bw.flush()
}

fun makeTree(depth: Int, start: Int, end: Int) {
    if (start == end) {
        return
    }
    val mid = (start + end) / 2
    answer[depth].append(arr[mid])
    answer[depth].append(" ")

    makeTree(depth + 1, start, mid)
    makeTree(depth + 1, mid + 1, end)

}

