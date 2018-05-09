package com.cydercode.color;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ColorPallete {

    private Random random = new Random();

    private List<Color> colors = new ArrayList<Color>() {{
        add(new Color(0, 0, 0));
        add(new Color(5, 5, 5));
        add(new Color(40, 40, 40));
        add(new Color(80, 80, 80));
        add(new Color(120, 120, 120));
    }};


    public Color getRandomColor() {
        return colors.get(random.nextInt(colors.size()));
    }
}
