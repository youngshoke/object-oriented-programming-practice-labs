import java.util.Scanner;

class BitArray implements Comparable<BitArray> {

    private final int length; // kolichestvo bit

    private long[] words; // bity upakovany po 64 v kazhdom element long

    public BitArray(int length) {

        if (length <= 0) {

            throw new IllegalArgumentException("Dlina bitovogo massiva dolzhna byt > 0");

        }

        this.length = length;

        this.words = new long[(length + 63) / 64];

    }

    // Konstruktor kopirovaniya: sozdaetsya novyi massiv words
    public BitArray(BitArray other) {

        this.length = other.length;

        this.words = other.words.clone();

    }

    // Sozdanie iz stroki vida "1011"
    public static BitArray parse(String bits) {

        BitArray result = new BitArray(bits.length());

        for (int i = 0; i < bits.length(); i++) {

            char ch = bits.charAt(i);

            if (ch != '0' && ch != '1') {

                throw new IllegalArgumentException("Nedopustimyi simvol: " + ch);

            }

            result.set(i, ch == '1');

        }

        return result;

    }

    public int length() {

        return length;

    }

    private void checkIndex(int i) {

        if (i < 0 || i >= length) {

            throw new IndexOutOfBoundsException(
                "Bit " + i + " vne diapazona 0.." + (length - 1)
            );

        }

    }

    // Analog operator[] (chtenie bita)
    public boolean get(int i) {

        checkIndex(i);

        return (words[i / 64] & (1L << (i % 64))) != 0;

    }

    // Analog operator[] (zapic bita)
    public void set(int i, boolean value) {

        checkIndex(i);

        if (value) {

            words[i / 64] |= 1L << (i % 64);

        } else {

            words[i / 64] &= ~(1L << (i % 64));

        }

    }

    public int countOnes() {

        int count = 0;

        for (long w : words)
            count += Long.bitCount(w);

        return count;

    }

    private void checkSameLength(BitArray other) {

        if (length != other.length) {

            throw new IllegalArgumentException(
                "Dliny massivov razlichayutsya: " +
                length + " i " + other.length
            );

        }

    }

    // Obnulenie lishnih bit v poslednem slove (nuzhno posle ~)
    private void clearTail() {

        int extra = words.length * 64 - length;

        if (extra > 0) {

            words[words.length - 1] &= -1L >>> extra;

        }

    }

    // Analog operator&
    public BitArray and(BitArray other) {

        checkSameLength(other);

        BitArray result = new BitArray(length);

        for (int w = 0; w < words.length; w++)
            result.words[w] = words[w] & other.words[w];

        return result;

    }

    // Analog operator|
    public BitArray or(BitArray other) {

        checkSameLength(other);

        BitArray result = new BitArray(length);

        for (int w = 0; w < words.length; w++)
            result.words[w] = words[w] | other.words[w];

        return result;

    }

    // Analog operator^
    public BitArray xor(BitArray other) {

        checkSameLength(other);

        BitArray result = new BitArray(length);

        for (int w = 0; w < words.length; w++)
            result.words[w] = words[w] ^ other.words[w];

        return result;

    }

    // Analog operator~
    public BitArray not() {

        BitArray result = new BitArray(length);

        for (int w = 0; w < words.length; w++)
            result.words[w] = ~words[w];

        result.clearTail();

        return result;

    }

    // Analog operator==
    @Override
    public boolean equals(Object obj) {

        if (this == obj) return true;

        if (!(obj instanceof BitArray)) return false;

        BitArray other = (BitArray) obj;

        return length == other.length &&
               java.util.Arrays.equals(words, other.words);

    }

    @Override
    public int hashCode() {

        return 31 * length + java.util.Arrays.hashCode(words);

    }

    // Analog operator!=
    public boolean notEquals(BitArray other) {

        return !equals(other);

    }

    // Sravnenie kak dvoichnyh chisel (bit s indeksom 0 - starshii)
    @Override
    public int compareTo(BitArray other) {

        checkSameLength(other);

        for (int i = 0; i < length; i++) {

            if (get(i) != other.get(i))
                return get(i) ? 1 : -1;

        }

        return 0;

    }

    // Analog operator<
    public boolean lessThan(BitArray other) {

        return compareTo(other) < 0;

    }

    // Analog operator>
    public boolean greaterThan(BitArray other) {

        return compareTo(other) > 0;

    }

    // Analog operator<<
    @Override
    public String toString() {

        StringBuilder sb = new StringBuilder(length);

        for (int i = 0; i < length; i++)
            sb.append(get(i) ? '1' : '0');

        return sb.toString();

    }

    // Analog operator>>
    public static BitArray read(Scanner in) {

        return parse(in.next());

    }

}