import org.w3c.dom.Node
import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.LinkedList
import java.util.StringTokenizer

private val br = BufferedReader(InputStreamReader(System.`in`))
private val bw = BufferedWriter(OutputStreamWriter(System.out))
private var n = 0
private var r = 0
private var pole_length = 0
private var max_length = 0
private var gigaNode = 0
private lateinit var arr: Array<ArrayList<TreeNode>>
private lateinit var visited: BooleanArray

data class TreeNode(var num: Int, var cost: Int)

fun main() {
    val token = StringTokenizer(br.readLine(), " ")
    n = token.nextToken().toInt()
    r = token.nextToken().toInt()

    arr = Array(n + 1, { ArrayList<TreeNode>() })
    visited = BooleanArray(n + 1)
    var a = 0
    var b = 0
    var d = 0
    for (i in 0 until n - 1) {
        val token = StringTokenizer(br.readLine(), " ")
        a = token.nextToken().toInt()
        b = token.nextToken().toInt()
        d = token.nextToken().toInt()

        arr[a].add(TreeNode(b, d))
        arr[b].add(TreeNode(a, d))
    }

    findPoleLength(r, 0)
    findMaxLength(gigaNode, 0)

    bw.write(pole_length.toString() + " " + max_length.toString())
    bw.flush()
    bw.close()
}

private fun findPoleLength(curNode: Int, total: Int) {
    visited[curNode] = true
    if (arr[curNode].size > 2 || (arr[curNode].size == 1 && curNode != r) || (arr[curNode].size == 2 && curNode == r)) {
        pole_length = total
        gigaNode = curNode
        return

    } else {
        for (i in 0 until arr[curNode].size) {
            val nextNode = arr[curNode].get(i).num
            val nextTotal = total + arr[curNode].get(i).cost
            if (!visited[nextNode]) {
                visited[nextNode] = true
                findPoleLength(nextNode, nextTotal)
            }
        }
    }

}

private fun findMaxLength(curNode: Int, total: Int) {
    if (arr[curNode].size == 1) {
        max_length = Math.max(max_length, total)
        return
    }

    for (i in 0 until arr[curNode].size) {
        val nextNode = arr[curNode].get(i).num
        val nextTotal = total + arr[curNode].get(i).cost
        if (!visited[nextNode]) {
            visited[curNode] = true
            findMaxLength(nextNode, nextTotal)

        }
    }
}