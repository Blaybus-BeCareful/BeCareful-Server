package com.becareful.becarefulserver.domain.recruitment.dto.response;

import com.becareful.becarefulserver.domain.recruitment.domain.Recruitment;
import com.becareful.becarefulserver.domain.socialworker.domain.Elderly;
import com.becareful.becarefulserver.domain.socialworker.domain.NursingInstitution;

public record RecruitmentDetailResponse(
        RecruitmentInfoResponse recruitmentInfo,
        ElderlyInfoResponse elderlyInfo,
        InstitutionInfoResponse institutionInfo,
        boolean isHotRecruitment,
        boolean isHourlySalaryTop,
        Integer matchRate
) {

    public static RecruitmentDetailResponse from(
            Recruitment recruitment,
            boolean isHotRecruitment,
            boolean isHourlySalaryTop,
            Integer matchRate
    ) {
        Elderly elderly = recruitment.getElderly();
        NursingInstitution institution = elderly.getNursingInstitution();

        return new RecruitmentDetailResponse(
                RecruitmentInfoResponse.from(recruitment, elderly),
                ElderlyInfoResponse.from(elderly),
                InstitutionInfoResponse.from(institution),
                isHotRecruitment,
                isHourlySalaryTop,
                matchRate
        );
    }
}
