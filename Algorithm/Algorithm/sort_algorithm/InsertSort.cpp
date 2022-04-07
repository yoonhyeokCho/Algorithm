#include <iostream>
using namespace std;

int main() {
	int a[10] = { 13,17,9,21,30,40,14,93,91,2 };
	int current_element, j;

	for (int i = 1; i < 10; i++) {
		current_element = a[i];
		j = i - 1;
		while (j >= 0 && a[j] > current_element) {
			a[j + 1] = a[j];
			j = j - 1;
		}
		a[j + 1] = current_element;
	}

	for (int i = 0; i < 10; i++) {
		cout << a[i] << endl;
	}

	return 0;

	// case: 최선 > O(n) case: 평균,최악 >O(n)
	// 거의 정렬된 입력에 대해서는 빠른 알고리즘 
}