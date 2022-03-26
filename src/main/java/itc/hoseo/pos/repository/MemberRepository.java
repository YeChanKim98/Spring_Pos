package itc.hoseo.pos.repository;

import itc.hoseo.pos.domain.Member;

import java.sql.SQLException;
import java.util.List;

public interface MemberRepository {
    public Member save(Member member) throws SQLException;
    public List<Member> findall() throws SQLException;
    public Member findById(String id) throws SQLException;
    public void clear();

}
