package com.hrms.hrmsproject.business.CvServices;

import com.hrms.hrmsproject.dataAccess.CvRepos.SkillRepository;
import com.hrms.hrmsproject.entity.cv.Cv;
import com.hrms.hrmsproject.entity.cv.Skill;
import com.hrms.hrmsproject.entity.dtos.SkillDto.SkillDtoConv;
import com.hrms.hrmsproject.entity.dtos.SkillDto.SkillReq;
import com.hrms.hrmsproject.entity.dtos.SkillDto.SkillResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class SkillService {

    private final SkillRepository skillRepository;
    private final CvService cvService;
    private final SkillDtoConv skillDtoConv;


    public SkillResponse addSkill(SkillReq skillReq, Long cvId) {
        Cv cv = cvService.findCvById(cvId);
        Skill skillWillAdd = skillDtoConv.convertToSkill(skillReq,cv);

        Skill skillAdded = skillRepository.save(skillWillAdd);
        return skillDtoConv.convertToSkillResponse(skillAdded);
    }

}
