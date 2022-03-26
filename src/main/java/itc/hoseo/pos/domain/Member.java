package itc.hoseo.pos.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data // 게터 세터등 컴파일시 자동 생성
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Member {
    private int seq;
    private String name;
    private String password;
    private int age;

    
}
