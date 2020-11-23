package com.telego.giftTime.group;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Data
@Table(name = "groups")
public class Group {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank
    @Size(min = 2, max = 30)
    private String name;
    @Size(max = 500)
    private String description;
    @NotBlank
    private LocalDate expiryDate;
    private BigDecimal amount;

    @Override
    public boolean equals(Object o) {
        if (o == null) {
            return false;
        }
        if (getClass() != o.getClass()) {
            return false;
        }
        Group otherGroup = (Group) o;
        if (getName() == null) {
            if (otherGroup.getName() != null) {
                return false;
            }
        } else if (!getName().equals(otherGroup.getName())) {
            return false;
        }
        if (getDescription() == null) {
            if (otherGroup.getDescription() != null) {
                return false;
            }
        } else if (!getDescription().equals(otherGroup.getDescription())) {
            return false;
        }
        if (getExpiryDate() == null) {
            if (otherGroup.getExpiryDate() != null) {
                return false;
            }
        } else if (!getExpiryDate().equals(otherGroup.getExpiryDate())) {
            return false;
        }
        if (getAmount() == null) {
            if (otherGroup.getAmount() != null) {
                return false;
            }
        } else if (!getAmount().equals(otherGroup.getAmount())) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        final int hash = 7;
        int result = 1;
        result = hash * result + ((getName() == null) ? 0 : getName().hashCode());
        result = hash * result + ((getDescription() == null) ? 0 : getDescription().hashCode());
        result = hash * result + ((getExpiryDate() == null) ? 0 : getExpiryDate().hashCode());
        result = hash * result + ((getAmount() == null) ? 0 : getAmount().hashCode());
        return result;
    }


}
