package dev.pinetree20s.learnspringcorebasic.member;

public class Member {
    private Long id;
    private String name;
    private MemberGrade grade;

    public Member(Long id, String name, MemberGrade grade) {
        this.id = id;
        this.name = name;
        this.grade = grade;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public MemberGrade getGrade() {
        return grade;
    }
}
