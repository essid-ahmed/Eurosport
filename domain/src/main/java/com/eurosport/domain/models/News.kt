package com.eurosport.domain.models

import java.io.Serializable

abstract class News : Serializable
{
    abstract var  id:Int
    abstract var title : String
    abstract var date :String
    abstract var sport: Sport

    abstract fun isVideo():Boolean
}