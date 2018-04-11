package myjava;

public class ExamMethod2 {

	/*
	* 1부터 999까지의 숫자가 들어가는 100의 크기로 이루어진 배열을 생성하는 함수를
	* 이용하여 배열을 생성한다.
	- ㄱ.배열의 수들을 한 줄에 10개씩 출력하는 함수, 이때 각 수들은 줄이 맞춰져야 함
	- ㄴ.인덱스가 홀수인 수들을 출력하는 함수, 출력되는 방식은 a와 동일함
	- ㄷ.배열의 수들의 합을 반환하는 함수
	- ㄹ.가장 작은 수의 위치(인덱스)를 반환하는 함수
	- ㅁ.3의 배수만을 새로운 배열에 복사하여 리턴하는 함수
	*/

	public int[] makeArray() {
		int[] arr = new int[100];
		for(int i=0;i<arr.length;i++) {
			arr[i] = (int)(Math.random()*999)+1;
		}
		return arr;
	}

	public void printTenArray(int [] arr) {
		int count=0;
		for(int i=0;i<arr.length;i++) {
			System.out.print(arr[i]+"\t");
			count++;

			if(count==10) {
				System.out.println();
				count=0;
			}
		}
		System.out.println();
	}

	public void printHolArray(int [] arr) {
		int count=0;
		for(int i=0;i<arr.length;i++) {
			if(i%2!=0) {
			System.out.print(arr[i]+"\t");
			count++;
			}

			if(count==10) {
				System.out.println();
				count=0;
			}
		}
		System.out.println();
	}

	public int sumArray(int [] arr) {
		int sum=0;

		for(int i=0;i<arr.length;i++) {
			sum+=arr[i];
		}
		return sum;
	}

	public int getMinimum(int [] arr) {
		int minimum=999;
		int index=0;
		for(int i=0;i<arr.length;i++) {
			if(arr[i]<minimum) {
				index=i;
				minimum=arr[i];
			}
		}
		return index;
	}

	public int[] makeNewArray(int [] arr) {
		int [] newArr;
		int count=0;
		int index=0;
		for(int i=0;i<arr.length;i++) {
			if(arr[i]%3==0) count++;
		}

		newArr = new int[count];

		for(int i=0;i<arr.length;i++) {
			if(arr[i]%3==0) {
				newArr[index] = arr[i];
				index++;
			}
		}

		return newArr;
	}

	public static void main(String[] args) {

		ExamMethod2 exam2 = new ExamMethod2();
		int [] arr = exam2.makeArray();
		exam2.printTenArray(arr);
		System.out.println("========================================================");
		exam2.printHolArray(arr);
		System.out.println("========================================================");
		System.out.println("만들어진 배열 값들의 합은 "+exam2.sumArray(arr));
		System.out.println("========================================================");
		System.out.println("가장 작은 값을 가진 인덱스는 "+exam2.getMinimum(arr));
		System.out.println("========================================================");

		int [] newArr = exam2.makeNewArray(arr);
		System.out.println("3의 배수만으로 이루어진 새로운 배열");
		int count=0;
		for(int i=0;i<newArr.length;i++) {
			System.out.print(newArr[i]+"\t");
			count++;

			if(count==10) {
				System.out.println();
				count=0;
			}
		}
	}
}