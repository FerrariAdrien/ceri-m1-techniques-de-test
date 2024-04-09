package fr.univavignon.pokedex.api;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class RocketPokemonFactoryTest {
    private RocketPokemonFactory rocketPokemonFactory;
    private Pokemon pokemon;

    @Before
    public void setUp() throws PokedexException {
        IPokemonMetadataProvider iPokemonMetadataProvider = mock(IPokemonMetadataProvider.class);
        when(iPokemonMetadataProvider.getPokemonMetadata(0)).thenReturn(new PokemonMetadata(0, "Bulbizarre", 126, 126, 90));
        rocketPokemonFactory = new RocketPokemonFactory();
        pokemon = new Pokemon(4, "Bulbasaur", 126, 126, 90, 613, 64, 4000, 4, 56);
    }

    @Test
    public void testCreatePokemonIndex() throws PokedexException {
        int index = 1;
        Pokemon createdPokemon = rocketPokemonFactory.createPokemon(index, 613, 64, 4000, 4);
        assertEquals(index, createdPokemon.getIndex());
    }
    @Test
    public void testCreatePokemonWithUnmappedIndex() throws PokedexException {
        Pokemon createdPokemon = rocketPokemonFactory.createPokemon(999, 613, 64, 4000, 4);
        assertEquals("MISSINGNO", createdPokemon.getName());
    }

    @Test
    public void testCreatePokemonWithNegativeIndex() throws PokedexException {
        Pokemon createdPokemon = rocketPokemonFactory.createPokemon(-1, 613, 64, 4000, 4);
        assertEquals(1000, createdPokemon.getAttack());
        assertEquals(1000, createdPokemon.getDefense());
        assertEquals(1000, createdPokemon.getStamina());
        assertEquals(0, createdPokemon.getIv(), 0.01);
    }

    @Test
    public void testCreatePokemonStats() throws PokedexException {
        Pokemon createdPokemon = rocketPokemonFactory.createPokemon(1, 613, 64, 4000, 4);
        assertTrue(createdPokemon.getAttack() >= 0 && createdPokemon.getAttack() <= 100);
        assertTrue(createdPokemon.getDefense() >= 0 && createdPokemon.getDefense() <= 100);
        assertTrue(createdPokemon.getStamina() >= 0 && createdPokemon.getStamina() <= 100);
    }


    @Test
    public void testCreatePokemonCpHpDustCandy() throws PokedexException {
        int cp = 613;
        int hp = 64;
        int dust = 4000;
        int candy = 4;
        Pokemon createdPokemon = rocketPokemonFactory.createPokemon(1, cp, hp, dust, candy);
        assertEquals(cp, createdPokemon.getCp());
        assertEquals(hp, createdPokemon.getHp());
        assertEquals(dust, createdPokemon.getDust());
        assertEquals(candy, createdPokemon.getCandy());
    }

    @Test
    public void testCreatePokemonIv() throws PokedexException {
        Pokemon createdPokemon = rocketPokemonFactory.createPokemon(1, 613, 64, 4000, 4);
        assertEquals(1, createdPokemon.getIv(), 0.01);
    }

    @Test
    public void testBasicCreatePokemon() {
        Pokemon createdPokemon = rocketPokemonFactory.createPokemon(1, 613, 64, 4000, 4);
        assertNotNull(createdPokemon);
    }
}
