import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.lang.StringBuilder
import java.util.*

private val br = BufferedReader(InputStreamReader(System.`in`))
private val bw = BufferedWriter(OutputStreamWriter(System.out))

data class EventInfo(val id:Int, var time:Int, val occurTime:Int):Comparable<EventInfo>{
    override fun compareTo(other: EventInfo) = compareValuesBy(this,other,{it.id},{it.time},{it.occurTime})
}

fun main(){
    val token = StringTokenizer(br.readLine())
    val N = token.nextToken().toInt()
    val T = token.nextToken().toInt()
    val W = token.nextToken().toInt()

    var queue:Queue<EventInfo> = LinkedList()
    for(i in 0 until N){
        val (px,tx) = br.readLine().split(" ")
            .map { it.toInt()}
        queue.add(EventInfo(px,tx,0))
    }

    var priorityQueue: PriorityQueue<EventInfo>
    priorityQueue = PriorityQueue{o1 : EventInfo, o2: EventInfo -> o1.occurTime - o2.occurTime}
    val M = br.readLine().toInt()
    for(i in 0 until M){
        val (px,tx,cx) = br.readLine().split(" ")
            .map { it.toInt() }
        priorityQueue.add(EventInfo(px,tx,cx))
    }

    var curTime = 0
    var sb = StringBuilder()
    while(curTime < W){
        var cur = queue.poll()
        if(cur.time > T){
            for(i in 0 until T){
                if(curTime >= W){
                    bw.write(sb.toString())
                    bw.flush()
                    bw.close()
                    return
                }
                sb.append("${cur.id}\n")
                curTime++
            }
        }else{
            for(i in 0 until cur.time){
                if(curTime >= W){
                    bw.write(sb.toString())
                    bw.flush()
                    bw.close()
                    return
                }
                sb.append("${cur.id}\n")
                curTime++
            }
        }
        while(!priorityQueue.isEmpty() && priorityQueue.peek().occurTime <= curTime){
            queue.add(priorityQueue.poll())
        }
        if(cur.time > T){
            cur.time = cur.time - T
            queue.add(cur)
        }
    }
    bw.write(sb.toString())
    bw.flush()
    bw.close()
}
