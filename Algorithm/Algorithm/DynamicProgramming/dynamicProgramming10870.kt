import java.io.BufferedReader
import java.io.InputStreamReader

fun main(){
    val br = BufferedReader(InputStreamReader(System.`in`))
    val n = br.readLine().toInt()

    val arr = IntArray(n+1)

    for(i in arr.indices){
        if(i == 0){
            arr[i] = 0
        }else if (i== 1){
            arr[i] = 1
        }else{
            arr[i] = arr[i-1] + arr[i-2]
        }
    }
    println(arr[n])

}
