package com.tietoevry.homework

import org.springframework.boot.test.context.SpringBootTest
import spock.lang.Specification

@SpringBootTest(classes = [HomeworkApplication])
abstract class IntegrationTest extends Specification {

}
