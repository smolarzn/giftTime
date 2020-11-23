package com.telego.giftTime.groupUsers;

import com.telego.giftTime.group.Group;
import com.telego.giftTime.user.User;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Objects;

@Entity
@Data
@RequiredArgsConstructor
public class GroupUsers {

    @EmbeddedId
    private GroupUsersId id;
    @OneToOne
    @MapsId("userId")
    private User user;
    @OneToOne
    @MapsId("groupId")
    private Group group;
    private String nickname;
    @OneToOne
    private User userToBestow;

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        GroupUsers other = (GroupUsers) o;
        if (user == null) {
            if (other.user != null) {
                return false;
            }
        } else if (!user.equals(other.user)) {
            return false;
        }
        if (group == null) {
            if (other.group != null) {
                return false;
            }
        } else if (!group.equals(other.group)) {
            return false;
        }
        if (nickname == null) {
            if (other.nickname != null) {
                return false;
            }
        } else if (!nickname.equals(other.nickname)) {
            return false;
        }
        if (userToBestow == null) {
            if (other.userToBestow != null) {
                return false;
            }
        } else if (!userToBestow.equals(other.userToBestow)) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        return Objects.hash(user, group);
    }
}
