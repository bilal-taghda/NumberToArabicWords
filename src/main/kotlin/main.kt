import logic.NumToWords
import logic.UnitsOfNumToWords
import java.util.*


fun main(){

    println("hello \n type int ... \n")

    val input = Scanner(System.`in`)
    val number = input.nextInt()

    val numsToWords = NumToWords(number, UnitsOfNumToWords())

    println(numsToWords.getNumToWords())

}