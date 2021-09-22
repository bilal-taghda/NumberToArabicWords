package util.enums

enum class Hundreds {
    HUNDRED,
    TWO_HUNDRED;

     fun toArabicWord(): String {
        when(this){
            HUNDRED -> return "مائة"
            TWO_HUNDRED -> return "مائتين"
        }
    }
}