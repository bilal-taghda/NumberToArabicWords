package util.enums

enum class Millions {
    MILLION,
    TWO_MILLION;

    fun toArabicWord(): String {
        when (this) {
            MILLION -> return "مليون"
            TWO_MILLION -> return "مليونان"
        }
    }
}