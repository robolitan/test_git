package ua.hibernate.model.embeddable;

import lombok.*;
import lombok.extern.apachecommons.CommonsLog;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Embedded;

@Embeddable
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
public class FileName {

    @Column(name = "FILENAME")
    private String filename;

    @Column(name = "EXTENTION")
    private String extention;
}
