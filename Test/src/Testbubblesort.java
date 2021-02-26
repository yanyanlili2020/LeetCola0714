/**
 *
 */
public class Testbubblesort {
    public static void main(String[] args) {
        int[] Data = {10, 23, 11, 56, 45, 26, 59, 28, 84, 79};
        int i, j, k,Index=10;
        //循环变量
        boolean Change;
//数据是否有改变
        int Temp;
//数据暂存变量
        for(j = Index; j > 1; j--) {
            //外层循环
            Change = false;
//设置为数据未改变
            for(i = 0; i < j - 1; i++) {
//内层循环
                if(Data[i + 1] < Data[i]) {
//比较两数值
                    Temp = Data[i + 1];
                    Data[i + 1] = Data[i];
                    Data[i] = Temp;
                    Change = true;
                }
            }//设 置数据已改变//如果数据已改变则输出结果
            if(Change) {
                System.out.print("Current Sorting Result:");
                //打印目前排序状况
                for(k = 0; k < Index; k++)
                    System.out.print(" " + Data[k] + " ");
                System.out.println("");
            }
        }
    }
}
//        int i, temp;
//        System.out.println("初始序列的数组为: ");
//        for(i = 0; i < 10; i++) {
//            System.out.print(a[i] + " ");
//        }
//        for(i = 0; i < 9; i++) {
//            if(a[i] > a[i + 1]) {
//                temp = a[i];
//                a[i] = a[i + 1];
//                a[i + 1] = temp;
//            }
//        }
//        System.out.println("\n" + "排序好的数组为: ");
//        for(i = 0; i < 10; i++) {
//            System.out.print(a[i] + " ");
//        }

