package fr.univavignon.pokedex.api;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;
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

        this.pokemon = mock(Pokemon.class);
        this.pokemon2 = mock(Pokemon.class);
        when(pokemon.getIndex()).thenReturn(1);
        when(pokemon.getName()).thenReturn("Bulbasaur");
        when(pokemon.getAttack()).thenReturn(100);
        when(pokemon.getDefense()).thenReturn(100);
        when(pokemon.getStamina()).thenReturn(100);
        when(pokemon.getCp()).thenReturn(100);
        when(pokemon.getHp()).thenReturn(100);
        when(pokemon.getDust()).thenReturn(100);
        when(pokemon.getCandy()).thenReturn(100);
        when(pokemon.getIv()).thenReturn(100.0);

        when(pokemon2.getIndex()).thenReturn(2);
        when(pokemon2.getName()).thenReturn("Ivysaur");
        when(pokemon2.getAttack()).thenReturn(100);
        when(pokemon2.getDefense()).thenReturn(100);
        when(pokemon2.getStamina()).thenReturn(100);
        when(pokemon2.getCp()).thenReturn(100);
        when(pokemon2.getHp()).thenReturn(100);
        when(pokemon2.getDust()).thenReturn(100);
        when(pokemon2.getCandy()).thenReturn(100);
        when(pokemon2.getIv()).thenReturn(100.0);
        //this.pokemon = new Pokemon(1, "Bulbasaur", 100, 100, 100, 100, 100, 100, 100, 100);
        //this.pokemon2 = new Pokemon(2, "Ivysaur", 100, 100, 100, 100, 100, 100, 100, 100);
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
    public void testCreatePokemon() throws PokedexException {
        Pokemon createdPokemon = iPokedex.createPokemon(2, 100, 100, 100, 100);

        Assert.assertEquals(2, createdPokemon.getIndex());
        Assert.assertEquals(100, createdPokemon.getCp());
        Assert.assertEquals(100, createdPokemon.getHp());
        Assert.assertEquals(100, createdPokemon.getDust());
        Assert.assertEquals(100, createdPokemon.getCandy());
    }
    @Test
    public void testGetPokemonMetadata() throws PokedexException {

        Pokemon createdPokemon = iPokedex.createPokemon(2, 100, 100, 100, 100);
        PokemonMetadata metadata = iPokedex.getPokemonMetadata(2);

        Assert.assertEquals(createdPokemon.getIndex(), metadata.getIndex());
        Assert.assertEquals(createdPokemon.getName(), metadata.getName());
        Assert.assertEquals(createdPokemon.getAttack(), metadata.getAttack());
        Assert.assertEquals(createdPokemon.getDefense(), metadata.getDefense());
        Assert.assertEquals(createdPokemon.getStamina(), metadata.getStamina());
    }

    @Test
    public void testAddPokemonUniqueIndex() throws PokedexException {
        Pokemon pokemon3 = mock(Pokemon.class);
        when(pokemon3.getIndex()).thenReturn(3);
        int index = iPokedex.addPokemon(pokemon3);
        assertEquals(2, index);
    }

    @Test(expected = PokedexException.class)
    public void testGetPokemonInvalidId() throws PokedexException {
        iPokedex.getPokemon(999);
    }

    @Test
    public void testCreatePokemonThrowsException() throws PokedexException {
        // Créer un mock pour PokemonMetadataProvider
        IPokemonMetadataProvider metadataProvider = mock(IPokemonMetadataProvider.class);
        Pokedex pokedex1 = new Pokedex();
        // Configurer le mock pour retourner null lorsque getPokemonMetadata est appelé avec un index invalide
        when(metadataProvider.getPokemonMetadata(anyInt())).thenReturn(null);

        // Appeler la méthode createPokemon avec un index invalide et vérifier qu'une PokedexException est lancée
        assertThrows(PokedexException.class, () -> pokedex1.createPokemon(-1, 100, 100, 100, 100));
    }
    @Test
    public void testCreatePokemonWithNullMetadata() throws PokedexException {
        // Créer un mock pour IPokemonMetadataProvider
        IPokemonMetadataProvider metadataProvider = mock(IPokemonMetadataProvider.class);

        Pokedex pokedex = new Pokedex();
        // Configurer le mock pour retourner null lorsque getPokemonMetadata est appelé
        when(metadataProvider.getPokemonMetadata(anyInt())).thenReturn(null);

        // Appeler la méthode createPokemon et vérifier qu'une PokedexException est lancée
        assertThrows(PokedexException.class, () -> pokedex.createPokemon(1, 100, 100, 100, 100));
    }

}
