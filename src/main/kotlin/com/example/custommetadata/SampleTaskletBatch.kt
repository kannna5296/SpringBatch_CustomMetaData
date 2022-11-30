package com.example.custommetadata

import org.springframework.batch.core.Job
import org.springframework.batch.core.Step
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory
import org.springframework.batch.core.launch.support.RunIdIncrementer
import org.springframework.batch.core.step.tasklet.Tasklet
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

//1Step,1Taskletからなる1Jobを実行するバッチ
@Configuration
@EnableBatchProcessing
class SampleTaskletBatch(
    private val tasklet: Tasklet,
    private val jobBuilderFactory: JobBuilderFactory,
    private val stepBuilderFactory: StepBuilderFactory,
) {

    @Bean
    fun sampleJob(step: Step): Job {
        return jobBuilderFactory["job"]
            .incrementer(RunIdIncrementer())
            .start(step)
            .build()
    }

    @Bean
    fun sampleStep(): Step {
        return stepBuilderFactory.get("step")
            .tasklet(tasklet)
            .build()
    }
}