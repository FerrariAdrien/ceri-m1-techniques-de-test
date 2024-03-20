package fr.univavignon.pokedex.api;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class PokemonComparatorsTest {


    @Test
    public void testCompareByIndex() {
        Pokemon pokemon1 = mock(Pokemon.class);
        when(pokemon1.getIndex()).thenReturn(1);
        Pokemon pokemon2 = mock(Pokemon.class);
        when(pokemon2.getIndex()).thenReturn(2);

        int result = PokemonComparators.INDEX.compare(pokemon1, pokemon2);
        assertEquals(-1, result);
    }

    @Test
    public void testCompareByName() {
        Pokemon pokemon1 = mock(Pokemon.class);
        when(pokemon1.getName()).thenReturn("Bulbasaur");
        Pokemon pokemon2 = mock(Pokemon.class);
        when(pokemon2.getName()).thenReturn("Ivysaur");

        int result = PokemonComparators.NAME.compare(pokemon1, pokemon2);
        assertTrue(result < 0);
    }

    @Test
    public void testCompareByCp() {
        Pokemon pokemon1 = mock(Pokemon.class);
        when(pokemon1.getCp()).thenReturn(613);
        Pokemon pokemon2 = mock(Pokemon.class);
        when(pokemon2.getCp()).thenReturn(405);

        int result = PokemonComparators.CP.compare(pokemon1, pokemon2);
        assertEquals(1, result);
    }

}
