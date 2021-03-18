package com.eurosport.domain.models

abstract class News
{
    abstract var  id:Int
    abstract var title : String
    abstract var date :Long
    abstract var sport: Sport
}