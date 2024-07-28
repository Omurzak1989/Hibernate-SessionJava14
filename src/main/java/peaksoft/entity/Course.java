package peaksoft.entity;

import jakarta.persistence.*;
import lombok.*;
import peaksoft.enums.StudyFormat;

@Entity
@Table(name = "course")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString

public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "course_gen")
    @SequenceGenerator(name = "course_gen",
                      sequenceName = "course_seq",
                      allocationSize = 1,initialValue = 1)
    private Long id;
    @Column(name = "corse_name")
    private String courseName;
    private int price;
    @Enumerated(EnumType.STRING)
    private StudyFormat studyFormat;

    public Course(String courseName, int price, StudyFormat studyFormat) {
        this.courseName = courseName;
        this.price = price;
        this.studyFormat = studyFormat;
    }
}
