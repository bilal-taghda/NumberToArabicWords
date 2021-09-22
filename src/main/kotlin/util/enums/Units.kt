package util.enums

enum class Units {
    ZERO,
    ONE,
    TWO,
    THREE,
    FOUR,
    FIVE,
    SIX,
    SEVEN,
    EIGHT,
    NINE;

    fun toArabicWord(): String {
        when (this) {
            ZERO -> return "صفر"
            ONE  -> return "واحد"
            TWO  -> return "إثنان"
            THREE -> return "ثلاثة"
            FOUR -> return "أربعة"
            FIVE -> return "خمسة"
            SIX  -> return "ستة"
            SEVEN -> return "سبعة"
            EIGHT -> return "ثمانية"
            NINE -> return "تسعة"
        }
    }
}