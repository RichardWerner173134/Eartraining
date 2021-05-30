package components;

import lombok.Getter;
import lombok.Setter;

import javax.sound.sampled.Clip;

@Setter
@Getter
public class Sound {
    private String name;
    private Clip clip;

}
