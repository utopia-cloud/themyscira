package com.utopiacloud.themyscira.themyscira.trial

import org.slf4j.LoggerFactory
import org.springframework.batch.item.ItemProcessor


class PersonItemProcessor : ItemProcessor<Person, Person> {
    private val log = LoggerFactory.getLogger(PersonItemProcessor::class.java)

    @Throws(java.lang.Exception::class)
    override fun process(person: Person): Person? {
        val firstName = person.firstName.toUpperCase()
        val lastName = person.lastName.toUpperCase()

        val transformerdPerson = Person(
                firstName = firstName,
                lastName = lastName
        )

        log.info("Converting ($person) into ($transformerdPerson)")

        return transformerdPerson
    }
}