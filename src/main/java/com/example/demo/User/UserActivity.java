package com.example.demo.User;

import java.util.Optional;

public interface UserActivity {

    Optional<Client> fetchUser(String userId);

    Client saveUser(Client user);

}
