package task_04_text.impl;

public class LineAnalyzerResult {
    private int alphas;
    private int words;


    public LineAnalyzerResult(int alphas, int words) {
        this.alphas = alphas;
        this.words = words;
    }


    public int getAlphas() {
        return alphas;
    }


    public int getWords() {
        return words;
    }


    @Override
    public String toString() {
        return "LineAnalyzerResult{" +
                "alphas=" + alphas +
                ", words=" + words +
                '}';
    }
}
