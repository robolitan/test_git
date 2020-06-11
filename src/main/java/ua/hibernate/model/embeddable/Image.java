package ua.hibernate.model.embeddable;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class Image {

    @Column(name = "TITLE")
    private String title;
    private int width;
    private int height;

}
