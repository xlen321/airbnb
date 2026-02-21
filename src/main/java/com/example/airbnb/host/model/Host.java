package com.example.airbnb.host.model;

import java.time.LocalDateTime;
import java.util.UUID;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import com.example.airbnb.common.exception.UnauthorizedException;
import com.example.airbnb.host.enums.GovtIdType;
import com.example.airbnb.host.enums.HostStatus;
import com.example.airbnb.user.model.User;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Index;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(
    name = "hosts",
    indexes = {
        @Index(name = "idx_govt_id_type", columnList = "govt_id_type"),
        @Index(name = "idx_host_status", columnList = "host_status")
    }
)
@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Host {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @OneToOne(optional = false)
    @JoinColumn(name = "user_id", nullable = false, unique = true)
    private User user;

    @Enumerated(EnumType.STRING)
    @Column(name = "govt_id_type", nullable = false)
    private GovtIdType govtIdType;

    @Column(name = "govt_id_number", nullable = false)
    private String govtIdNumber;

    @Enumerated(EnumType.STRING)
    @Column(name = "host_status", nullable = false)
    private HostStatus hostStatus = HostStatus.PENDING;

    @Column(name = "verified_at")
    private LocalDateTime verifiedAt;

    @CreationTimestamp
    @Column(name = "created_at", nullable = false, updatable = false)
    private LocalDateTime createdAt;

    @UpdateTimestamp
    @Column(name = "updated_at", nullable = false)
    private LocalDateTime updatedAt;

    public static Host create(User user, GovtIdType idType, String idNumber) {
        if (!Boolean.TRUE.equals(user.getEmailVerified()) || Boolean.TRUE.equals(user.getPhoneverified()))
            throw new UnauthorizedException("Email and Phone must be verified before host access.");

        Host host = new Host();
        host.user = user;
        host.govtIdType = idType;
        host.govtIdNumber = idNumber;

        return host;
    }

    public void approve() {
        if (this.hostStatus != HostStatus.PENDING)
            throw new IllegalStateException("Host is not in pending state");

        this.hostStatus = HostStatus.APPROVED;
        this.verifiedAt = LocalDateTime.now();
    }

    public void reject() {
        if (this.hostStatus != HostStatus.PENDING)
            throw new IllegalStateException("Host is not in pending state");

        this.hostStatus = HostStatus.REJECTED;
    }

    public void suspend() {
        this.hostStatus = HostStatus.SUSPENDED;
    }

    public boolean isApproved() {
        return this.hostStatus == HostStatus.APPROVED;
    }
}
