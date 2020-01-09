package com.yanftch.review.algorithm;

/**
 * 排序
 * [https://mp.weixin.qq.com/s/jptbe4_mpgqaQ8OzU9kThw]
 * [https://zhuanlan.zhihu.com/p/57088609]
 *
 * <p>
 * <p>
 * 时间复杂度：保留最高次项并忽略该项的系数
 * O(1) < O(log n) < O(n) < O(n*log n) < O(n²) < O(n³) < O(2^n) < O(n!) < O(n^n)
 * 计算方法：
 * ①得出运行时间的函数
 * ②对函数简化
 * - 用常数来取代运行时间中所有加法常数
 * - 修改后的函数中，只保留最高阶项
 * - 如果最高阶项存在且不是 1，则忽略这个项的系数
 * 一般来说，最内层执行次数最多的语句就决定了整个算法的趋势。
 */
public class Sort {
    static int[] base1 = {21, 1, 56, 2, 34, 3, 45, 4, 12, 5, 22, 6, 55, 7, 78, 8, 9, 11, 33, 92, 44, 66, 31, 77, 109, 88, 15, 99, 200, 100}; // 30个数
    static int[] base = {4, 3, 1, 2, 5};

    public static void main(String[] args) {
        print("开始----------->length" + base1.length);
//        int[] selectSort = bubble(base1);
        testInsertSort(base1);
        printArray(base1);
        print("结束----------->");
    }

    // 插入排序
    private static void testInsertSort(int[] arr) {
    }


    /**
     * 快速排序
     * 思想：取基准数，通过排序实现左边的数都小于基准数；右边的数都大于基准数；然后按照上述规则递归处理左右两边的子数组
     * 步骤：
     * ①取数组第一个元素作为基准数
     * ②先从右边开始检索比基准数小的
     * ③再从左边检索比基准数大的
     * ④检索到，停止，然后交换元素，继续检索
     * <p>
     * 时间复杂度：O(nlogn)
     * 空间复杂度：O(logn)
     * 非稳定排序
     * 原地排序
     * 参考视频连接：[https://www.bilibili.com/video/av39519566?from=search&seid=9859166479616658971]
     */
    private static void quickSorts(int arr[], int left, int right) {
        // left 表示从哪个开始排；right 表示排到哪一个
        if (left > right) return; // 左边索引一定小于右边索引
        int length = arr.length;
        int base = arr[left]; // 取要排的数组的最左边为基准数
        int i = left;
        int j = right;
        // 因为不知道具体循环次数，只有 i==j 的时候才停止检索，所以在 i和 j 不相遇的时候，循环检索
        while (i != j) {
            // 先由 j 从右向左检索比基准数小的，检索到，就停下；检索到比基准数大或相等的，继续检索
            while (arr[j] >= base && i < j) {
                j--; // j 从右往左移动
            }
            // i 从左往右检索，检索到
            while (arr[i] <= base && i < j) { //
                i++; // i 从左往右移动
            }
            // 代码走到这，说明 i停下，j 停下；然后交换 i 位置和 j 位置的元素
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
        }
        // 此时跳出循环了，表明此时 i和j 相遇(i==j)，此时需要将 base 和相遇位置的元素进行交换
        // 先把相遇位置的元素赋值给基准数位置的元素
        arr[left] = arr[i];
        // 再把基准数赋值给相遇位置的元素
        arr[i] = base;
        // 此时基准数归位，左边的都比她小，右边的都比她大,接下来遍历左右两边
        quickSorts(arr, left, i - 1);
        quickSorts(arr, i + 1, right);
    }


