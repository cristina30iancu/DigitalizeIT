
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
    // De aici se face adaugarea userilor, pur si simplu inlocuiesti valori
//        if (userService.findUserByEmail("ana@gmail.com").isEmpty()) {
//            JwtUser u = userService.save(JwtUser.builder()
//                    .id(null)
//                    .lastName("Popescu")
//                    .firstName("Ana")
//                    .email("ana@gmail.com")
//                    .password(passwordEncoder.encode("123456"))
//                    .username("ana")
//                    .userType(Set.of(ERole.ROLE_IT_SUPPORT))
//                    .build());
//            userService.save(u);
//        }
//        if (userService.findUserByEmail("ion@gmail.com").isEmpty()) {
//            JwtUser u = userService.save(JwtUser.builder()
//                    .id(null)
//                    .lastName("Georgescu")
//                    .firstName("Ion")
//                    .email("ion@gmail.com")
//                    .password(passwordEncoder.encode("123456"))
//                    .username("ion")
//                    .userType(Set.of(ERole.ROLE_MANAGER))
//                    .build());
//            userService.save(u);
//        }
//        if (userService.findUserByEmail("ionescu@gmail.com").isEmpty()) {
//            JwtUser u = userService.save(JwtUser.builder()
//                    .id(null)
//                    .lastName("Ionescu")
//                    .firstName("Anghel")
//                    .email("ionescu@gmail.com")
//                    .password(passwordEncoder.encode("123456"))
//                    .username("ionescu")
//                    .userType(Set.of(ERole.ROLE_MANAGER))
//                    .build());
//            userService.save(u);
//        }
//
    }
}
