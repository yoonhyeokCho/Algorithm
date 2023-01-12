import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.*
import kotlin.collections.ArrayList

private lateinit var arr: Array<ArrayList<Int>>
private lateinit var answer: IntArray
private lateinit var visited: BooleanArray

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))
    var token = StringTokenizer(br.readLine(), " ")
    var n = token.nextToken().toInt()
    var m = token.nextToken().toInt()

    arr = Array(n+1,{ ArrayList<Int>() })
    for (i in 0 until m) {
        token = StringTokenizer(br.readLine(), " ")
        val a = token.nextToken().toInt()
        val b = token.nextToken().toInt()
        arr[a].add(b)
    }
    var max = 0
    answer = IntArray(n+1)
    visited = BooleanArray(n+1)
    for (i in 1..n) {
        Arrays.fill(visited,false)
        dfs(i)
    }
    for(i in 1..n){
        max = Math.max(max, answer[i])
    }
    for (i in 1..n) {
        if (answer[i] == max) {
            bw.write(i.toString()+" ")
        }

    }
    bw.flush()
    bw.close()

}
private fun dfs(v:Int){
    visited[v] = true
    for(i in arr[v].indices){
        var temp = arr[v][i]
        if(visited[temp]==false){
            answer[temp]++
            dfs(temp)
        }
    }
}

//시간 초과
//private fun bfs(v: Int) {
//    var queue: Queue<Int> = LinkedList()
//    var visited = BooleanArray(arr.size)
//    visited[v] = true
//    queue.add(v)
//    while (queue.size != 0) {
//        var cur = queue.poll()
//        answer[v]++
//        for (i in arr[cur].indices) {
//            var temp = arr[cur][i]
//            if (!visited[temp]) {
//                queue.add(temp)
//                visited[temp] = true
//            }
//        }
//    }
//}