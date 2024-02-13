package fr.univavignon.pokedex.api;

import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.BeforeAll;
import org.mockito.Mock;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class  IPokemonFactoryTest {

    @Mock
    private static IPokemonFactory iPokemonFactory;

    @Before
    public void setUp(){
        iPokemonFactory = mock(IPokemonFactory.class);
        when(iPokemonFactory.createPokemon(1, 100, 100, 100, 100)).thenReturn(new Pokemon(1, "Bulbasaur", 100, 100, 100, 100, 100, 100, 100, 100));

    }

    @Test
    public void testGetCp(){
        assertEquals(iPokemonFactory.createPokemon(1, 100, 100, 100, 100).getCp(), 100);
    }

    @Test
    public void testGetHp(){
        assertEquals(iPokemonFactory.createPokemon(1, 100, 100, 100, 100).getHp(), 100);
    }

    @Test
    public void testGetDust(){
        assertEquals(iPokemonFactory.createPokemon(1, 100, 100, 100, 100).getDust(), 100);
    }

    @Test
    public void testGetCandy(){
        assertEquals(iPokemonFactory.createPokemon(1, 100, 100, 100, 100).getCandy(), 100);
    }

    @Test
    public void testGetIv(){
        assertEquals(iPokemonFactory.createPokemon(1, 100, 100, 100, 100).getIv(), 100);
    }
}
