package pl.sg.users.service;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;
import pl.sg.users.model.UserDAO;
import pl.sg.users.model.UserDTO;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-10-02T14:07:25+0200",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 22.0.1 (Oracle Corporation)"
)
@Component
public class UserMapperImpl implements UserMapper {

    @Override
    public UserDTO toUserDTO(UserDAO userDAO) {
        if ( userDAO == null ) {
            return null;
        }

        UserDTO userDTO = new UserDTO();

        userDTO.setId( userDAO.getId() );
        userDTO.setUserName( userDAO.getUserName() );
        userDTO.setAge( userDAO.getAge() );
        userDTO.setGender( userDAO.getGender() );
        userDTO.setEmail( userDAO.getEmail() );
        userDTO.setDescription( userDAO.getDescription() );
        userDTO.setRegistrationDate( userDAO.getRegistrationDate() );
        userDTO.setModificationDate( userDAO.getModificationDate() );
        userDTO.setModified( userDAO.isModified() );

        return userDTO;
    }

    @Override
    public UserDAO toUserDAO(UserDTO userDTO) {
        if ( userDTO == null ) {
            return null;
        }

        UserDAO userDAO = new UserDAO();

        userDAO.setId( userDTO.getId() );
        userDAO.setUserName( userDTO.getUserName() );
        userDAO.setAge( userDTO.getAge() );
        userDAO.setGender( userDTO.getGender() );
        userDAO.setEmail( userDTO.getEmail() );
        userDAO.setDescription( userDTO.getDescription() );
        userDAO.setRegistrationDate( userDTO.getRegistrationDate() );
        userDAO.setModificationDate( userDTO.getModificationDate() );
        userDAO.setModified( userDTO.isModified() );

        return userDAO;
    }

    @Override
    public List<UserDAO> toUserDAOList(List<UserDTO> userDTOList) {
        if ( userDTOList == null ) {
            return null;
        }

        List<UserDAO> list = new ArrayList<UserDAO>( userDTOList.size() );
        for ( UserDTO userDTO : userDTOList ) {
            list.add( toUserDAO( userDTO ) );
        }

        return list;
    }

    @Override
    public List<UserDTO> toUserDTOList(List<UserDAO> userDAOList) {
        if ( userDAOList == null ) {
            return null;
        }

        List<UserDTO> list = new ArrayList<UserDTO>( userDAOList.size() );
        for ( UserDAO userDAO : userDAOList ) {
            list.add( toUserDTO( userDAO ) );
        }

        return list;
    }
}
