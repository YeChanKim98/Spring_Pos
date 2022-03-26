package itc.hoseo.pos.repository.impl;

import itc.hoseo.pos.domain.Member;
import itc.hoseo.pos.repository.MemberRepository;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class HashMapMemberRepository implements MemberRepository {
    private static final HashMapMemberRepository instance = new HashMapMemberRepository();
    private HashMapMemberRepository(){}

    HashMap<String, Member> memberHashMap = new HashMap<>();

    // 사용자 저장
    @Override
    public Member save(Member member) {
        System.out.print("맴버 저장 : "+member);
        memberHashMap.put(member.getName(), member); // ???
        System.out.println(" -> Success");
        return member;
    }

    // 전체 목록
    @Override
    public List<Member> findall() {
        System.out.println("전체 결과 조회");
        List<Member> memberList = new ArrayList<Member>(memberHashMap.values());
        return memberList;
    }

    // id를 키로 검색
    @Override
    public Member findById(String name) {
        System.out.println("검색 :"+name);
        Member getMember = memberHashMap.get(name);
        System.out.println("조회 결과 :"+getMember);
        return getMember;
    }

    // 전체삭제
    @Override
    public void clear() {
        memberHashMap.clear();
        System.out.println("전체 삭제 완료..");
    }

    public static HashMapMemberRepository getInstance(){
        return instance;
    }

}
