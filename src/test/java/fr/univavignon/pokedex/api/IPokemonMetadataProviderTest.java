package fr.univavignon.pokedex.api;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class IPokemonMetadataProviderTest {

    @Mock
    private static IPokemonMetadataProvider pokemonMetadata;

    @Before
    public void setUp() throws PokedexException {
        // Créer un objet PokemonMetadata
        PokemonMetadata pokemonMetadataMock = new PokemonMetadata(1,"Bulbasaur",49,49,45);

        // Créer un mock de IPokemonMetadataProvider
        pokemonMetadata = mock(IPokemonMetadataProvider.class);

        // Définir le comportement de la méthode getPokemonMetadata
        when(pokemonMetadata.getPokemonMetadata(1)).thenReturn(pokemonMetadataMock);
    }

    @Test
    public void testIndex() throws PokedexException {
        assertEquals(1, pokemonMetadata.getPokemonMetadata(1).getIndex());
    }

    @Test
    public void testName() throws PokedexException {
        assertEquals("Bulbasaur", pokemonMetadata.getPokemonMetadata(1).getName());
    }

    @Test
    public void testAttack() throws PokedexException {
        assertEquals(49, pokemonMetadata.getPokemonMetadata(1).getAttack());
    }

    @Test
    public void testDefense() throws PokedexException {
        assertEquals(49, pokemonMetadata.getPokemonMetadata(1).getDefense());
    }

    @Test
    public void testStamina() throws PokedexException {
        assertEquals(45, pokemonMetadata.getPokemonMetadata(1).getStamina());
    }

}
