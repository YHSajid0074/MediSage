package com.example.MediSage.auth.controller;

import com.example.MediSage.auth.dto.request.UserRequestDTO;
import com.example.MediSage.auth.dto.request.UserRoleRequestDTO;
import com.example.MediSage.auth.dto.response.CustomUserResponseDTO;
import com.example.MediSage.auth.repository.UserRepo;
import com.example.MediSage.auth.service.UserServiceIMPL;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@RestController
@RequestMapping( "/User" )
public class UserController {

    private UserServiceIMPL userService;
    UserRepo userRepo;

    public UserController( UserServiceIMPL userService ,UserRepo userRepo ) {
        this.userRepo = userRepo;
        this.userService = userService;
    }


    @PostMapping(value = "/add", consumes = {MediaType.MULTIPART_FORM_DATA_VALUE})
    public ResponseEntity< String > create(@ModelAttribute UserRequestDTO requestDto) throws IOException {
      String s=  userService.create(requestDto);
        return ResponseEntity.ok(s);
    }

    @PostMapping("/validate")
    public String validateOtp(@RequestParam String email, @RequestParam String otp) {
        return userService.validateOtp(email, otp);
    }

    @GetMapping( "{id}" )
    public ResponseEntity<CustomUserResponseDTO> readOne(@PathVariable( "id" ) Long id ) {
        return ResponseEntity
                .ok()
                .body( userService.readOne( id ) );
    }

    @PostMapping( "change-roles" )
    public ResponseEntity<String> setUserRoles(@RequestBody UserRoleRequestDTO requestDTO ) {
        userService.setUserRoles( requestDTO ) ;
        return ResponseEntity.ok("Successfully set user roles");
    }

    @DeleteMapping
    public ResponseEntity<String>delete(@RequestParam Long id ) {
        userRepo.deleteById( id );
        return ResponseEntity.ok("Successfully deleted user");
    }

    @PutMapping(value = "/update", consumes = {MediaType.MULTIPART_FORM_DATA_VALUE})
    public ResponseEntity<String>Update(@RequestParam Long id, @ModelAttribute UserRequestDTO requestDTO ) throws IOException {
        userService.updateUser(id,requestDTO);
        return ResponseEntity.ok("Successfully updated user");
    }

    @GetMapping("search/{username}")
    public ResponseEntity<CustomUserResponseDTO> searchByUserName(@PathVariable("username") String username) {
        return ResponseEntity.ok(userService.searchByUsername(username));
    }

}