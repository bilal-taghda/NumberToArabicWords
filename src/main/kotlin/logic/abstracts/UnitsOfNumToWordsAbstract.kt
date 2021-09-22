package logic.abstracts

import logic.interfaces.HundredsToWordsInterf
import logic.interfaces.TensToWordsInterf
import logic.interfaces.UnitsToWordsInterf

abstract class UnitsOfNumToWordsAbstract
    : HundredsToWordsInterf, TensToWordsInterf, UnitsToWordsInterf {

    abstract fun setUnitsLogic(num: Int) : String
    abstract override fun convertHundredsToWords(num: Int): String
    abstract override fun convertUnitsToWords(num: Int): String
    abstract override fun convertTensToWords(num: Int): String
}