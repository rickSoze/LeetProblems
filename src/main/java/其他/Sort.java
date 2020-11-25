package 其他;

public class Sort {

    public static void swap(int[] a,int i,int j ){
        int temp = a[i];
        a[i]=a[j];
        a[j]=temp;
    }


    //选择排序
    public static int[] selectionSort(int[] a) {
        for (int i = 0; i < a.length; i++) {
            for (int j = i + 1; j < a.length; j++) {
                if (a[i] > a[j]) {
                    swap(a, i, j);
                }
            }
        }
        return a;
    }


    //插入排序
    public static int[] insertSort(int[] a) {
        for (int i = 1; i < a.length; i++) {
            int temp = a[i];
            int j = i;
            while (j > 0 && temp < a[j - 1]) {
                a[j] = a[j - 1];
                j--;
            }
            a[j] = temp;
        }
        return a;
    }


    //希尔排序 --- 高级的插入排序
    public static int[] shellSort(int[] a) {
        int gap = a.length / 2;
        while (gap >= 1) {
            for (int i = gap; i < a.length; i++) {
                int j;
                int temp = a[i];
                for (j = i - gap; j >= 0 && temp < a[j]; j = j - gap) {
                    a[j + gap] = a[j];
                }
                a[j + gap] = temp;
            }
            gap /= 2;
        }
        return a;
    }



    //冒泡排序
    public static int[] bubbleSort(int[] a) {
        for (int end = a.length - 1; end > 0; end--) {
            boolean flag = false; //增加一个判断是否发生过交换的标记
            for (int j = 0; j < end; j++) {
                if (a[j] > a[j + 1]) {
                    swap(a, j, j + 1);
                    flag = true;
                }
            }
            if (!flag) { //如果扫描一遍没有发生交换则说明序列已经有序，退出循环
                break;
            }
        }
        return a;
    }


    //快排
    //调用  qSort(a, 0, a.length - 1);
    public static void qSort(int[] sequence, int low, int high) {
        int pivot = sequence[low]; // 取首元素的为基准
        int left = low, right = high;
        if (low >= high) {
            return;
        }
        swap(sequence, low, high); //将基准与最后一个元素交换
        while (true) {
            //将序列中比基准小的移到基准左边，比基准大的移到基准右边
            while (low < high && sequence[low] <= pivot) {
                low++;
            }
            while (low < high && sequence[high] >= pivot) {
                high--;
            }
            if (low < high) {
                swap(sequence, low, high);
            } else {
                break;
            }
        }
        swap(sequence, low, right); //将最后的基准换到正确的位置

        //分别对两个子集进行快排
        qSort(sequence, left, low - 1);
        qSort(sequence, low + 1, right);
    }


    //堆排序
    //实现一个最大或最小堆，每次取出堆顶元素放到数组中，然后调整堆；
//    public static int[] heapSort(int[] a) {
//        buildMaxHeap(a, a.length - 1);
//        swap(a, 0, a.length - 1);
//        for (int i = 1; i < a.length - 1; i++) {
//            adjustMaxHeap(a, 0, a.length - 1 - i);
//            swap(a, 0, a.length - 1 - i);
//        }
//        return a;
//    }



}
