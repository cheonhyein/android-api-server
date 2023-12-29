package com.api.androidapiserver.api.rest

import com.api.androidapiserver.api.dto.ApiDto
import com.api.androidapiserver.api.service.ApiService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

/**
 * <pre>
 *
 *
 * Description : com.api.androidapiserver.api.rest
 * </pre>
 *
 * @author
 * @since 2023/12/29
 */
@RestController
@RequestMapping("/api")
class ApiRestController(val apiService: ApiService) {
    @PostMapping
    fun save(@RequestBody apiDto: ApiDto) : String {
        apiService.save(apiDto)
        return "200"
    }
    @GetMapping
    fun test() : String {
        return "success"
    }
}