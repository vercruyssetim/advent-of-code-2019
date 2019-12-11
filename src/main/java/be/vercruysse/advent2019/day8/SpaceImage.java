package be.vercruysse.advent2019.day8;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class SpaceImage {
    public static final int WIDTH = 25;
    public static final int HEIGHT = 6;

    public static void main(String[] args) {
        SpaceImage spaceImage = new SpaceImage();
        spaceImage.findLayers();
    }

    private void findLayers() {
        String imageString = readFile("input.txt").get(0);
        List<Layer> layers = new ArrayList<>();
        for (int i = 0; i < imageString.length(); i += WIDTH * HEIGHT) {
            layers.add(new Layer(imageString.substring(i, i + (WIDTH * HEIGHT)), WIDTH, HEIGHT));
        }
        Layer layer = layers.stream()
                .reduce((l1, l2) -> Layer.combine(l1, l2))
                .orElseThrow(() -> new IllegalArgumentException());

        System.out.println(layer);
    }


    private List<String> readFile(String fileName) {
        InputStream resource = this.getClass().getResourceAsStream(fileName);
        try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(resource))) {
            return bufferedReader.lines().collect(Collectors.toList());
        } catch (IOException exception) {
            throw new RuntimeException(exception);
        }
    }
}
