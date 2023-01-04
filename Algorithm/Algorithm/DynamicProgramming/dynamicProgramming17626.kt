import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))
    val n = br.readLine().toInt()

    var dp = IntArray(50001)
    dp[1] = 1
    for(i in 2 .. n){
        var minNum = 50000
        for(j in 1 .. i ){
            if(j*j > i){
                break
            }else{
                val squareNum = i -j*j
                minNum = Math.min(minNum,dp[squareNum])
            }
        }
        dp[i] = minNum +1
    }

    bw.write(dp[n].toString())
    bw.flush()
}

