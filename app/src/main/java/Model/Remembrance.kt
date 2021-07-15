package Model

import java.io.Serializable

class Remembrance : Serializable {
    var nameLatin:String? = null
    var nameArabic:String? = null
    var total : Int? = null



    constructor(nameLatin: String?, nameArabic: String, total: Int?) {
        this.nameLatin = nameLatin
        this.nameArabic = nameArabic
        this.total = total
    }

    constructor()
}