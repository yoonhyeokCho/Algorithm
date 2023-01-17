import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.StringTokenizer

private val br = BufferedReader(InputStreamReader(System.`in`))
private val bw = BufferedWriter(OutputStreamWriter(System.out))
private lateinit var arr: Array<ArrayList<Int>>
private var n = 0
private var delete = 0
private var answer = 0;
private var root = 0

fun main() {
    n = br.readLine().toInt()
    arr = Array(n, { ArrayList() })
    var token = StringTokenizer(br.readLine(), " ")
    var parentNode = 0
    for (i in 0 until n) {
        parentNode = token.nextToken().toInt()
        if (parentNode == -1) {
            root = i
        }else{
            arr[parentNode].add(i)
        }
    }
    delete = br.readLine().toInt()

    if(delete == root){
        bw.write("0")
    }else{
        dfs(root)
        bw.write(answer.toString())
    }
    bw.flush()
    bw.close()
}

private fun dfs(index: Int) {
    var count = 0
    var next = 0
    for (i in 0 until arr[index].size) {
        next = arr[index][i]
        if (next == delete) {
            continue
        }
        dfs(next)
        count++
    }
    if (count == 0){
        answer++
    }
}
