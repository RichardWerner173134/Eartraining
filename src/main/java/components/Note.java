package components;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Setter
@Getter
public class Note {
    private Sound sound;
    private int octave;

    private static List<Note> noteListInstance;

    private Note(Sound sound, int octave){
        this.sound = sound;
        this.octave = octave;
    }

    public static ArrayList<Note> initNoteListInstance(){
        if(noteListInstance == null){
            noteListInstance = new ArrayList<>();

            char accidental;
            Sound sound;
            for(int currentOctave = 3; currentOctave < 6; currentOctave++) {
                for (int scaleDegree = 1; scaleDegree < 8; scaleDegree++) {
                    // generate Accidental notes
                    switch (scaleDegree) {
                        case 2:
                        case 3:
                        case 6:
                        case 7:
                            // first flat note
                            accidental = 'b';
                            sound = new Sound(scaleDegree, accidental);
                            noteListInstance.add(new Note(sound, currentOctave));

                            // then natural note
                            accidental = 'n';
                            sound = new Sound(scaleDegree, accidental);
                            noteListInstance.add(new Note(sound, currentOctave));
                            break;
                        case 4:
                            // first natural note
                            accidental = 'n';
                            sound = new Sound(scaleDegree, accidental);
                            noteListInstance.add(new Note(sound, currentOctave));

                            // then sharp note
                            accidental = '#';
                            sound = new Sound(scaleDegree, accidental);
                            noteListInstance.add(new Note(sound, currentOctave));
                            break;
                        default:
                            // generate natural note
                            accidental = 'n';
                            sound = new Sound(scaleDegree, accidental);
                            noteListInstance.add(new Note(sound, currentOctave));
                    }

                }
            }
        }
        return (ArrayList<Note>) noteListInstance;
    }

    public static Note getSoundType(int scaleDegree, char n, int octave) throws Exception {
        if(noteListInstance == null){
            initNoteListInstance();
        }

        for(Note note : noteListInstance){
            if(note.getSound().getScaleDegree() == scaleDegree &&
                    note.getSound().getAccidental() == n &&
                    note.getOctave() == octave){
                return note;
            }
        }
        throw new Exception(String.format("Note not found [scaleDegree:%s, accidental:%s, octave:%s]", scaleDegree, n, octave));

    }

    public String getSoundString() {
        // we just play sounds from the C Major Scale
        HashMap<Integer, Character> cMajorMap = new HashMap<>();
        cMajorMap.put(1, 'C');
        cMajorMap.put(2, 'D');
        cMajorMap.put(3, 'E');
        cMajorMap.put(4, 'F');
        cMajorMap.put(5, 'G');
        cMajorMap.put(6, 'A');
        cMajorMap.put(7, 'B');

        String scaleDegree = cMajorMap.get(sound.getScaleDegree()).toString();
        String accidental = sound.getAccidental() == 'n' ? "": String.valueOf(sound.getAccidental());

        return "" + scaleDegree + accidental + octave;
    }

    public static List<Sound> getSoundWithoutOctave(List<Note> notes){
        List<Sound> sounds = new ArrayList<>();
        for(Note note : notes){
            sounds.add(note.getSound());
        }
        return sounds;
    }

}
