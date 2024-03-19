package fr.univavignon.pokedex.api;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class IPokemonTrainerFactoryTest {

    @Mock
    private static IPokedexFactory pokedexFactory;

    @Mock
    private static IPokedex pokedex;

    private PokemonTrainer pokemonTrainer;

    @Before
    public void setUp() {
        // Créer un mock de IPokedexFactory et IPokedex
        pokedexFactory = mock(IPokedexFactory.class);
        pokedex = mock(IPokedex.class);

        // Définir le comportement de la méthode createPokedex
        when(pokedexFactory.createPokedex(any(IPokemonMetadataProvider.class), any(IPokemonFactory.class))).thenReturn(pokedex);

        // Créer un objet PokemonTrainer
        pokemonTrainer = new PokemonTrainer("Ash", Team.VALOR, pokedex);
    }

    @Test
    public void testName() {
        assertEquals("Ash", pokemonTrainer.getName());
    }

    @Test
    public void testTeam() {
        assertEquals(Team.VALOR, pokemonTrainer.getTeam());
    }

    @Test
    public void testPokedex() {
        assertEquals(pokedex, pokemonTrainer.getPokedex());
    }
}