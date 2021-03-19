package com.eurosport.domain.models

data class Video (override var id:Int, override var title :String,override var date :String,override var sport: Sport, var url :String,  var views :Int, var thumb: String) : News()

