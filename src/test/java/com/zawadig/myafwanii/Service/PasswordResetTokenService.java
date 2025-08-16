package com.zawadig.myafwanii.Service;



import com.zawadig.myafwanii.Model.Customer;
import com.zawadig.myafwanii.Model.PasswordResetToken;
import com.zawadig.myafwanii.Repository.PasswordResetTokenRepository;
import com.zawadig.myafwanii.Repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;
import java.util.UUID;

@Service
public class PasswordResetTokenService {

    private static final int EXPIRATION_HOURS = 1;

    @Autowired
    private PasswordResetTokenRepository tokenRepository;

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    // Generate and save token
    public String createPasswordResetToken(Customer customer) {
        String token = UUID.randomUUID().toString();

        LocalDateTime expiryDate = LocalDateTime.now().plusHours(EXPIRATION_HOURS);

        PasswordResetToken resetToken = new PasswordResetToken(token, customer, expiryDate);

        tokenRepository.save(resetToken);

        return token;
    }

    // Reset password using token
    public boolean resetPassword(String token, String newPassword) {
        Optional<PasswordResetToken> tokenOpt = tokenRepository.findByToken(token);

        if (tokenOpt.isEmpty()) return false;

        PasswordResetToken resetToken = tokenOpt.get();

        if (resetToken.isExpired()) {
            tokenRepository.delete(resetToken);
            return false;
        }

        Customer customer = resetToken.getCustomer();
        customer.setPassword(passwordEncoder.encode(newPassword));
        customerRepository.save(customer);

        // Delete token after use
        tokenRepository.delete(resetToken);

        return true;
    }
}
