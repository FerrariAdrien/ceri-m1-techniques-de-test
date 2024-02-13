package fr.univavignon.pokedex.api;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import static org.mockito.ArgumentMatchers.any;
import org.mockito.internal.matchers.Any;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class IPokemonTrainerFactoryTest {
    @Mock
    private static IPokemonTrainerFactory pokemonTrainer;

    private IPokedexFactory pokedex;
    private IPokedex pokedex2;
    @Before
    public void setUp(){
        pokedex = mock(IPokedexFactory.class);
        pokedex2 = mock(IPokedex.class);
        pokemonTrainer = mock(IPokemonTrainerFactory.class);
        when(pokemonTrainer.createTrainer("Ash", Team.VALOR,pokedex )).thenReturn(new PokemonTrainer("Ash", Team.VALOR, pokedex2));

    }

    @Test
    public void testGetName(){
        assertEquals(pokemonTrainer.createTrainer("Ash", Team.VALOR, pokedex).getName(), "Ash");
    }

    @Test
    public void testGetTeam(){
        assertEquals(pokemonTrainer.createTrainer("Ash", Team.VALOR, pokedex).getTeam(), Team.VALOR);
    }

    @Test
    public void testGetPokedex(){
        assertEquals(pokemonTrainer.createTrainer("Ash", Team.VALOR, pokedex).getPokedex(),pokedex2);
    }
}
