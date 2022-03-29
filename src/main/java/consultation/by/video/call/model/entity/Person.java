package consultation.by.video.call.model.entity;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column(name = "first_name", nullable = false)
    private String firstName;
    @Column(name = "last_name",nullable = false)
    private String lastName;
    @Column(nullable = false)
    private int age;
    @Column(nullable = false)
    private String dni;
    @Column(name = "image_url")
    private String imageUrl;
    private String country;
    private String province;
    private String city;

}
