package fr.univavignon.pokedex.api;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class IPokedexTest {

    //@Mock
    //private static IPokedex iPokedex;
    private static Pokedex iPokedex;

    private static Pokedex pokedex;
    private Pokemon pokemon;
    private Pokemon pokemon2;
    @Before
    public void setUp() throws PokedexException {
//        iPokedex = mock(IPokedex.class);
//        pokemon = new Pokemon(1, "Bulbasaur", 100, 100, 100, 100, 100, 100, 100, 100);
//        when(iPokedex.addPokemon(any(Pokemon.class))).thenReturn(pokemon.getIndex());
//        when(iPokedex.getPokemon(1)).thenReturn(pokemon);
//        when(iPokedex.size()).thenReturn(5);
//        when(iPokedex.getPokemons()).thenReturn(new ArrayList<Pokemon>());
//        when(iPokedex.getPokemons(null)).thenReturn(new ArrayList<Pokemon>());
        iPokedex = new Pokedex();
        this.pokemon = new Pokemon(1, "Bulbasaur", 100, 100, 100, 100, 100, 100, 100, 100);
        this.pokemon2 = new Pokemon(2, "Ivysaur", 100, 100, 100, 100, 100, 100, 100, 100);
        iPokedex.addPokemon(pokemon);
        iPokedex.addPokemon(pokemon2);


    }

    @Test
    public void testAddPokemon() throws PokedexException {
        assertEquals(iPokedex.addPokemon(pokemon), 2);
    }

    @Test
    public void testGetPokemon() throws PokedexException {
        assertEquals(iPokedex.getPokemon(0), pokemon);

        assertEquals(iPokedex.getPokemon(1).getName(),pokemon2.getName());
    }

    @Test
    public void testSize() {
        assertEquals(iPokedex.size(), 2);

    }

    @Test
    public void testGetPokemons() {

        assertEquals(iPokedex.getPokemons(), iPokedex.pokemons);

    }
    @Test
    public void testGetPokemonsWithOrder() {
        Comparator<Pokemon> order = Comparator.comparing(Pokemon::getName);
        List<Pokemon> sortedPokemons = new ArrayList<>();
        sortedPokemons.add(pokemon);
        sortedPokemons.add(pokemon2);

        assertEquals(iPokedex.getPokemons(order), sortedPokemons);
    }
    @Test(expected = PokedexException.class)
    public void testGetPokemonWithInvalidId() throws PokedexException {
        iPokedex.getPokemon(10);
    }

    @Test
    public void testGetPokemonsReturnsCorrectList() {
        List<Pokemon> expectedPokemons = new ArrayList<>();
        expectedPokemons.add(pokemon);
        expectedPokemons.add(pokemon2);
        assertEquals(expectedPokemons, iPokedex.getPokemons());
    }

    @Test
    public void testAddPokemonReturnsCorrectIndex() {
        Pokemon newPokemon = new Pokemon(3, "Venusaur", 100, 100, 100, 100, 100, 100, 100, 100);
        int index = iPokedex.addPokemon(newPokemon);
        assertEquals(2, index);
    }

}
