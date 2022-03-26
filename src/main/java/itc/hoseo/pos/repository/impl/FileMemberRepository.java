package itc.hoseo.pos.repository.impl;

import itc.hoseo.pos.domain.Member;
import itc.hoseo.pos.repository.MemberRepository;

import java.sql.SQLException;
import java.util.List;

public class FileMemberRepository implements MemberRepository {
    @Override
    public Member save(Member member) throws SQLException {
        return null;
    }

    @Override
    public List<Member> findall() throws SQLException {
        return null;
    }

    @Override
    public Member findById(String id) throws SQLException {
        return null;
    }

    @Override
    public void clear() {

    }
}
