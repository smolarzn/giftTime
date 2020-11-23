package com.telego.giftTime.groupUsers;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
@Data
public class GroupUsersId implements Serializable {

    @Column(name = "user_id")
    private Long userId;

    @Column(name = "group_id")
    private Long groupId;

    public GroupUsersId(Long userId, Long groupId) {
        this.userId = userId;
        this.groupId = groupId;
    }

    public GroupUsersId() {
    }



    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        GroupUsersId other = (GroupUsersId) o;
        return Objects.equals(userId, other.userId) && Objects.equals(groupId, other.groupId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userId, groupId);
    }
}