    /**
     * 冒泡排序
     * 思想：每个位置与她后边位置上的数比较，不满足条件，就对调位置
     * 大白话：数组元素从第一个开始，跟她右边的比较，如果她大于右边的，那么就交换位置，知道比较到最后一个元素，这样最大的元素就到了最右边了。
     * 第一层循环控制循环次数
     * 第二次循环控制第 i+1趟所比较的次数
     * 写法比后边那个简单点...
     * 时间复杂度：O(n2) 注：n 方
     * 空间复杂度：O(1)
     * 稳定排序
     * 原地排序
     */
    private static int[] bubble(int[] arr) {
        int length = arr.length;
        int temp = 0;
        // 第一次控制循环次数
        for (int i = 0; i < length - 1; i++) {
            boolean bChange = true; //标志本轮有无交换
            // 第一次循环，把最大的数整合到了最后了，内循环就长度-1
            for (int j = 0; j < length - 1 - i; j++) { // -i 是为了保证后边已经排好序的，不需要再参与循环了
                if (arr[j] > arr[j + 1]) {
                    bChange = false;
                    temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
            if (!bChange) break;
        }
        return arr;
    }

    /**
     * 插入排序
     * 思想：将一个待排序的元素，插入到已经排好序的数组中的合适位置。
     * 步骤：
     * ①外循环负责依次循环取出来待排序的元素，从 0 到 length
     * ②内循环负责判断待插入的元素，是否比她前边的元素小，待插入的小，则往前继续遍历，直到大，则插入
     * ③内循环就从第 i 个元素开始，倒序遍历
     * 场景：适应于数据量比较少或者部分有序的数据
     * 时间复杂度：O(n2) 注：n 的平方
     * 空间复杂度：O(1)
     * 稳定排序
     * 原地排序
     */
    private static int[] insertSort(int[] array) {
        int length = array.length;
        for (int i = 0; i < length; i++) {
            int tmp = array[i]; // 这个就是待插入的元素
            for (int j = i; j > 0; j--) {
                // 将 a[i]的值依次向前移动，移动到前面的一个值比她小或者没有了就停下
                if (array[j] < array[j - 1]) {
                    int temp = array[j];
                    array[j] = array[j - 1];
                    array[j - 1] = temp;
                } else {
                    // 不小，则跳出循环
                    break;
                }
            }
        }
        return array;
    }

    /**
     * 选择排序
     * 思想：
     * 不断的从未排序的元素中，选择最大(小)的元素放入已排好序的元素集合中
     * 基本思想:
     * 首先，找到数组中最小的那个元素，其次，将它和数组的第一个元素交换位置(如果第一个元素就是最小元素那么它就和自己交换)。
     * 其次，在剩下的元素中找到最小的元素，将它与数组的第二个元素交换位置。如此往复，直到将整个数组排序
     * 步骤：
     * ①获取数组长度 length
     * ②从 0 到 length-1 依次遍历，其中初始化最小值的索引值为 i(第一个就是 index=0)
     * ③二次循环，j 从 i+1 到 length 依次遍历，将arr[j] 和 arr[minIndex] 进行比较，如果 arr[j] 小于 arr[minIndex]则将 minIndex=j;
     * ④交换元素
     * 内循环用来比较；外循环用来交换
     * 时间复杂度：O(n2) 注：n 的平方
     * 空间复杂度：O(1)
     * 非稳定排序
     * 原地排序
     */
    private static int[] selectSort(int[] arr) {
        int length = arr.length; // 数组的长度
        for (int i = 0; i < length - 1; i++) {
            int minValueIndex = i; // 最小值的 index 从 0 开始，也就是初始将第一个数作为最小值
            // 内层 for 循环
            for (int j = i + 1; j < length; j++) {
                if (arr[j] < arr[minValueIndex]) {
                    minValueIndex = j; // 更新最小值的下标
                }
            }
            int temp = arr[minValueIndex];
            arr[minValueIndex] = arr[i];
            arr[i] = temp;
//            swap(arr, minValueIndex, i); // 将最小值与未排列无序数组的第一个元素进行交换
        }
        return arr;
    }

    // ****************************
    /**
     * 归并排序
     */

    /**
     * 堆排序
     */


    /**
     * 冒泡排序
     * 是一种交换排序
     * <p>
     * 算法思想：
     * - 重复走访要排序的数列，一次比较两个元素，发现顺序错误就交换。然后重复走访，直到不需要交换了为止。
     * - 假如有大小为 N 的无序序列，那么就是每趟排序过程，两两比较，找到第 i 小(大)的元素，将其往上拍，
     * - 每趟排序中找到第 i 个小的元素
     * - 所以，我们需要一个外部循环，从数组首端(下标 0) 开始，一直扫描到倒数第二个元素（即下标 N - 2) ，剩下最后一个元素，必然为最大。
     * - 假设是第 i 趟排序，可知，前 i-1 个元素已经有序。现在要找第 i 个元素，只需从数组末端开始，扫描到第 i 个元素，将它们两两比较即可。所以，需要一个内部循环，从数组末端开始（下标 N - 1），扫描到 (下标 i + 1)。
     * </p>
     * <p>
     * 结论：
     * 时间复杂度 O(N2)
     * 最坏时间复杂度 O(N3)
     * 最好时间复杂度 O(N)
     * 空间复杂度 O(1)
     * 总结：当数据越接近正序时，冒泡排序性能越好
     * 优化：通过添加标志位 [bChange] ，表明，如果某一轮排序时，没有元素交换，说明已经是有序的了，可以结束排序，避免不必要的比较过程。
     * </p>
     */
    private static int[] BubbleSort(int[] arr) {
        int temp; // 用来交换的临时数
        boolean bChange = false; //标志本轮有无交换

        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = arr.length - 1; j > i; j--) {
                if (arr[j - 1] > arr[j]) {
                    temp = arr[j - 1];
                    arr[j - 1] = arr[j];
                    arr[j] = temp;
                    bChange = true;
                }
            }
            if (!bChange) break;
        }
        return arr;
    }

