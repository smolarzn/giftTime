package com.telego.giftTime.user;

import com.telego.giftTime.role.Role;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.Set;

@Entity
@Table(name = "users")
@Data
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank
    @Size(min = 3, max = 25)
    private String name;
    @Column(unique = true)
    @NotBlank
    private String email;
    @NotBlank
    private String password;
    private int enabled;
    @Column
    @Lob
    private byte[] picture;
    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinTable(name = "user_role", joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Set<Role> roles;

    @Override
    public boolean equals(Object o) {
        if (o == null) {
            return false;
        }
        if (this.getClass() != o.getClass()) {
            return false;
        }
        User otherUser = (User) o;
        if (getName() == null) {
            if (otherUser.getName() != null) {
                return false;
            }
        } else if (!getName().equals(otherUser.getName())) {
            return false;
        }
        if (getEmail() == null) {
            if (otherUser.getEmail() != null) {
                return false;
            }
        } else if (!getEmail().equals(otherUser.getEmail())) {
            return false;
        }
        if (getPassword() == null) {
            if (otherUser.getPassword() != null) {
                return false;
            }
        } else if (!getPassword().equals(otherUser.getPassword())) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        final int hash = 7;
        int result = 1;
        result = hash * result + ((getName() == null) ? 0 : getName().hashCode());
        result = hash * result + ((getPassword() == null) ? 0 : getPassword().hashCode());
        result = hash * result + ((getEmail() == null) ? 0 : getEmail().hashCode());
        return result;
    }
}
