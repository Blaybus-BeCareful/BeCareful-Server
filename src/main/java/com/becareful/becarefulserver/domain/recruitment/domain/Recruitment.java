package com.becareful.becarefulserver.domain.recruitment.domain;


import jakarta.persistence.Column;
import jakarta.persistence.Convert;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

import com.becareful.becarefulserver.domain.caregiver.domain.WorkSalaryType;
import com.becareful.becarefulserver.domain.caregiver.domain.converter.CareTypeSetConverter;
import com.becareful.becarefulserver.domain.caregiver.domain.converter.DayOfWeekSetConverter;
import com.becareful.becarefulserver.domain.common.domain.BaseEntity;
import com.becareful.becarefulserver.domain.common.domain.CareType;
import com.becareful.becarefulserver.domain.recruitment.dto.request.RecruitmentCreateRequest;
import com.becareful.becarefulserver.domain.socialworker.domain.Elderly;

import java.time.DayOfWeek;
import java.time.LocalTime;
import java.util.EnumSet;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Recruitment extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "recruitment_id")
    private Long id;

    private String title;

    @Convert(converter = DayOfWeekSetConverter.class)
    private EnumSet<DayOfWeek> workDays;

    private LocalTime workStartTime;

    private LocalTime workEndTime;

    @Convert(converter = CareTypeSetConverter.class)
    private EnumSet<CareType> careTypes;

    private WorkSalaryType workSalaryType;

    private int workSalaryAmount;

    private String description;

    private boolean isRecruiting = true;

    @JoinColumn(name = "elderly_id")
    @ManyToOne(fetch = FetchType.LAZY)
    private Elderly elderly;

    @Builder(access = AccessLevel.PRIVATE)
    private Recruitment(String title, EnumSet<DayOfWeek> workDays, LocalTime workStartTime,
            LocalTime workEndTime, EnumSet<CareType> careTypes, WorkSalaryType workSalaryType,
            int workSalaryAmount, String description, boolean isRecruiting, Elderly elderly) {
        this.title = title;
        this.workDays = workDays;
        this.workStartTime = workStartTime;
        this.workEndTime = workEndTime;
        this.careTypes = careTypes;
        this.workSalaryType = workSalaryType;
        this.workSalaryAmount = workSalaryAmount;
        this.description = description;
        this.isRecruiting = isRecruiting;
        this.elderly = elderly;
    }

    public static Recruitment create(RecruitmentCreateRequest request, Elderly elderly) {
        return Recruitment.builder()
                .title(request.title())
                .workDays(EnumSet.copyOf(request.workDays()))
                .workStartTime(request.workStartTime())
                .workEndTime(request.workEndTime())
                .careTypes(EnumSet.copyOf(request.careTypes()))
                .workSalaryType(request.workSalaryType())
                .workSalaryAmount(request.workSalaryAmount())
                .description(request.description())
                .isRecruiting(true)
                .elderly(elderly)
                .build();
    }
}
