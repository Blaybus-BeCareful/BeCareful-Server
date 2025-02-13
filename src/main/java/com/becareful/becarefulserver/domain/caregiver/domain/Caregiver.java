package com.becareful.becarefulserver.domain.caregiver.domain;

import jakarta.persistence.AttributeOverride;
import jakarta.persistence.Column;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import com.becareful.becarefulserver.domain.caregiver.domain.vo.Address;
import com.becareful.becarefulserver.global.common.domain.BaseEntity;
import com.becareful.becarefulserver.global.common.vo.Gender;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Caregiver extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "caregiver_id")
    private Long id;

    private String name;

    @Enumerated(EnumType.STRING)
    private Gender gender;

    private String phoneNumber;

    private String password;

    @Embedded
    private Address address;

    private boolean isHavingCar;

    private boolean isCompleteDementiaEducation;

    private boolean isAgreedToTerms;

    private boolean isAgreedToCollectPersonalInfo;

    private boolean isAgreedToReceiveMarketingInfo;

    private String profileImageUrl;

    @Builder
    private Caregiver(String name, Gender gender, String phoneNumber, String password, Address address,
            boolean isHavingCar, boolean isCompleteDementiaEducation, boolean isAgreedToTerms,
            boolean isAgreedToCollectPersonalInfo, boolean isAgreedToReceiveMarketingInfo,
            String profileImageUrl) {
        this.name = name;
        this.gender = gender;
        this.phoneNumber = phoneNumber;
        this.password = password;
        this.address = address;
        this.isHavingCar = isHavingCar;
        this.isCompleteDementiaEducation = isCompleteDementiaEducation;
        this.isAgreedToTerms = isAgreedToTerms;
        this.isAgreedToCollectPersonalInfo = isAgreedToCollectPersonalInfo;
        this.isAgreedToReceiveMarketingInfo = isAgreedToReceiveMarketingInfo;
        this.profileImageUrl = profileImageUrl;
    }
}
