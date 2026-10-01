import java.util.Scanner;

class BitArray implements Comparable<BitArray> {
    private final int length; // количество бит
    private long[] words;     // биты упакованы по 64 в каждый элемент long

    public BitArray(int length) {
        if (length <= 0) {
            throw new IllegalArgumentException("Длина битового массива должна быть > 0");
        }
        this.length = length;
        this.words = new long[(length + 63) / 64];
    }

    // Конструктор копирования: создаётся новый массив words
    public BitArray(BitArray other) {
        this.length = other.length;
        this.words = other.words.clone();
    }

    // Создание из строки вида "1011"
    public static BitArray parse(String bits) {
        BitArray result = new BitArray(bits.length());
        for (int i = 0; i < bits.length(); i++) {
            char ch = bits.charAt(i);
            if (ch != '0' && ch != '1') {
                throw new IllegalArgumentException("Недопустимый символ: " + ch);
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
            throw new IndexOutOfBoundsException("Бит " + i + " вне диапазона 0.." + (length - 1));
        }
    }

    // Аналог operator[] (чтение бита)
    public boolean get(int i) {
        checkIndex(i);
        return (words[i / 64] & (1L << (i % 64))) != 0;
    }

    // Аналог operator[] (запись бита)
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
        for (long w : words) count += Long.bitCount(w);
        return count;
    }

    private void checkSameLength(BitArray other) {
        if (length != other.length) {
            throw new IllegalArgumentException("Длины массивов различаются: " + length + " и " + other.length);
        }
    }

    // Обнуление лишних бит в последнем слове (нужно после ~)
    private void clearTail() {
        int extra = words.length * 64 - length;
        if (extra > 0) {
            words[words.length - 1] &= -1L >>> extra;
        }
    }

    // Аналог operator&
    public BitArray and(BitArray other) {
        checkSameLength(other);
        BitArray result = new BitArray(length);
        for (int w = 0; w < words.length; w++) result.words[w] = words[w] & other.words[w];
        return result;
    }

    // Аналог operator|
    public BitArray or(BitArray other) {
        checkSameLength(other);
        BitArray result = new BitArray(length);
        for (int w = 0; w < words.length; w++) result.words[w] = words[w] | other.words[w];
        return result;
    }

    // Аналог operator^
    public BitArray xor(BitArray other) {
        checkSameLength(other);
        BitArray result = new BitArray(length);
        for (int w = 0; w < words.length; w++) result.words[w] = words[w] ^ other.words[w];
        return result;
    }

    // Аналог operator~
    public BitArray not() {
        BitArray result = new BitArray(length);
        for (int w = 0; w < words.length; w++) result.words[w] = ~words[w];
        result.clearTail();
        return result;
    }

    // Аналог operator==
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof BitArray)) return false;
        BitArray other = (BitArray) obj;
        return length == other.length && java.util.Arrays.equals(words, other.words);
    }

    @Override
    public int hashCode() {
        return 31 * length + java.util.Arrays.hashCode(words);
    }

    // Аналог operator!=
    public boolean notEquals(BitArray other) {
        return !equals(other);
    }

    // Сравнение как двоичных чисел (бит с индексом 0 - старший)
    @Override
    public int compareTo(BitArray other) {
        checkSameLength(other);
        for (int i = 0; i < length; i++) {
            if (get(i) != other.get(i)) return get(i) ? 1 : -1;
        }
        return 0;
    }

    // Аналог operator<
    public boolean lessThan(BitArray other) {
        return compareTo(other) < 0;
    }

    // Аналог operator>
    public boolean greaterThan(BitArray other) {
        return compareTo(other) > 0;
    }

    // Аналог operator<<
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder(length);
        for (int i = 0; i < length; i++) sb.append(get(i) ? '1' : '0');
        return sb.toString();
    }

    // Аналог operator>>
    public static BitArray read(Scanner in) {
        return parse(in.next());
    }
}
