package com.example.RTH.dto;

import com.example.RTH.Enum.RoleType;
import com.example.RTH.entity.Member;
import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.*;
import org.jetbrains.annotations.NotNull;


@AllArgsConstructor
@ToString
@Getter
@NoArgsConstructor
@Data
@Valid
public class MemberDTO {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", updatable = false)
    private Long id;

    @NotBlank(message = "아이디는 필수 입력 항목입니다.")
    @Size(min = 5, max = 20, message = "아이디는 한 글자 이상 20자 미만으로 입력해야합니다.")
    @Column(name = "username", nullable = false, unique = true)
    private String username; //아이디

    @NotBlank(message = "비밀번호는 필수 입력 항목입니다.")
    @Size(min = 5, max = 20, message = "비밀번호는 한 글자 이상 20자 미만으로 입력해야합니다.")
    @Column(name = "password")
    private String password; //비밀번호

    @Column(name = "nickname", nullable = false, unique = true)
    private String nickname; //닉네임

    @Column
    private RoleType role;

    public Member toEntity() {
        return new Member(id, username, password, nickname, role);
    }
}