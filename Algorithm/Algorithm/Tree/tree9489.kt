import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.StringTokenizer

private val br = BufferedReader(InputStreamReader(System.`in`))
private val bw = BufferedWriter(OutputStreamWriter(System.out))
private lateinit var arr: IntArray
private lateinit var parent: IntArray
private var n = 0
private var k = 0
private var kIndex = 0


fun main() {
    bw.flush()
    while (true) {
        var token = StringTokenizer(br.readLine(), " ")
        n = token.nextToken().toInt()
        k = token.nextToken().toInt()
        if (n == 0) break

        arr = IntArray(n + 1)
        parent = IntArray(n + 1)
        token = StringTokenizer(br.readLine(), " ")
        for (i in 0 until n) {
            arr[i] = token.nextToken().toInt()
            if (arr[i] == k) {
                kIndex = i
            }
        }
        bw.write(findCousion().toString()+"\n")
        bw.flush()
    }
    bw.close()
}

fun findCousion():Int {
    var count = 0
    var pIndex = 0
    var pKIndex = 0
    parent[0] = -1

    for (i in 1 until n) {
        parent[i] = pIndex
        if (i < n && (arr[i] + 1 != arr[i + 1]))
            pIndex++
    }
    pKIndex = parent[kIndex]
    for (i in 1 until n) {
        pIndex = parent[i]
        if (parent[pIndex] == parent[pKIndex] && pIndex !=pKIndex)
            count++
    }

    return count
}
