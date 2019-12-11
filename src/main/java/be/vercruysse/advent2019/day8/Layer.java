package be.vercruysse.advent2019.day8;

public class Layer implements Comparable<Layer>{
    private String layerString;
    private int width;
    private int height;

    public Layer(String layerString, int width, int height) {
        this.layerString = layerString;
        this.width = width;
        this.height = height;
    }

    public String getLayerString() {
        return layerString;
    }

    public int getNumberOf(char numberToCheck) {
        return (int) layerString.chars().filter(c -> c == numberToCheck).count();
    }

    public static Layer combine(Layer layer1, Layer layer2) {
        char[] chars = new char[layer1.layerString.length()];
        for(int i = 0; i < layer1.layerString.length(); i++) {
            char result;
            if(layer1.layerString.charAt(i) == '0' || layer1.layerString.charAt(i) == '1') {
                result = layer1.layerString.charAt(i);
            } else if(layer2.layerString.charAt(i) == '0' || layer2.layerString.charAt(i) == '1') {
                result = layer2.layerString.charAt(i);
            } else {
                result = '2';
            }
            chars[i] = result;
        }
        return new Layer(new String(chars), layer1.width, layer1.height);
    }

    @Override
    public int compareTo(Layer other) {
        return getNumberOf('0') - other.getNumberOf('0');
    }

    @Override
    public String toString() {
        String result = "";
        for(int i = 0; i < height; i++) {
            for(int j = 0; j < width; j++) {
                char character = layerString.charAt(i * width + j);
                if(character == '1') {
                    result += '#';
                } else {
                    result += ' ';
                }
            }
            result += "\n";
        }
        return result;
    }
}
