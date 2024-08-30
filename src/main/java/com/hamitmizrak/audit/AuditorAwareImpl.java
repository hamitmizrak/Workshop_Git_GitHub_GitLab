package com.hamitmizrak.audit;

import lombok.extern.log4j.Log4j2;
import org.springframework.data.domain.AuditorAware;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

import java.util.Optional;

// LOMBOK
@Log4j2

@Component // Bu nesne Spring nesnesinin artık bir parçasıdır.
public class AuditorAwareImpl implements AuditorAware<String> {

    // OVERRIDE
    @Override
    public Optional<String> getCurrentAuditor() {
        // Database giriş yapmış kullanıcı bilgilerini göstermek
        Authentication authentication= SecurityContextHolder.getContext().getAuthentication();

        //Sisteme girmiş kullanıcı  var mı
        if(authentication!=null && authentication.isAuthenticated()){
            System.out.println("Sisteme Girmiş "+ authentication.getName());
            log.info("Sisteme Girmiş "+ authentication.getName());
            log.info("Sisteme Girmiş "+ authentication.getPrincipal());
            return Optional.of(authentication.getName());
        }
        return Optional.of("HamitM.");
    } //end getCurrentAuditor
} //end class
