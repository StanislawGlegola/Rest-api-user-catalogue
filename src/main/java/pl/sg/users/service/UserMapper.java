package pl.sg.usercatalog.service;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import pl.sg.usercatalog.model.UserDAO;
import pl.sg.usercatalog.model.UserDTO;

import java.util.List;

@Mapper(componentModel = "spring")
public interface UserMapper {

    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

    UserDTO toUserDTO(UserDAO userDAO);

    UserDAO toUserDAO(UserDTO userDTO);

    List<UserDAO> toUserDAOList(List<UserDTO> userDTOList);

    List<UserDTO> toUserDTOList(List<UserDAO> userDAOList);
}