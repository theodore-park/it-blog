package com.developers.blog.service.user.creator


import spock.lang.Specification

class UserCreatorTest extends Specification {
	def "유저 객체 create Test"() {
		given:
		def userCreateRequest = Mock(UserCreateRequest) {
			getName() >> '테스트'
		}
		def userCreator = new UserCreator()
		def user = userCreator.create(userCreateRequest)

		expect:
		user.getName() == '테스트'
	}

}
