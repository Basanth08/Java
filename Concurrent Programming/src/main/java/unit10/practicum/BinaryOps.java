package unit10.practicum;

public class BinaryOps {
    public interface BinaryLogicalOp {
        boolean compute(boolean a, boolean b);
    }

    public static void main(String[] args) {
        BinaryLogicalOp and = Boolean::logicalAnd;
        BinaryLogicalOp or = new BinaryLogicalOp() {
            @Override
            public boolean compute(boolean a, boolean b) {
                return a || b;
            }
        };
        BinaryLogicalOp xor = (a, b) -> a ^ b;

        boolean[] values = {false, true};
        for (boolean a : values) {
            for (boolean b : values) {
                System.out.printf("A: %b, B: %b, AND: %b, OR: %b, XOR: %b%n",
                        a, b, and.compute(a, b), or.compute(a, b), xor.compute(a, b));
            }
        }
    }
}
