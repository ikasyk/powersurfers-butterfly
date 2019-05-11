package io.powersurfers.butterfly.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "users")
@Data
@NoArgsConstructor
public class User {
    @Id
    @GeneratedValue
    @Column(name = "user_id", unique = true)
    private Integer id;

    @Column(name = "user_unique_guid")
    private String uniqueGuid;

    @Column(name = "user_login")
    private String login;
}
