package com.formgrav.mymoviesmvvm.data

import com.formgrav.mymoviesmvvm.data.dto.Response

interface NetworkClient {
    fun doRequest(dto: Any): Response
}