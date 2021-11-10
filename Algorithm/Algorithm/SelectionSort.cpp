#include <iostream>
using namespace std;

int main() {
	int a[10] = { 13,17,9,21,30,40,14,93,91,2 };
	int min, temp;
	for (int i = 0; i < 9; i++) {
		min = i;
		for (int j = i + 1; j < 10; j++) {
			if (a[j] < a[min])
				min = j;
		}
		temp = a[min];
		a[min] = a[i];
		a[i] = temp;
	}

	for (int i = 0; i < 10; i++) {
		cout << a[i] << endl;
	}

	return 0;

	//항상 일정한 시간복잡도 가짐. O(n^2)
}