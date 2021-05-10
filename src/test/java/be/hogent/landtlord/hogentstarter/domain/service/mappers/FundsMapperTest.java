package be.hogent.landtlord.hogentstarter.domain.service.mappers;

import be.hogent.landtlord.hogentstarter.domain.bussines.Funds;
import be.hogent.landtlord.hogentstarter.domain.bussines.Project;
import be.hogent.landtlord.hogentstarter.domain.bussines.User;
import be.hogent.landtlord.hogentstarter.domain.bussines.repository.FundsRepository;
import be.hogent.landtlord.hogentstarter.domain.service.dto.FundsDTO;
import be.hogent.landtlord.hogentstarter.domain.service.dto.ProjectDTO;
import be.hogent.landtlord.hogentstarter.domain.service.dto.UserDTO;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(MockitoExtension.class)
class FundsMapperTest {

    @InjectMocks
    private FundsMapper fundsMapper;

    @Mock
    private Mapper<Project, ProjectDTO> projectMapper;

    @Mock
    private Mapper<User, UserDTO> userMapper;

    @Test
    void givenNullFunds_whenToDTOIsInvoked_thenNullIsReturned(){
        Funds funds = null;

        FundsDTO fundsDTO = fundsMapper.toDTO(funds);

        assertThat(fundsDTO).isNull();
    }

    @Test
    void givenNullFundsDTO_whenToObjectIsInvoked_thenNullIsReturned(){
        FundsDTO fundsDTO = null;

        Funds funds = fundsMapper.toObject(fundsDTO);

        assertThat(funds).isNull();
    }

    @Test
    void givenAFunds_whenToDTOIsInvoked_thenTheCorrectFundsDTOIsReturned(){

    }
}
