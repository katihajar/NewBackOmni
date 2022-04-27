package com.example.omnicons.services;

import com.example.omnicons.bean.User;
import com.example.omnicons.Dao.UserRepository;
import com.example.omnicons.util.JwtUtil;
import org.apache.commons.lang3.RandomStringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.example.omnicons.filter.JwtConstant.JWT_TOKEN_HEADER;
import static org.springframework.http.HttpStatus.OK;


@Service
public class UserService implements UserDetailsService {

    public Map<Long , User> connectedUser = new HashMap<>();
    private Logger LOGGER = LoggerFactory.getLogger(getClass());
    public JavaMailSender mailSender;
    @Autowired
    UserRepository userRepository;
    @Autowired
    private RoleService roleService;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private JwtUtil jwtUtil;
    public ResponseEntity<User> signIn(User user) {
        try {
           // authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(user.getUsername(), user.getPassword()));
            User loadUserByUsername = findByUsernameAndPassword(user.getUsername(), user.getPassword());
            HttpHeaders jwtHeader = getJwtHeader(user);

            if (loadUserByUsername.getRole().equals("ROLE_ADMIN")){
                System.out.println("connected");
                this.connectedUser.put(loadUserByUsername.getIduser(), loadUserByUsername);
            }
            return new ResponseEntity<>(loadUserByUsername, jwtHeader, OK);
        } catch (BadCredentialsException e) {
            throw new BadCredentialsException("bad creditiel for username " + user.getUsername());
        }

    }
    private HttpHeaders getJwtHeader(User user) {
        HttpHeaders headers = new HttpHeaders();
        headers.add(JWT_TOKEN_HEADER, jwtUtil.generateToken(user));
        return headers;
    }
   /* public String sig(User user) {
       // User loadUserByUsername = userRepository.findByUsername(SecurityContextHolder.getContext().getAuthentication().getPrincipal().toString());
        try {
            System.out.println("Enter try");
            System.out.println(user.getUsername());
            System.out.println(user.getPassword());
            System.out.println("End try");
            User loadUserByUsername = userRepository.findByUsername(user.getUsername());
            String token = jwtUtil.generateToken(loadUserByUsername);
                System.out.println("KAIN");
                System.out.println(token);
                return token;
        } catch (BadCredentialsException e) {
            System.out.println("catch");
            throw new BadCredentialsException("bad creditiel for username " + user.getUsername());
        }

    }*/
    /*public User signIn(User user) {
        try {
            System.out.println("Enter try");
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(user.getUsername(), user.getPassword()));
            System.out.println("End try");
        } catch (BadCredentialsException e) {
            System.out.println("catch");
            throw new BadCredentialsException("bad creditiel for username " + user.getUsername());
        }
        User loadUserByUsername = loadUserByUsername(user.getUsername());
        String token = jwtUtil.generateToken(loadUserByUsername);
        return loadUserByUsername;
    }
/**/
    public User findUserByIduser(Long id) {
        return userRepository.findUserByIduser(id);
    }

    public User findUserByEmailUser(String email) {
        return userRepository.findUserByEmailUser(email);
    }

    public List<User> findAll() {
        return userRepository.findAll();
    }


    public User save(User user) {
        System.out.println(user.getUsername());
        System.out.println(user.getPassword());
        System.out.println(user.getAuthorities());
        User loadedUser = userRepository.findByUsername(user.getUsername());
        if (loadedUser != null)
            return null;
        else {
            prepareMessage(user);
            user.setPassword(passwordEncoder.encode(user.getPassword()));
            roleService.save(user.getAuthorities());
            return userRepository.save(user);
        }
    }

    public void prepareMessage(User user) {
        System.out.println("prepare email ");
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom("elearningMarrakech@gmail.com");
        message.setTo(user.getUsername());
        message.setSubject("accepted on the platform e-learning");
        message.setText("Your online registration on the site: http://localhost:4200/#/ is validated. \n" + "You can log into your account now.\n" +
                "Your account settings are :" + "\n" +
                "username : " + user.getUsername() + "\n" +
                "password : " + user.getPassword());
        mailSender.send(message);
        System.out.println("email send");

    }




    public Boolean deleteUser(Long idUser) {
        if(!userRepository.existsById(idUser)) return false;
        userRepository.deleteById(idUser);
        return true;
    }
    public User loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByUsername(username);
        if (user == null ) {
            throw new UsernameNotFoundException("user " + username + " not founded");
        } else {
            return user;
        }
    }

    public User findByUsernameAndPassword(String username, String pass) {
        User user =userRepository.findByUsernameAndPassword(username, pass);
        if (user == null ) {
            throw new UsernameNotFoundException("user " + username + " not founded");
        } else {
            return user;
        }
    }

    public String generatePassword() {
        return RandomStringUtils.randomAlphanumeric(10);
    }


    public User updateUser(User user) {
        System.out.println(user.getIduser());
        User localUser = loadUserByUsername(user.getUsername());
        localUser.setNomUser(user.getNomUser());
        localUser.setPrenomUser(user.getPrenomUser());
        localUser.setEmailUser(user.getEmailUser());
        return userRepository.save(localUser);
    }
    public int resetPassword(String username) {
        User user = this.loadUserByUsername(username);
        if (user == null) {
            return -1;
        } else {
            String password = this.generatePassword();
            user.setPassword(password);
            System.out.println(user.getPassword());
            System.out.println(user.getUsername());
            prepareMessage(user);
            user.setPassword(passwordEncoder.encode(password));
            userRepository.save(user);
            return 0;
        }
    }
}
