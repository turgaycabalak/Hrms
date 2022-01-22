package com.hrms.hrmsproject.entity.dtos.SkillDto;

import com.hrms.hrmsproject.entity.cv.Cv;
import com.hrms.hrmsproject.entity.cv.Skill;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class SkillDtoConv {

    public Skill convertToSkill(SkillReq skillReq, Cv cv){
        return new Skill(
                cv,
                skillReq.getSkill(),
                skillReq.getSkillLevel()
        );
    }

    public List<Skill> convertToListSkill(List<SkillReq> skillReqs,Cv cv){
        return skillReqs.stream()
                .map(skillReq -> convertToSkill(skillReq,cv))
                .collect(Collectors.toList());
    }

    public SkillResponse convertToSkillResponse(Skill skill){
        return new SkillResponse(
                skill.getId(),
                skill.getSkill(),
                skill.getSkillLevel()
        );
    }

    public List<SkillResponse> convertToListSkillResponse(List<Skill> skills){
        return skills.stream()
                .map(this::convertToSkillResponse)
                .collect(Collectors.toList());
    }


}
