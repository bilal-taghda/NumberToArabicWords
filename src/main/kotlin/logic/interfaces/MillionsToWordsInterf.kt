package logic.interfaces

import util.enums.Millions

interface MillionsToWordsInterf {
    fun convertMillionsToWords(unitsOfMillions: Int) : String
}