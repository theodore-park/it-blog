package com.developers.blog.controller

import spock.lang.Specification

class HealthCheckerTest extends Specification {
	def "헬스 체크 테스트"() {
		given:
		def checker = new HealthChecker()

		expect:
		checker.healthCheck() == "OK"
	}
}
