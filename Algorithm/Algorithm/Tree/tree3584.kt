import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.*
import kotlin.collections.ArrayList

private val br = BufferedReader(InputStreamReader(System.`in`))
private val bw = BufferedWriter(OutputStreamWriter(System.out))
private var n = 0
private var t = 0
private lateinit var arr: Array<LinkedList<Int>>
private lateinit var parent: IntArray

fun main() {
    t = br.readLine().toInt()

    for (i in 0 until t) {
        n = br.readLine().toInt()
        arr = Array(n+1){LinkedList<Int>()}
        parent = IntArray(n + 1)
        for (j in 0 until n - 1) {
            val token = StringTokenizer(br.readLine(), " ")
            val a = token.nextToken().toInt()
            val b = token.nextToken().toInt()

            parent[b] = a
            arr[a].add(b)
        }
        val token = StringTokenizer(br.readLine(), " ")
        val firstNode = token.nextToken().toInt()
        val secondNode = token.nextToken().toInt()

        val firstNode_depth = getDepth(firstNode)
        val secondNode_depth = getDepth(secondNode)
        LCA(firstNode, firstNode_depth, secondNode, secondNode_depth)
    }

    bw.flush()
    bw.close()
}

private fun getDepth(node: Int): Int {
    var count = 0
    var cur = node
    while (cur != 0) {
        count++
        cur = parent[cur]
    }

    return count - 1
}

private fun LCA(firstNode: Int, firstNode_depth: Int, secondNode: Int, secondNode_depth: Int) {
    var x = firstNode
    var x_depth = firstNode_depth
    var y = secondNode
    var y_depth = secondNode_depth
    if (x_depth> y_depth) {
        while (x_depth != y_depth) {
            x_depth --
            x = parent[x]
        }
    }else if (x_depth < y_depth) {
        while (x_depth != y_depth) {
            y_depth--;
            y = parent[y];
        }
    }
    while (x != y) {
        x = parent[x];
        y = parent[y];
    }

    bw.write(x.toString()+"\n")
}