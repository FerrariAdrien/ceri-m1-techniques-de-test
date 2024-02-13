package fr.univavignon.pokedex.api;

import org.junit.Test;
import org.junit.jupiter.api.BeforeAll;
import org.mockito.Mock;

import static org.junit.Assert.assertEquals;

public class IPokemonMetadataProviderTest {

    @Mock
    private static PokemonMetadata pokemonMetadata;

    @BeforeAll
    public static void setUp(){
        pokemonMetadata = new PokemonMetadata(1,"slafleche",999,1,543);
    }

    @Test
    public void testIndex(){
        assertEquals(pokemonMetadata.getIndex(),1);
    }

    @Test
    public void testName(){
        assertEquals(pokemonMetadata.getName(),"slafleche");
    }

    @Test
    public void testAttack(){
        assertEquals(pokemonMetadata.getAttack(),999);
    }

    @Test
    public void testDefense(){
        assertEquals(pokemonMetadata.getDefense(),1);
    }

    @Test
    public void testStamina(){
        assertEquals(pokemonMetadata.getStamina(),543);
    }

}
