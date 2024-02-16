public class Xoshiro256 {
    private long[] state = new long[4];

    public Xoshiro256(long seed) {
        state[0] = murmurHash3(seed);
        for (int i = 1; i < 4; i++) {
            state[i] = murmurHash3(state[i - 1]);
        }
    }

    public long nextLong() {
        long result = rotl(state[1] * 5, 7) * 9;
        long t = state[1] << 17;
        state[2] ^= state[0];
        state[3] ^= state[1];
        state[1] ^= state[2];
        state[0] ^= state[3];
        state[2] ^= t;
        state[3] = rotl(state[3], 45);
        return result;
    }

    private static long murmurHash3(long x) {
        x ^= (x >>> 33);
        x *= 0xff51afd7ed558ccdL;
        x ^= (x >>> 33);
        x *= 0xc4ceb9fe1a85ec53L;
        x ^= (x >>> 33);
        return x;
    }

    private static long rotl(long x, int k) {
        return (x << k) | (x >>> (64 - k));
    }
}