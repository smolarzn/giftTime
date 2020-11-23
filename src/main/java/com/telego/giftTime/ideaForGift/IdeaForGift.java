package com.telego.giftTime.ideaForGift;

import com.telego.giftTime.image.Image;
import com.telego.giftTime.user.User;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.List;

@Entity
@Table(name = "gift_ideas")
@Data
public class IdeaForGift {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank
    @Size(min = 5, max = 500)
    private String description;
    @ManyToOne
    private User userWithIdea;
    @ManyToMany
    @JoinTable(name = "ideas_userToBestow", joinColumns = @JoinColumn(name = "idea_id"),
    inverseJoinColumns = @JoinColumn(name = "user_id"))
    private List<User> userToBestow;
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "id")
    private List<Image> image;


}
