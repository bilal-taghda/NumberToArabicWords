package logic.abstracts

import logic.interfaces.MillionsToWordsInterf
import logic.interfaces.ThousandsToWordsInterf

abstract class NumToWordsAbstract : ThousandsToWordsInterf, MillionsToWordsInterf {

    abstract fun getNumToWords(): String
    abstract override fun convertMillionsToWords(unitsOfMillions: Int): String
    abstract override fun convertThousandsToWords(unitsOfThousands: Int): String

    }