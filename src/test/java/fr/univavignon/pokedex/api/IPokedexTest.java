package fr.univavignon.pokedex.api;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class IPokedexTest {

    @Mock
    private static IPokedex iPokedex;

    private Pokemon pokemon;
    @Before
    public void setUp() throws PokedexException {
        iPokedex = mock(IPokedex.class);
        pokemon = new Pokemon(1, "Bulbasaur", 100, 100, 100, 100, 100, 100, 100, 100);
        when(iPokedex.addPokemon(any(Pokemon.class))).thenReturn(pokemon.getIndex());
        when(iPokedex.getPokemon(1)).thenReturn(pokemon);
        when(iPokedex.size()).thenReturn(5);
        when(iPokedex.getPokemons()).thenReturn(new ArrayList<Pokemon>());
        when(iPokedex.getPokemons(null)).thenReturn(new ArrayList<Pokemon>());
    }

    @Test
    public void testAddPokemon() throws PokedexException {
        assertEquals(iPokedex.addPokemon(pokemon), pokemon.getIndex());
    }

    @Test
    public void testGetPokemon() throws PokedexException {
        assertEquals(iPokedex.getPokemon(1), pokemon);
    }

    @Test
    public void testSize() {
        assertEquals(iPokedex.size(), 5);
    }

    @Test
    public void testGetPokemons() {
        assertEquals(iPokedex.getPokemons(), new ArrayList<Pokemon>());
    }

}
