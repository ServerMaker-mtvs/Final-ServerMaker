package com.ohgiraffers.Member;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MemberRepository {
    // 태현님

    // 맵의 키는 index, 값은 멤버(객체)
    private static Map<Long, MemberDTO> store = new HashMap<>();

    // 인덱스가 하나씩 증가하는 시퀀스로 사용
    private static Long sequence = 0L;

    // MemberRepository 클래스는 싱글톤으로 사용
    // 인스턴스가 하나인 것이 보장되기 때문에 멤버변수는 static을 안써도 된다.
    private static final MemberRepository instance = new MemberRepository();

    public static MemberRepository getInstance() {
        return instance;
    }

    // 싱글톤 사용시 생성자를 private으로 막아야 함(아무나 생성하지 못하게)
    private MemberRepository() {
    }

    // 회원 저장 로직
    public MemberDTO save(MemberDTO member) {
        member.setIndex(++sequence);
        store.put(member.getIndex(), member);
        return member;
    }

    // 회원 조회 로직
    /*
    필기.
        HashMap은 삽입 순서를 보장하지 않으나 List는 순차적으로 데이터를 저장하고 각 요소에는 고유한 인덱스가 존재
        Map의 키와 값을 List로 관리해야 하는 경우가 존재
        values()는 map이 가지고 있는 value를 Collection 형태로 반환
        value 값만 얻을 수 있다
     */

    // 회원의 객체가 리스트로 반환
    public List<MemberDTO> findAll() {
        return new ArrayList<>(store.values());
    }


    // 회원의 ID가 리스트로 반환
    public List<String> findAllId() {
        List<MemberDTO> memberDTO = new ArrayList<>(store.values());
        List<String> memberIdList = new ArrayList<String>();

        for (MemberDTO member : memberDTO) {
            memberIdList.add(member.getId());
        }
        return memberIdList;
    }

    // 테스트에서만 사용
    public void clearStore() {
        store.clear();
    }
}
