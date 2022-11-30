package com.example.custommetadata

import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
@EnableBatchProcessing
class CustommetadataApplication

fun main(args: Array<String>) {
	runApplication<CustommetadataApplication>(*args)
}
