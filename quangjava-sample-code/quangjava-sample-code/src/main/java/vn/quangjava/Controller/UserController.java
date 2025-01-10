package vn.quangjava.Controller;

import org.springframework.web.bind.annotation.*;
import vn.quangjava.DTO.Request.UserRequestDTO;

import java.util.List;

@RestController
@RequestMapping("/user")
//@CrossOrigin(origins = "http://localhost:8081")
public class UserController {

    @PostMapping("/")
    public String addUser(@RequestBody UserRequestDTO userDTO){
        return "User added" ;
    }

    @PutMapping("/{usedID}")
    public String updateUser(@PathVariable int usedID , @RequestBody UserRequestDTO userDTO) {
        System.out.println("Request update userID : " + usedID);
        return "User updated" ;
    }

    @PatchMapping("/{usedID}")
    public String changeStatus(@PathVariable int usedID ,
                               @RequestParam(required = false) boolean status) {
        System.out.println("Request change userID : " + usedID);
        return "User status changed" ;
    }

    @DeleteMapping("/{userID}")
    public String deleteUser(@PathVariable int userID){
        System.out.println("Request delete userID : " +userID);
        return "User deleted";
    }

    @GetMapping("/{userID}")
    public UserRequestDTO getDetailUser(@PathVariable int userID) {
        System.out.println("Request get infor detail userID : " +userID);
        return new UserRequestDTO("Le" , "Quang" , "0348773921" , "email") ;
    }

    @GetMapping("/list")
    public List<UserRequestDTO> getListUser(
            @RequestParam(required = false) String email ,
            @RequestParam(defaultValue = "0") int pageNo ,
            @RequestParam(defaultValue = "10") int pageSize
    ) {
        System.out.println("Request get list user ");
        return List.of(new UserRequestDTO("f1" , "l1" , "p1" , "e1") ,
                        new UserRequestDTO("f2" , "l2" , "p2" , "e2")) ;
    }
}
