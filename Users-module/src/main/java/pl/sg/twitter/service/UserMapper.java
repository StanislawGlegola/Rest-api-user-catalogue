package pl.sg.twitter.service;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import pl.sg.twitter.model.UserDAO;
import pl.sg.twitter.model.UserDTO;

import java.util.List;

@Mapper(componentModel = "spring")
public interface UserMapper {

    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

    UserDTO toUserDTO(UserDAO userDAO);

    UserDAO toUserDAO(UserDTO userDTO);

    List<UserDAO> toUserDAOList(List<UserDTO> userDTOList);

    List<UserDTO> toUserDTOList(List<UserDAO> userDAOList);
}