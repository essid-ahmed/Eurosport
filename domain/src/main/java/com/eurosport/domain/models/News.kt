package com.eurosport.domain.models

abstract class News
{
    abstract var  id:Int
    abstract var title : String
    abstract var date :String
    abstract var sport: Sport

    abstract fun isVideo():Boolean
}