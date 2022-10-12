
package com.springjwt;
import com.springjwt.models.ERole;
import com.springjwt.models.JwtUser;
import com.springjwt.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import java.util.Set;

@Component
@RequiredArgsConstructor
public class InitUsers implements CommandLineRunner {
    private final UserService userService;
    private final PasswordEncoder passwordEncoder;
    @Override
    public void run(String... args) throws Exception {
    //    De aici se face adaugarea userilor, pur si simplu inlocuiesti valori
//        if (userService.findUserByEmail("alexandru_zugravu@yahoo.com").isEmpty()) {
//            JwtUser u = userService.save(JwtUser.builder()
//                    .id(null)
//                    .lastName("Zugravu")
//                    .firstName("Alexandru")
//                    .email("alexandru_zugravu@yahoo.com")
//                    .password(passwordEncoder.encode("123456"))
//                    .username("alexandru_zugravu@yahoo.com")
//                    .userType(Set.of(ERole.ROLE_IT_SUPPORT))
//                    .build());
//            userService.save(u);
//        }
//        if (userService.findUserByEmail("alexandruzugra@gmail.com").isEmpty()) {
//            JwtUser u = userService.save(JwtUser.builder()
//                    .id(null)
//                    .lastName("Georgescu")
//                    .firstName("Ion")
//                    .email("alexandruzugra@gmail.com")
//                    .password(passwordEncoder.encode("123456"))
//                    .username("alexandruzugra@gmail.com")
//                    .userType(Set.of(ERole.ROLE_MANAGER))
//                    .build());
//            userService.save(u);
//        }
//        if (userService.findUserByEmail("diana.nastrut1@gmail.com").isEmpty()) {
//            JwtUser u = userService.save(JwtUser.builder()
//                    .id(null)
//                    .lastName("Nastrut")
//                    .firstName("Diana")
//                    .email("diana.nastrut1@gmail.com")
//                    .password(passwordEncoder.encode("123456"))
//                    .username("diana.nastrut1@gmail.com")
//                    .userType(Set.of(ERole.ROLE_MANAGER))
//                    .build());
//            userService.save(u);
//        }
//        if (userService.findUserByEmail("alexandru.zugravu1@s.unibuc.ro").isEmpty()) {
//            JwtUser u = userService.save(JwtUser.builder()
//                    .id(null)
//                    .lastName("Zugravu")
//                    .firstName("Alexandru")
//                    .email("alexandru.zugravu1@s.unibuc.ro")
//                    .password(passwordEncoder.encode("123456"))
//                    .username("alexandru.zugravu1@s.unibuc.ro")
//                    .userType(Set.of(ERole.ROLE_IT_SUPPORT))
//                    .build());
//            userService.save(u);
//        }
    }
}
