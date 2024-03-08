import java.util.Map;
import java.util.HashMap;

class NucleotideCounter {
    private final Map<Character, Integer> nucleotideCounts;

    NucleotideCounter(String sequence) {
        if (hasIllegalNucleotides(sequence)) {
            throw new IllegalArgumentException();
        }

        nucleotideCounts = countNucleotidesFrequences(sequence);
    }

    Map<Character, Integer> nucleotideCounts() {
        return nucleotideCounts;
    }

    private static Map<Character, Integer> initializeCounts() {
        Map<Character, Integer> counts = new HashMap<>();
        
        for (char nucleotide: new char[] {'A', 'C', 'G', 'T'}) {
            counts.put(nucleotide, 0);
        }

        return counts;
    }

    private static Map<Character, Integer> countNucleotidesFrequences(String sequence) {
        Map<Character, Integer> nucleotideCounts = initializeCounts();
        
        for (char nucleotide: sequence.toCharArray()) {
            int oldValue = nucleotideCounts.get(nucleotide);
            nucleotideCounts.replace(nucleotide, oldValue, oldValue + 1);
        }

        return nucleotideCounts;
    }
    
    private static boolean hasIllegalNucleotides(String sequence) {
        return !sequence.matches("(A|C|G|T)*");
    }
}