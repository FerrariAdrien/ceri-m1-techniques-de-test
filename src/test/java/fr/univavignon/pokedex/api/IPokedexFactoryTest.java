package fr.univavignon.pokedex.api;


import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;
public class IPokedexFactoryTest {


    @Mock
    private static IPokedexFactory iPokedexFactory;

    @Mock
    private static IPokemonMetadataProvider metadataProvider;

    @Mock
    private static IPokemonFactory pokemonFactory;

    @Before
    public void setUp(){
        // Créer un mock de IPokedexFactory
        //iPokedexFactory = mock(IPokedexFactory.class);

        // Créer des mocks pour les arguments de la méthode createPokedex
        metadataProvider = mock(IPokemonMetadataProvider.class);
        pokemonFactory = mock(IPokemonFactory.class);
    }

    @Test
    public void testCreatePokedex(){

        IPokedex pokedex = mock(IPokedex.class);
        IPokedexFactory iPokedexFactory1 = (metadataProvider, pokemonFactory) -> pokedex;
        IPokedex pokedex2 = iPokedexFactory1.createPokedex(metadataProvider, pokemonFactory);
        assertEquals(pokedex, pokedex2);



    }


}
