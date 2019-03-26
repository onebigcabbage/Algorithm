package O29最小的K个数;

import java.util.ArrayList;
import java.util.Arrays;

public class Solution {

	// 建大顶堆
	public static void creatHeap(int[] arr, int n) {
		for (int i = (n - 1) / 2; i >= 0; i--) {
			percolateDown(arr, i, n);
		}
	}

	// 删除栈顶元素并调整
	private static void deleteHeap(int[] arr, int data, int n) {
		arr[0] = data;
		percolateDown(arr, 0, n);
	}

	// 下滤
	private static void percolateDown(int[] arr, int i, int n) {
		// 第一个叶子结点的父结点
		int fatherdata = arr[i];
		// 该父结点左孩子的索引
		int child = 2 * i + 1;
		while (child <= n) {
			// 判断左孩子和右孩子较大的那个
			if (child + 1 <= n && arr[child + 1] > arr[child]) {
				child += 1;
			}
			// 若父结点比孩子结点都大，直接跳出
			if (fatherdata > arr[child]) {
				break;
			}
			// 调整父结点和子结点
			arr[i] = arr[child];
			arr[child] = fatherdata;
			i = child;
			child = i * 2 + 1;
		}
	}

	public static ArrayList<Integer> GetLeastNumbers_Solution(int[] input, int k) {
		ArrayList<Integer> list = new ArrayList<Integer>();
		if (input == null || input.length < k) {
			return list;
		}
		creatHeap(input, k - 1);
		for (int i = k; i < input.length; i++) {
			// 是否比堆顶元素大
			if (input[i] < input[0]) {
				deleteHeap(input, input[i], k - 1);
			}
		}
		for (int i = 0; i < k; i++) {
			list.add(input[i]);
		}
		return list;
	}

	public static void main(String[] args) {
		int[] input = { 15, 13, 12, 5, 20, 1, 8, 9 };
		ArrayList<Integer> list = GetLeastNumbers_Solution(input, 5);
		System.out.println(Arrays.toString(input));
		for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i));
		}
	}

}
