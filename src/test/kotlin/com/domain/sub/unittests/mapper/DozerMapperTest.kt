package com.domain.sub.unittests.mapper

import com.domain.sub.data.vo.v1.PersonVO
import com.domain.sub.mapper.DozerMapper
import com.domain.sub.models.Person


import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

import com.domain.sub.unittests.mapper.mocks.MockPerson

class DozerMapperTest {
    // MockPerson initialization
    var inputObject: MockPerson? = null

    @BeforeEach
    fun setUp() {
        // Runs before each test
        inputObject = MockPerson()
    }

    @Test
    fun parseEntityToVOTest() {
        val output: PersonVO = DozerMapper.parseObject(inputObject!!.mockEntity(), PersonVO::class.java)
        assertEquals(0, output.pk)
        assertEquals("First Name Test0", output.firstName)
        assertEquals("Last Name Test0", output.lastName)
        assertEquals("Address Test0", output.address)
        assertEquals("Male", output.gender)
    }

    @Test
    fun parseEntityListToVOListTest() {
        val outputList: MutableList<PersonVO> =
            DozerMapper.parseListObjects(inputObject!!.mockEntityList(), PersonVO::class.java)

        val outputZero: PersonVO = outputList[0]

        assertEquals(0, outputZero.pk)
        assertEquals("First Name Test0", outputZero.firstName)
        assertEquals("Last Name Test0", outputZero.lastName)
        assertEquals("Address Test0", outputZero.address)
        assertEquals("Male", outputZero.gender)

        val outputSeven: PersonVO = outputList[7]
        assertEquals(7.toLong(), outputSeven.pk)
        assertEquals("First Name Test7", outputSeven.firstName)
        assertEquals("Last Name Test7", outputSeven.lastName)
        assertEquals("Address Test7", outputSeven.address)
        assertEquals("Female", outputSeven.gender)

        val outputTwelve: PersonVO = outputList[12]
        assertEquals(12.toLong(), outputTwelve.pk)
        assertEquals("First Name Test12", outputTwelve.firstName)
        assertEquals("Last Name Test12", outputTwelve.lastName)
        assertEquals("Address Test12", outputTwelve.address)
        assertEquals("Male", outputTwelve.gender)
    }

    @Test
    fun parseVOToEntityTest() {

        val output: Person = DozerMapper.parseObject(inputObject!!.mockVO(), Person::class.java)

        assertEquals(0, output.id)
        assertEquals("First Name Test0", output.firstName)
        assertEquals("Last Name Test0", output.lastName)
        assertEquals("Address Test0", output.address)
        assertEquals("Male", output.gender)
    }

    @Test
    fun parserVOListToEntityListTest() {

        val outputList: MutableList<Person> = DozerMapper.parseListObjects(inputObject!!.mockVOList(), Person::class.java)

        val outputZero: Person = outputList[0]
        assertEquals(0, outputZero.id)
        assertEquals("First Name Test0", outputZero.firstName)
        assertEquals("Last Name Test0", outputZero.lastName)
        assertEquals("Address Test0", outputZero.address)
        assertEquals("Male", outputZero.gender)

        val outputSeven: Person = outputList[7]
        assertEquals(7, outputSeven.id)
        assertEquals("First Name Test7", outputSeven.firstName)
        assertEquals("Last Name Test7", outputSeven.lastName)
        assertEquals("Address Test7", outputSeven.address)
        assertEquals("Female", outputSeven.gender)

        val outputTwelve: Person = outputList[12]
        assertEquals(12, outputTwelve.id)
        assertEquals("First Name Test12", outputTwelve.firstName)
        assertEquals("Last Name Test12", outputTwelve.lastName)
        assertEquals("Address Test12", outputTwelve.address)
        assertEquals("Male", outputTwelve.gender)
    }
}