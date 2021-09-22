package util.enums

enum class Tens {
    TEN,
    ELEVEN,
    TWELVE,
    TWINTY,
    THIRTY,
    FOURTY,
    FIFTY,
    SIXTY,
    SEVENTY,
    EIGHTY,
    NINTY;


    fun toArabicWord(): String {
        when (this) {
            TEN    -> return "عشرة"
            ELEVEN -> return "احدا عشر"
            TWELVE -> return "اثنا عشر"
            TWINTY -> return "عشرون"
            THIRTY -> return "ثلاثون"
            FOURTY -> return "اربعون"
            FIFTY  -> return "خمسون"
            SIXTY  -> return "ستون"
            SEVENTY -> return "سبعون"
            EIGHTY -> return "ثمانون"
            NINTY  -> return "تسعون"
        }
    }
}