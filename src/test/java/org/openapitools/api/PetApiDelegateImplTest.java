package org.openapitools.api;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.openapitools.model.Pet;
import org.openapitools.repository.PetRepository;
import org.springframework.http.ResponseEntity;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class PetApiDelegateImplTest {

    @InjectMocks
    private PetApiDelegateImpl petApiDelegate;

    @Mock
    private PetRepository petRepository;

    @Test
    public void name() {
        Pet pet = new Pet();
        when(petRepository.save(any())).thenReturn(pet);

        ResponseEntity<Void> actualResponse = petApiDelegate.addPet(pet);

        ResponseEntity<Object> expected = ResponseEntity.ok().build();
        assertThat(actualResponse, is(expected));
    }

}
