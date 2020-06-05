package tn.Proxym.ProxymAcademy.security;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import tn.Proxym.ProxymAcademy.model.User;

import java.util.Collection;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class UserPrincipal implements UserDetails{


    private Long id;

    private String username;

    @JsonIgnore
    private String email;

    @JsonIgnore
    private String password;
    @JsonIgnore
    Boolean  is_verified ;

    private Collection<? extends GrantedAuthority> authorities;

    public UserPrincipal() {
        super();
        // TODO Auto-generated constructor stub
    }

    public UserPrincipal(Long id, String username, String email, String password, boolean is_verified,
                         Collection<? extends GrantedAuthority> authorities) {
        super();
        this.id = id;
        this.username = username;
        this.email = email;
        this.password = password;
        this.is_verified=is_verified ;
        this.authorities = authorities;


    }

    public static UserDetails create(User m){
        List<GrantedAuthority> authorities = m.getRoles().stream().map(role ->
                new SimpleGrantedAuthority(role.getName())).collect(Collectors.toList());
        return new UserPrincipal(
                m.getId(),
                m.getUsername(),
                m.getEmail(),
                m.getPassword(),
                m.isActive(),
                authorities
        );
    }

    public Long getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
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
        return is_verified;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        UserPrincipal that = (UserPrincipal) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id);
    }


}
