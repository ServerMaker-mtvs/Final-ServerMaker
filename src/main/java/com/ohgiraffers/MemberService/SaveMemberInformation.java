package com.ohgiraffers.MemberService;

public class SaveMemberInformation {
    public void saveInformation (UnCheckedMember data){
        // 나이 유효성 확인



        //  비밀번호 유효성 확인
        try {
            CheckMemberPwd checkMemberPwd = new CheckMemberPwd();
            checkMemberPwd.checkPwd(data.unCheckedPassword1, data.unCheckedPassword2);
        } catch (Exception e) {
            throw new IllegalArgumentException(e);
        }


        // Id 유효성 확인
        try {
            CheckMemberId checkMemberId = new CheckMemberId();
            checkMemberId.checkPatternId(data.unCheckedId);
        } catch (Exception e) {
            throw new IllegalArgumentException(e);
        }

        // 이름 유효성 확인
        try {
            CheckMemberName checkMemberName = new CheckMemberName();
            checkMemberName.checkPatternName(data.unCheckedName);
        } catch (Exception e) {
            throw new IllegalArgumentException(e);
        }
    }

}
