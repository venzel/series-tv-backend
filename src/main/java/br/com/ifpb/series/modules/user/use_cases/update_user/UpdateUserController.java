package br.com.ifpb.series.modules.user.use_cases.update_user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.ifpb.series.modules.user.dtos.UpdateUserDTO;
import br.com.ifpb.series.modules.user.dtos.UserDTO;

@RestController
@RequestMapping("/users")
public class UpdateUserController {

    @Autowired
    private UpdateUserService updateUserService;

    @PutMapping("/{id}")
    public UserDTO handle(@RequestBody UpdateUserDTO dto, @PathVariable Long id) {

        return updateUserService.execute(dto, id);
    }
}