package fr.univavignon.pokedex.api;

import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.BeforeAll;
import org.mockito.Mock;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class IPokemonMetadataProviderTest {

    @Mock
    private static IPokemonMetadataProvider pokemonMetadata;

    @Before
    public void setUp() throws PokedexException {
        //pokemonMetadata = new PokemonMetadata(1,"slafleche",999,1,543);
        pokemonMetadata = mock(IPokemonMetadataProvider.class);
        when(pokemonMetadata.getPokemonMetadata(1)).thenReturn(new PokemonMetadata(1,"slafleche",999,1,543));
    }

    @Test
    public void testIndex() throws PokedexException {
        assertEquals(pokemonMetadata.getPokemonMetadata(1).getIndex(),1);
    }

    @Test
    public void testName() throws PokedexException {
        assertEquals(pokemonMetadata.getPokemonMetadata(1).getName(),"slafleche");
    }

    @Test
    public void testAttack() throws PokedexException {
        assertEquals(pokemonMetadata.getPokemonMetadata(1).getAttack(),999);
    }

    @Test
    public void testDefense() throws PokedexException {
        assertEquals(pokemonMetadata.getPokemonMetadata(1).getDefense(),1);
    }

    @Test
    public void testStamina() throws PokedexException {
        assertEquals(pokemonMetadata.getPokemonMetadata(1).getStamina(),543);
    }

}
