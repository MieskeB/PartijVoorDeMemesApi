package nl.partijvoordememes.api.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Member {
    @Id
    private String id;
    private String name;
    private String email;
}
