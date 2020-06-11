package ua.hibernate.model;

import lombok.*;
import org.hibernate.envers.Audited;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import ua.hibernate.model.embeddable.FileName;
import ua.hibernate.model.embeddable.Image;

import javax.persistence.*;
import javax.persistence.Entity;
import javax.persistence.NamedNativeQueries;
import javax.persistence.NamedNativeQuery;
import javax.persistence.Table;
import java.time.LocalDateTime;
import java.util.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
@NamedNativeQueries(@NamedNativeQuery(name = "justForTest", query = "" +
        "select * from actor where actor_id = :actor_id"))
@Table(name = "actor")
@ToString
@Audited
public class Actor implements Person{

    public static final String PROFILE_JOIN_SELLER = "JoinSeller";
    public static final String PROFILE_JOIN_BIDS = "Join_Bids";
    @Version
    protected long version;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "actor_id")
    private short id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name", unique = true)
    private String last_name;

    @Column(name = "last_update")
    private LocalDateTime time;

    @ElementCollection(fetch = FetchType.EAGER)
    @CollectionTable(name = "IMAGE")
    private Map<FileName,Image> map = new HashMap<>();

    @PrePersist
    public void notifMe(){
        System.out.println("********Pre persist");
    }

    @PostPersist
    public void notifMeAfter(){
        System.out.println("********Post persist");
    }
















  /*  @ElementCollection(fetch = FetchType.EAGER)
    @CollectionTable(name = "IMAGE",
            joinColumns = @JoinColumn(name = "ACT_ID"))
    private Set<String> image = new HashSet<String>();*/

    /*@ElementCollection(fetch = FetchType.EAGER)
    @CollectionTable(name = "PERSON_IMAGES", joinColumns = @JoinColumn(name = "ACT_ID"))
    @OrderColumn
    @Column(name = "IMAGEFILE")
    private List<String> image = new ArrayList<>();*/


//    @ElementCollection(fetch = FetchType.EAGER)
//    @CollectionTable(name = "IMAGE", joinColumns = @JoinColumn(name = "ACTOR_ID"))
//    @MapKeyColumn(name = "IMAGEKEY")
//    @Column(name = "FILENAME")
//    private Map<Long, String> someMap = new HashMap<>();
/*
    @ElementCollection(fetch = FetchType.LAZY)
    @CollectionTable(name = "PERSON_CARS",
            joinColumns = @JoinColumn(name = "ACT_ID"))
    @CollectionId(
            type = @Type(type = "long"),
            generator = "identity",
            columns = @Column(name = "CAR_ID"))
    @Column(name = "CARS")
    @Fetch(FetchMode.SUBSELECT)
    private Collection<String> cars = new ArrayList<>();*/
}
