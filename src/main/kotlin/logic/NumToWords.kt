package logic

import logic.abstracts.NumToWordsAbstract
import logic.abstracts.UnitsOfNumToWordsAbstract
import util.enums.Millions
import util.enums.Thousands
import util.Constants
import java.lang.RuntimeException

class NumToWords(private var num: Int, private var unitsNumToWordsAbstract: UnitsOfNumToWordsAbstract)
    : NumToWordsAbstract() {

    private var DOES_HAVING_UNITS = num % Constants.THOUSAND != 0
    private var DOES_HAVE_THOUSANDS = num % Constants.MILLION > 999

    override fun getNumToWords(): String {
        if(num < Constants.THOUSAND){
            return getNumOfUnitsToWords()
        }else if(num < Constants.MILLION) {
            return getNumOfThousandsToWords()
        }else if(num < Constants.BILLION){
            return getNumOfMillionsToWords()
        }
        throw RuntimeException("number not expected !!")
    }

    private fun getNumOfUnitsToWords() = unitsNumToWordsAbstract.setUnitsLogic(num)

    private fun getNumOfThousandsToWords() = convertThousandsToWords(num / Constants.THOUSAND) +
            if (DOES_HAVING_UNITS) Constants.AND + unitsNumToWordsAbstract.setUnitsLogic(num % Constants.THOUSAND) else ""

    private fun getNumOfMillionsToWords() = convertMillionsToWords(num / Constants.MILLION) +
            (if (DOES_HAVE_THOUSANDS) Constants.AND + convertThousandsToWords(num / Constants.THOUSAND % Constants.THOUSAND) else "") +
            if (DOES_HAVING_UNITS) Constants.AND + unitsNumToWordsAbstract.setUnitsLogic(num % Constants.THOUSAND) else ""

    override fun convertMillionsToWords(unitsOfMillions: Int): String {
        return unitsNumToWordsAbstract.setUnitsLogic(unitsOfMillions) +" "+ Millions.MILLION.toArabicWord()

    }

    override fun convertThousandsToWords(unitsOfThousands: Int): String {
        return unitsNumToWordsAbstract.setUnitsLogic(unitsOfThousands) + " " + Thousands.THOUSANDS.toArabicWord()

    }


}