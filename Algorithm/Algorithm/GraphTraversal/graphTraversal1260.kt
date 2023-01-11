import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*

private lateinit var arr: Array<IntArray>
private lateinit var visited: BooleanArray
private var n = 0
private var m = 0
fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    var token = StringTokenizer(br.readLine(), " ")
    n = token.nextToken().toInt()
    m = token.nextToken().toInt()
    val v = token.nextToken().toInt()

    arr = Array(n + 1, { IntArray(n + 1, { 0 }) })
    visited = BooleanArray(n + 1, { false })
    for (i in 0 until m) {
        token = StringTokenizer(br.readLine(), " ")
        val a = token.nextToken().toInt()
        val b = token.nextToken().toInt()
        arr[a][b] = 1
        arr[b][a] = arr[a][b]
    }

    dfs(v)
    println()
    bfs(v)
}

fun dfs(v: Int) {
    visited[v] = true
    print(v.toString() + " ")
    for (i in 1..n) {
        if (arr[v][i] == 1 && visited[i] != true) {
            dfs(i)
        }
    }

}

fun bfs(v: Int) {
    var queue = arrayListOf<Int>()
    visited = BooleanArray(n + 1, { false })
    var temp = 0
    visited[v] = true
    queue.add(v)

    while (queue.size != 0) {
        temp = queue[0]
        queue.removeAt(0)
        print(temp.toString() + " ")

        for (i in 1..n) {
            if (arr[temp][i] == 1 && visited[i] != true) {
                queue.add(i)
                visited[i] = true
            }
        }
    }
    visited.all({ false })
}
