package br.com.ifpb.series.modules.user.mappers;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

import br.com.ifpb.series.modules.user.dtos.CreateUserDTO;
import br.com.ifpb.series.modules.user.dtos.ListUserDTO;
import br.com.ifpb.series.modules.user.dtos.UpdateUserDTO;
import br.com.ifpb.series.modules.user.dtos.UserDTO;
import br.com.ifpb.series.modules.user.entities.User;

@Component
public class UserMapper {

    @Autowired
    private ModelMapper modelMapper;

    public UserDTO toDTO(User user) {
        return modelMapper.map(user, UserDTO.class);
    }

    public ListUserDTO toListDTO(User user) {
        return modelMapper.map(user, ListUserDTO.class);
    }

    public List<ListUserDTO> toCollectionModel(List<User> users) {
        return users.stream()
                    .map(e -> toListDTO(e))
                    .collect(Collectors.toList());
    }

    public Page<ListUserDTO> toCollectionPageModel(Page<User> users) {
        return users.map(e -> toListDTO(e));
    }

    public User toEntity(CreateUserDTO dto) {
        return modelMapper.map(dto, User.class);
    }

    public void toCopyEntity(UpdateUserDTO dto, User user) {
        modelMapper.map(dto, user);
    }
}