package logic

import logic.abstracts.UnitsOfNumToWordsAbstract
import util.enums.Hundreds
import util.enums.Tens
import util.enums.Units
import util.Constants
import java.lang.RuntimeException

class UnitsOfNumToWords : UnitsOfNumToWordsAbstract() {


    override fun convertUnitsToWords(num: Int): String = when (num) {
        0 -> Units.ZERO.toArabicWord()
        1 -> Units.ONE.toArabicWord()
        2 -> Units.TWO.toArabicWord()
        3 -> Units.THREE.toArabicWord()
        4 -> Units.FOUR.toArabicWord()
        5 -> Units.FIVE.toArabicWord()
        6 -> Units.SIX.toArabicWord()
        7 -> Units.SEVEN.toArabicWord()
        8 -> Units.EIGHT.toArabicWord()
        9 -> Units.NINE.toArabicWord()
        else -> throw RuntimeException("number not expected !!")
    }

    override fun convertTensToWords(num: Int): String = when {
        num == 10 -> Tens.TEN.toArabicWord()
        num == 11 -> Tens.ELEVEN.toArabicWord()
        num == 12 -> Tens.TWELVE.toArabicWord()
        num >  12 && num < 20 -> setTensUnitsToWords(num / 10 )
        num >  20 ->  setTensUnitsToWords(num / 10)
        else -> throw RuntimeException("number not expected !!")
    }

    private fun setTensUnitsToWords(unitsOfTens: Int): String = when (unitsOfTens) {
        1 -> Tens.TEN.toArabicWord()
        2 -> Tens.TWINTY.toArabicWord()
        3 -> Tens.THIRTY.toArabicWord()
        4 -> Tens.FOURTY.toArabicWord()
        5 -> Tens.FIFTY.toArabicWord()
        6 -> Tens.SIXTY.toArabicWord()
        7 -> Tens.SEVENTY.toArabicWord()
        8 -> Tens.EIGHTY.toArabicWord()
        9 -> Tens.NINTY.toArabicWord()
        else -> throw RuntimeException("number not expected !!")
    }

    override fun convertHundredsToWords(num: Int): String = when {
        num / Constants.HUNDRED == 1 -> Hundreds.HUNDRED.toArabicWord()
        num / Constants.HUNDRED == 2 -> Hundreds.TWO_HUNDRED.toArabicWord()
        else -> convertUnitsToWords(num / Constants.HUNDRED) + " " + Hundreds.HUNDRED.toArabicWord()
    }

    override fun setUnitsLogic(num: Int): String {
        val NUM_NOT_TEN_ELEVEN_TWELVE = num != 10 && num != 11 && num != 12
        val TENS_NUM_NOT_TEN_ELEVEN_TWELVE__UNITS_NOT_ZERO = num % Constants.HUNDRED != 10
                && num % Constants.HUNDRED != 11 && num % Constants.HUNDRED != 12 && num % 10 != 0

        return when {
            num < Constants.TEN -> convertUnitsToWords(num)
            num < Constants.HUNDRED -> (if (NUM_NOT_TEN_ELEVEN_TWELVE) convertUnitsToWords(num % Constants.TEN) else "") + convertTensToWords(num )
            else -> convertHundredsToWords(num) +
                    (if (TENS_NUM_NOT_TEN_ELEVEN_TWELVE__UNITS_NOT_ZERO) Constants.AND + convertUnitsToWords(num % 10) else "") +
                    (if(num % Constants.HUNDRED >= Constants.TEN) Constants.AND + convertTensToWords(num % Constants.HUNDRED) else "")
        }
    }
}

