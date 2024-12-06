package org.example;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        class ArraysUtils {
            public static int binarySearch(byte[] a, int fromIndex, int toIndex, byte key, byte b) {
                return binarySearch(a, 0, a.length, key);
            }

            public static int binarySearch(byte[] a, int fromIndex, int toIndex, byte key) {
                return binarySearch(a, fromIndex, toIndex, key, (byte) 0);
            }

            public static int binarySearch(char[] a, char key) {
                return binarySearch(a, 0, a.length, key);
            }

            public static int binarySearch(char[] a, int fromIndex, int toIndex, char key) {
                return binarySearch(a, fromIndex, toIndex, key);
            }

            public static int binarySearch(double[] a, double key) {
                return binarySearch(a, 0, a.length, key);
            }

            public static int binarySearch(double[] a, int fromIndex, int toIndex, double key) {
                return binarySearch(a, fromIndex, toIndex, key);
            }

            public static int binarySearch(float[] a, float key) {
                return binarySearch(a, 0, a.length, key);
            }

            public static int binarySearch(float[] a, int fromIndex, int toIndex, float key) {
                return binarySearch(a, fromIndex);
            }

            public static int binarySearch(int[] a, int key) {
                return binarySearch(a, 0, a.length, key);
            }

            public static int binarySearch(int[] a, int fromIndex, int toIndex, int key) {
                return binarySearch(a, fromIndex, toIndex, key);
            }

            public static int binarySearch(long[] a, long key) {
                return binarySearch(a, 0, a.length, key);
            }

            public static int binarySearch(long[] a, int fromIndex, int toIndex, long key) {
                return binarySearch(a, fromIndex, toIndex, key);
            }

            public static int binarySearch(short[] a, short key) {
                return binarySearch(a, 0, a.length, key);
            }

            public static int binarySearch(short[] a, int fromIndex, int toIndex, short key) {
                return binarySearch(a, fromIndex, toIndex, key);
            }

            public static <T> int binarySearch(T[] a, int i, int length, T key, Comparator<? super T> c) {
                return binarySearch(a, 0, a.length, key, c);
            }

            public static <T> int binarySearch(T[] a, int fromIndex, T key, int toIndex, Comparator<? super T> c) {
                return Arrays.binarySearch(a, fromIndex, toIndex, key, c);
            }

            private static <ByteComparator> int binarySearch(byte[] a, int fromIndex, int toIndex, byte key, Comparator<Byte> cmp) {
                int low = fromIndex;
                int high = toIndex - 1;

                while (low <= high) {
                    int mid = (low + high) >>> 1;
                    byte midVal = a[mid];

                    if (cmp.compare(midVal, key) < 0) {
                        low = mid + 1;
                    } else if (cmp.compare(midVal, key) > 0) {
                        high = mid - 1;
                    } else {
                        return mid; // key found
                    }
                }

                return -(low + 1); // key not found
            }

            private static <CharComparator> int binarySearch(char[] a, int fromIndex, int toIndex, char key, Comparator<Character> cmp) {
                int low = fromIndex;
                int high = toIndex - 1;

                while (low <= high) {
                    int mid = (low + high) >>> 1;
                    char midVal = a[mid];

                    if (cmp.compare(midVal, key) < 0) {
                        low = mid + 1;
                    } else cmp.compare(midVal, key);
                }
                return low;
            }
        }
        class CollectionsUtils {

            private static Comparator<? super Object> c;

            public static <T> int binarySearch(List<? extends T> list, T key) {
                return binarySearch(list, 0, list.size(), key, Optional.ofNullable(null));
            }

            public static <T> int binarySearch(List<? extends T> list, int fromIndex, int toIndex, T key, Object o) {
                return binarySearch(list, fromIndex, toIndex, key, Optional.ofNullable(null));
            }

            public static <T> int binarySearch(List<? extends T> list, T key, Comparator<? super T> c) {
                return binarySearch(list, 0, list.size(), key, Optional.ofNullable(c));
            }

            public static <T> int binarySearch(List<? extends T> list, int fromIndex, int toIndex, T key, Comparator<? super T> c) {
                return CollectionsUtils.binarySearch(list, fromIndex, toIndex, key, c);
            }

            public static <T extends Comparable<? super T>> int binarySearch(List<? extends T> list, int fromIndex, int toIndex, T key, Comparator<? super T> c) {
                CollectionsUtils.c = (Comparator<? super Object>) c;
                if (fromIndex < 0) {
                    throw new IllegalArgumentException("fromIndex must be non-negative");
                }
                if (toIndex > list.size()) {
                    throw new IllegalArgumentException("toIndex must be no greater than list.size()");
                }
                if (fromIndex > toIndex) {
                    throw new IllegalArgumentException("fromIndex must be no greater than toIndex");
                }

                if (c == null) {
                    c = Comparator.<T>naturalOrder();
                }

                int low = fromIndex;
                int high = toIndex - 1;

                while (low <= high) {
                    int mid = (low + high) >>> 1;
                    T midVal = list.get(mid);

                    if (c.compare(midVal, key) < 0) {
                        low = mid + 1;
                    } else if (c.compare(midVal, key) > 0) {
                        high = mid - 1;
                    } else {
                        return mid; // key found
                    }
                }
                return -(low + 1); // key not found
            }
        }
    }
}

