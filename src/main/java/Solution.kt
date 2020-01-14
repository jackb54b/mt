import kotlin.math.pow

class Solution(val number:Int) {

    private var binary: List<Byte> = emptyList()

    fun solution(): Int {
        return 0
    }

    fun convert(): List<Byte> {
        if(number == 0) {
            binary += 0
            return binary
        }

        var i:Int = 0
        var sum:Int = 0
        while (2.0f.pow(++i) <= number) {}
        i--
        binary += 1
        sum += 2.0f.pow(i).toInt()

        for(j in --i downTo 0) {
           if(sum + 2.0f.pow(j).toInt() <= number) {
               binary += 1
               sum += 2.0f.pow(i).toInt()
           } else {
               binary += 0
           }
        }
        return binary
    }

// 5 101

    fun binaryToIntValue(): Int {
        var sum = 0
        binary.asReversed().forEachIndexed() {
            index, bit -> sum += bit * 2f.pow(index).toInt()
        }
        return sum
    }
}

// 2^(n-1)
//4 10
//5 101
//7 111