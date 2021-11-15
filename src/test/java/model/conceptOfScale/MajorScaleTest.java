package model.conceptOfScale;

import model.conceptOfNote.Note;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.*;

@RunWith(MockitoJUnitRunner.class)
public class MajorScaleTest {

    @Test
    public void createMajorScale(){
        MajorScale cMajor = new MajorScale(Note.C);
        MajorScale gMajor = new MajorScale(Note.G);
        MajorScale dMajor = new MajorScale(Note.D);

    }

}