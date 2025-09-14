package lk.acpt.library.service;

import lk.acpt.library.dto.MemberDto;

import java.lang.reflect.Member;
import java.util.ArrayList;

public interface MemberService {

    int addMember(MemberDto memberDto);
    int deleteMember(int id);
    MemberDto searchMember(int id);
    int updateMember(MemberDto memberDto);
    ArrayList<MemberDto> lordData (MemberDto memberDto);

}
