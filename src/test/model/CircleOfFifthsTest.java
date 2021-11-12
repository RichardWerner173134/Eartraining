package model;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.*;

@RunWith(MockitoJUnitRunner.class)
public class CircleOfFifthsTest {

    @Test
    public void testInitialization(){
        CircleOfFifths instance = CircleOfFifths.getInstance();
    }
}