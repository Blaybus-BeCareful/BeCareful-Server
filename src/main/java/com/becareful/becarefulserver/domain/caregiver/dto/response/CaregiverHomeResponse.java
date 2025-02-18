package com.becareful.becarefulserver.domain.caregiver.dto.response;

import com.becareful.becarefulserver.domain.caregiver.domain.Caregiver;

import io.swagger.v3.oas.annotations.media.Schema;
import java.util.List;
import lombok.AccessLevel;
import lombok.Builder;

@Builder(access = AccessLevel.PRIVATE)
public record CaregiverHomeResponse(
        String name,
        Integer applicationCount,
        Integer recruitmentCount,
        @Schema(description = "더미 데이터이므로 변경될 수 있습니다.")
        List<WorkScheduleResponse> workScheduleList,
        boolean isWorking
) {
    public static CaregiverHomeResponse createNotHavingWorkApplication(Caregiver caregiver) {
        return CaregiverHomeResponse.builder()
                .name(caregiver.getName())
                .applicationCount(0)
                .recruitmentCount(0)
                .workScheduleList(List.of(
                        WorkScheduleResponse.createDummy(),
                        WorkScheduleResponse.createDummy()))
                .isWorking(false)
                .build();
    }

    public static CaregiverHomeResponse of(Caregiver caregiver, Integer applicationCount, Integer recruitmentCount, boolean isWorking) {
        return CaregiverHomeResponse.builder()
                .name(caregiver.getName())
                .applicationCount(applicationCount)
                .recruitmentCount(recruitmentCount)
                .workScheduleList(List.of(
                        WorkScheduleResponse.createDummy(),
                        WorkScheduleResponse.createDummy()))
                .isWorking(isWorking)
                .build();
    }
}
