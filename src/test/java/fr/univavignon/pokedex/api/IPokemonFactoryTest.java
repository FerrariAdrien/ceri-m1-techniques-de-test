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
    public void setUp() throws PokedexException {
        iPokemonFactory = mock(IPokemonFactory.class);
        when(iPokemonFactory.createPokemon(1, 100, 100, 100, 100)).thenReturn(new Pokemon(1, "Bulbasaur", 100, 100, 100, 100, 100, 100, 100, 100));

    }

    @Test
    public void testGetCp() throws PokedexException {
        assertEquals(iPokemonFactory.createPokemon(1, 100, 100, 100, 100).getCp(), 100);
    }

    @Test
    public void testGetHp() throws PokedexException {
        assertEquals(iPokemonFactory.createPokemon(1, 100, 100, 100, 100).getHp(), 100);
    }

    @Test
    public void testGetDust() throws PokedexException {
        assertEquals(iPokemonFactory.createPokemon(1, 100, 100, 100, 100).getDust(), 100);
    }

    @Test
    public void testGetCandy() throws PokedexException {
        assertEquals(iPokemonFactory.createPokemon(1, 100, 100, 100, 100).getCandy(), 100);
    }

    @Test
    public void testGetIv() throws PokedexException {
        assertEquals(iPokemonFactory.createPokemon(1, 100, 100, 100, 100).getIv(), 100,0.01);
    }
}
