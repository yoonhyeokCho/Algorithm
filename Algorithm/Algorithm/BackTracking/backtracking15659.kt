import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.StringTokenizer

private val br = BufferedReader(InputStreamReader(System.`in`))
private var bw = BufferedWriter(OutputStreamWriter(System.out))

private var n = 0
private var m = 0
private val check = BooleanArray(9)

fun main(){
    val token = StringTokenizer(br.readLine()," ")
    n = token.nextToken().toInt()
    m = token.nextToken().toInt()

    dfs("")

    bw.flush()

}


fun dfs(str: String) {
    if (str.length >= m) {
        for (i in 0..str.length - 1) {
            bw.write("${str[i]} ")
        }
        bw.write("\n")
        return
    }
    for (i in 1..n) {
        if (check[i])
            continue
        check[i] = true
        dfs(str + "${i}")
        check[i] = false
    }
}


