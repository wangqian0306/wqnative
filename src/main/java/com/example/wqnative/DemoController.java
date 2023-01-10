package com.example.wqnative;

import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Slf4j
@RestController
@CrossOrigin
@RequestMapping("/demo")
public class DemoController {

    @Resource
    private UserRepository userRepository;

    @PostMapping
    public HttpEntity<User> insert(@RequestBody User user) {
        log.error(user.toString());
        return new HttpEntity<>(userRepository.save(user));
    }

    @GetMapping
    public HttpEntity<User> get(@RequestParam Long id) {
        Optional<User> optionalUser = userRepository.findById(id);
        if (optionalUser.isPresent()) {
            return new HttpEntity<>(optionalUser.get());
        } else {
            throw new RuntimeException("no such user");
        }
    }

}
