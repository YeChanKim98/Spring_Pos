package itc.hoseo.pos;

import itc.hoseo.pos.domain.Member;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class MemberTests {

	@Test
	void contextLoads() {
		Member m = new Member();

		// AllArgsConstructor
		Member m1 = new Member(1,"YC","1234",10);

		// Builder
		Member m2 = Member.builder()
				.name("YC2")
				.build();

		// 기대값, 받은값
		assertEquals("YC", m1.getName());
	}

}
