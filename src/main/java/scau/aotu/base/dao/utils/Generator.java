package scau.aotu.base.dao.utils;

import scau.aotu.base.utils.LocalUtil;

import java.util.UUID;
import java.util.concurrent.atomic.AtomicLong;

public interface Generator {

    public Generator INSTANCE = new UUIDGenerator();

    /**
     * 生成全局唯一的id
     *
     * @return
     */
    String generateId();

    public static class UUIDGenerator implements Generator {

        public synchronized String generateId() {
            return UUID.randomUUID().toString().replace("-", "");
        }
    }

    public static class GlobalGenerator implements Generator {
        private String seed;
        private final AtomicLong sequence = new AtomicLong(1);
        private int length;

        public GlobalGenerator() {
            try {
                this.seed = LocalUtil.getLocalHost() + "-" + System.currentTimeMillis() + "-";
                this.length = this.seed.length() + ("" + Long.MAX_VALUE).length();
            } catch (final Exception e) {
                throw new RuntimeException(e);
            }
        }

        public synchronized String generateId() {
            StringBuilder stringBuilder = new StringBuilder(this.length);
            stringBuilder.append(this.seed);
            stringBuilder.append(this.sequence.getAndIncrement());

            String result = stringBuilder.toString();
            result = result.replace(':', '-');
            result = result.replace('_', '-');
            result = result.replace('.', '-');
            return result.replace("-", "");
        }

        public static void main(String[] args) {
            UUIDGenerator g = new UUIDGenerator();
            System.out.println(g.generateId());
        }
    }
}
