package com.eurosport.data.mapper

import com.eurosport.data.response.SportResp
import com.eurosport.domain.models.Sport
import javax.inject.Inject

class  SportMapper @Inject constructor() {


     fun toSport(resp : SportResp):Sport{
        return Sport(resp.id,resp.name)
    }
    fun toSportResp(sport: Sport): SportResp{
        return SportResp(sport.id,sport.name)
    }
}