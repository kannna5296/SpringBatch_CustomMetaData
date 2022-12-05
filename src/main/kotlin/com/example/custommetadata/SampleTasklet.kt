package com.example.custommetadata

import org.springframework.batch.core.StepContribution
import org.springframework.batch.core.scope.context.ChunkContext
import org.springframework.batch.core.step.tasklet.Tasklet
import org.springframework.batch.repeat.RepeatStatus
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.annotation.Qualifier
import org.springframework.jdbc.core.JdbcTemplate
import org.springframework.stereotype.Component

@Component
class SampleTasklet : Tasklet {

    @Qualifier("businessDataJdbcTemplate")
    @Autowired lateinit var jdbcTemplate: JdbcTemplate

    override fun execute(contribution: StepContribution, chunkContext: ChunkContext): RepeatStatus {
        println("SampleTaskletが起動しました")
        jdbcTemplate.execute("SELECT 1;") //仮SQL. ビジネスロジックを想定.
        return RepeatStatus.FINISHED
    }
}