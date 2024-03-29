package com.maru.socialnetwork4.Model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.maru.socialnetwork4.Utils.CustomJSONDeserializer;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.io.Serializable;
import java.util.*;

@Entity
@Table(name = "user")
public class User implements UserDetails, Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true, nullable = false)
    private int id;
    @Column(name = "username", unique = true, nullable = false)
    private String username;
    @Column(name = "password", nullable = false)
    private String password;
    @Column(name = "fullname")
    private String fullName;
    @Column(name = "dob")
    private String dob;
    @Column(name = "note")
    private String note;
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    @JsonBackReference(value = "user_post")
    private List<Post> posts;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    @JsonBackReference(value = "user_comment")
    private List<Comment> comments;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    @JsonBackReference(value = "user_grantedRole")
    private List<GrantedRole> grantedRoles;


    public User() {
        this.posts = new ArrayList<>();
        this.comments = new ArrayList<>();
        this.grantedRoles = new ArrayList<>();
    }

    public User(String username, String password, String fullName, String dob, String note) {
        this.username = username;
        this.password = password;
        this.fullName = fullName;
        this.dob = dob;
        this.note = note;
        this.posts = new ArrayList<>();
        this.comments = new ArrayList<>();
        this.grantedRoles = new ArrayList<>();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    /*
    * wrong description
    * com.fasterxml.jackson.databind.exc.InvalidDefinitionException: Cannot construct instance of
    * org.springframework.security.core.GrantedAuthority (no Creators, like default constructor, exist): abstract types either need to be
    * mapped to concrete types, have custom deserializer, or contain additional type information
    * Although the class implement serialization, the collection cannot be parsed
    * In fact, the deserialization of the spring security permission set failed
    *
    * https://blog.csdn.net/weixin_44353507/article/details/113596584
    * */
    @Override
    @JsonDeserialize(using = CustomJSONDeserializer.class)
    public Collection<? extends GrantedAuthority> getAuthorities() {
        Set<SimpleGrantedAuthority> authorities = new HashSet<>();
        if (grantedRoles.size() == 0) {
            authorities.add(new SimpleGrantedAuthority("NOT-A-ROLE!"));
        } else for (GrantedRole grantedRole : grantedRoles) {
            authorities.add(new SimpleGrantedAuthority(grantedRole.getRole().getName()));
        }
        return authorities;
    }

    @Override
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public List<Post> getPosts() {
        return posts;
    }

    public void setPosts(List<Post> posts) {
        this.posts = posts;
    }

    public List<Comment> getComments() {
        return comments;
    }

    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }

    public List<GrantedRole> getGrantedRoles() {
        return grantedRoles;
    }

    public void setGrantedRoles(List<GrantedRole> grantedRoles) {
        this.grantedRoles = grantedRoles;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", fullName='" + fullName + '\'' +
                ", dob='" + dob + '\'' +
                ", note='" + note + '\'' +
                ", posts=" + posts +
                ", comments=" + comments +
                '}';
    }
}
