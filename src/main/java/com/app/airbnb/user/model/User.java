package com.app.airbnb.user.model;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

import com.app.airbnb.audit.AuditDetails;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Index;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(
  name = "users",
  uniqueConstraints = {
    @UniqueConstraint(
      name = "uk_user_email",
      columnNames = "email"
    ),
    @UniqueConstraint(
      name = "uk_user_phone",
      columnNames = "phone"
    )
  },
  indexes = {
    @Index(
      name = "idx_user_status",
      columnList = "status"
    )
  }
)
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class User extends AuditDetails {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Setter(AccessLevel.NONE)
  private Long id;

  @Column(
    name = "first_name", 
    nullable = false, 
    length = 50
  )
  private String firstName;

  @Column(
    name = "last_name", 
    nullable = false, 
    length = 50
  )
  private String lastName;

  @Column(
    name = "email", 
    nullable = false, 
    length = 100
  )
  private String email;

  @Builder.Default
  @Column(
    name = "email_verified", 
    nullable = false
  )
  private Boolean emailVerified = false;

  @Column(
    name = "phone", 
    nullable = false, 
    length = 20
  )
  private String phone;

  @Builder.Default
  @Column(
    name = "phone_verified", 
    nullable = false
  )
  private Boolean phoneVerified = false;

  @Column(
    name = "password", 
    nullable = false,
    length = 100
  )
  private String password;

  @Column(
    name = "profile_picture", 
    length = 500
  )
  private String profilePicture;

  @Column(
    name = "bio", 
    length = 1000
  )
  private String bio;

  @Column(name = "date_of_birth")
  private LocalDate dateOfBirth;

  @ManyToMany(fetch = FetchType.LAZY)
  @JoinTable(
    name = "user_roles",
    joinColumns = @JoinColumn(name = "user_id"),
    inverseJoinColumns = @JoinColumn(name = "role_id")
  )
  @Builder.Default
  private Set<Role> roles = new HashSet<>();

  @Builder.Default
  @Enumerated(EnumType.STRING)
  @Column(
    name = "status", 
    nullable = false, 
    length = 20
  )
  private UserStatus status = UserStatus.ACTIVE;
}
