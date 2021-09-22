package util.enums

enum class Thousands {
    THOUSAND,
    TWO_THOUSAND,
    THOUSANDS;

    fun toArabicWord(): String {
        when (this) {
            THOUSAND      -> return "الف"
            TWO_THOUSAND  -> return "الفان"
            THOUSANDS     -> return "الاف"
        }

    }
}

