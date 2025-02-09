package com.restaurant.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.restaurant.app.entity.Address;
import com.restaurant.app.entity.User;
import com.restaurant.app.service.AddressService;
import com.restaurant.app.service.UserService;
import com.restaurant.app.vo.AddressVO;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/")
public class AddressController {

    @Autowired
    private UserService userService;

    @Autowired
    private AddressService addressService;

    /**
     * This api endpoint is used to save address for a customer
     * @return ResponseEntity<AddressVO> type object along with HttpStatus Ok
     */
    @CrossOrigin
    @PostMapping(path = "/address", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<AddressVO> saveAddress(
            @RequestBody final AddressVO saveAddressRequest,
            @RequestHeader("authorization") final String authorization
            )
            //throws AuthorizationFailedException, SaveAddressException, AddressNotFoundException
    {
        String accessToken = authorization.split("Bearer ")[1];
        User user = userService.getUser(accessToken);

        final AddressVO savedAddress = addressService.saveAddress(saveAddressRequest, user);
        return new ResponseEntity<AddressVO>(savedAddress, HttpStatus.CREATED);
    }

}