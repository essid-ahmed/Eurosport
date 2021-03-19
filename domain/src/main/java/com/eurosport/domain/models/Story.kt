package com.eurosport.domain.models

import java.io.Serializable

class Story (override var id:Int, override var title :String,override var date :String,override var sport: Sport,var image :String,var teaser :String,var author :String) :News(),Serializable {
    override fun isVideo(): Boolean {
        return false
    }
}

