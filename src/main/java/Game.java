import enums.Variants;
import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;

@Slf4j
public class Game {
    public static void main(String[] args) {

        Arrays.asList(Variants.values()).forEach(variant -> log.info(variant.toString()));
    }

}