    /**
     * 快速排序
     * 是一种交换排序
     * 基本思想：
     * -通过一趟排序，将要排序的数据分成两部分：分割点左边的是比她小的数，右边的是比她大的数
     * -然后再对这两部分，分别进行快速排序，可以递归进行，实现排序需求
     * 基本步骤：
     * 1.先从序列中取出一个中数作为基准数
     * 2.将大于她的数放到右边
     * 3.将小于等于的放到左边
     * 4.重复上述 1，2，3步
     * 结论：
     * 总结：参考 link：[https://blog.csdn.net/IT_ZJYANG/article/details/53406764]
     */
    private static void quickSort(int[] arr, int start, int end) {
        if (start > end) return;
        int div = quickDivider(arr, start, end);
        quickSort(arr, start, div - 1);
        quickSort(arr, div + 1, end);
    }

    private static int quickDivider(int[] a, int start, int end) {
        int base = a[end]; // 每次以最后一个值作为基准数
        while (start < end) { // start 和 end 要是相等，说明都排好序了
            while (start < end && a[start] <= base)
                start++; // 从左边开始遍历，如果实际值比基准小，那么就继续向右走，直到找到比基准大的值，
            // 此循环结束的时候，说明当前索引值对应的实际值已经比基准大了，左右进行交换
            if (start < end) {
                int temp = a[start];
                a[start] = a[end];
                a[end] = temp;
                // 交换之后，被调换的值已经到了最右边，所以要向前移一位
                end--;
            }
            while (start < end && a[end] > base)
                end--; // 从右边开始向左遍历，如果比基准大，继续向左
            // 上面的循环结束，表明当前 a[end] 比基准小，所以互换
            if (start < end) {
                int temp = a[start];
                a[start] = a[end];
                a[end] = temp;
                // 上边的那个值调到了基准的左边了
                start++;
            }

        }
        return end;
    }

    /**
     * 插入排序
     * 算法思路：
     * 每一趟将一个待排序的记录，按照其关键字的大小插入到有序队列的合适位置里，直到全部插入完成。
     * - 假如有个无序序列，R0,R1,R2...RN-1
     * - 先将索引值为 0 的也就是第一个数，作为一个长度为 1 的有序序列
     * - 然后依次将 R1...RN-1 插入到这个有序序列中，所以需要一个针对 R1 到 RN-1 的循环
     * - 插入：现在要将 Ri 插入序列中，此时这个序列前 i-1 个数已经是有序的了，所以要将 Ri 和 R0~Ri-1 进行比较，所有需要一个循环，一般从后开始，即从下标 i-1 到 0 进行遍历。
     * <p>
     * 总结：
     * 时间复杂度平均  O(N2)
     * 时间复杂度最坏 O(N2)
     * 时间复杂度最好 O(N)
     * 空闲复杂度 O(1)
     */

    private static int[] InsertSort(int[] arr) {
        System.out.println("the first item: " + arr[0]); // 第一个元素
        for (int i = 1; i < arr.length; i++) {
            int j = 0;
            int temp = arr[i]; // 取出来第 i 个数，和前边的 i-1 个数进行比较，插入合适位置

            // 前边的 i-1 个数都已是有序的数列了，所以只要当前的数 arr[j] 比 temp 大，就往后移
            for (j = i - 1; j >= 0 && temp < arr[j]; j--) {
                arr[j + 1] = arr[j];
            }
            arr[j + 1] = temp;
        }
        return arr;
    }

    /**
     * 希尔排序
     * 是一种插入排序
     * <p>
     * <p>
     * 总结：
     */
    private static int[] ShellSort(int[] arr) {
        int gap = arr.length / 2;

        while (1 <= gap) {
            // 把距离为 gap 的元素编为一个组，扫描所有组
            for (int i = gap; i < arr.length; i++) {
                int j = 0;
                int temp = arr[i];

                // 对距离为 gap 的元素组进行排序
                for (j = i - gap; j >= 0 && temp < arr[j]; j = j - gap) {
                    arr[j + gap] = arr[j];
                }
                arr[j + gap] = temp;
            }
            gap = gap / 2; // 减小增量
        }

        return arr;
    }

    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    private static void printArray(int[] array) {
        if (array == null || array.length == 0) return;
        System.out.println("数组长度：" + array.length);

        for (int value : array) {
            System.out.print(value + " ");
        }
        System.out.println();
    }

    public static void print(String message) {
        System.out.println(message);
    }

}
