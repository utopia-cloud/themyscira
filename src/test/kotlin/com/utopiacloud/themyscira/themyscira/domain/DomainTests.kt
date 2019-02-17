package com.utopiacloud.themyscira.themyscira.domain

import com.utopiacloud.themyscira.themyscira.domain.entity.Npo
import com.utopiacloud.themyscira.themyscira.domain.repository.NpoRepository
import org.assertj.core.api.Assertions.assertThat
import org.junit.Test
import org.junit.runner.RunWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.annotation.Rollback
import org.springframework.test.context.junit4.SpringRunner
import java.time.Clock
import java.time.LocalDateTime
import java.time.ZoneId
import java.time.ZoneOffset
import javax.transaction.Transactional

@RunWith(SpringRunner::class)
@Transactional
@SpringBootTest
class DomainTests {
    @Autowired
    lateinit var npoRepository: NpoRepository

    @Test
    @Rollback
    fun createNpo() {
        val npo = Npo(
                name = "NPOダンタイ"
        )
        val now = LocalDateTime.now().toInstant(ZoneOffset.UTC)
        val clock = Clock.fixed(
                now,
                ZoneId.systemDefault())
        LocalDateTime.now(clock)
        val result = npoRepository.save(npo)

        assertThat(result.name).isEqualTo(npo.name)
        assertThat(result.corporateNumber).isEqualTo(0)
    }
}
