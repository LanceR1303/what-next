package com.bonescorp.whatsnext.controllers;

import com.bonescorp.whatsnext.entities.Job;
import com.bonescorp.whatsnext.services.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "/v1/jobs")
public class JobController {

    @Autowired
    private JobService jobService;

    @GetMapping
    public List<Job> getJobs() {
        return jobService.getJobs().getContent();
    }

    /*
    @GetMapping
    public Page<User> getUsers(@RequestParam(value = "page", defaultValue = Constants.DEFAULT_PAGE_NUMBER) int page,
                               @RequestParam(value = "size", defaultValue = Constants.DEFAULT_PAGE_SIZE) int size) {
        return userService.getAllUsers(page,size);
    }


    @DeleteMapping(path = "/{userID}")
    public ResponseEntity<ApiResponse> deleteUser(@ApiParam(value="delete user",required = true) @PathVariable("userID") UUID userID){
        return ResponseEntity.ok(new ApiResponse(true,"user removed successfully",userService.deleteUser(userID)));
    }

    @PutMapping(path = "/{userID}")
    public ResponseEntity<ApiResponse> updateUser(@PathVariable("userID") UUID userID,@Valid @RequestBody UserUpdateDTO userdataRequest){

        userService.updateUser(userID,userdataRequest);

        User user = userService.getUser(userID);

        URI location = ServletUriComponentsBuilder.fromCurrentContextPath().path("/users/{email}")
                .buildAndExpand(user.getEmail()).toUri();
        return ResponseEntity.created(location).body(new ApiResponse(true,"user  updated successfully",user));
    }


    @GetMapping(path = "/{userID}")
    public ResponseEntity<ApiResponse> getUser(@ApiParam(value="Get user by id",required = true) @PathVariable("userID") UUID userID){
        return  ResponseEntity.ok(new ApiResponse(true,"user found",this.userService.getUser(userID)));
    }

*/
}
