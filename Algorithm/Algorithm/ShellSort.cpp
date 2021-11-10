#include <iostream>
using namespace std;

int main() {
	int a[10] = { 13,17,9,21,30,40,14,93,91,2 };
	int current_element, j, h;

	for (int h = 5; h > 0; h = h / 2) {
		for (int i = h; i < 10; i++) {
			current_element = a[i];
			j = i;
			while (j >= h && a[j - h] > current_element) {
				a[j] = a[j - h];
				j = j - h;
			}
			a[j] = current_element;
		}
	}

	for (int i = 0; i < 10; i++) {
		cout << a[i] << endl;
	}

	return 0;

	//버블,삽입 정렬의 단점을 보완하기 위해 삽입 정렬을 이용하여 배열 뒷부분의 
	//작은 숫자를 앞부분으로 빠르게 이동시키고 동시에 앞부분의 큰 숫자는 뒷부분으로 이동시키며, 가장 마지막에는 삽입 정렬을 수행한다.
	//수행 속도는 간격 선정에 따라 좌우된다. 가장 좋은 성능을 보이는 간격은 1,4,10,23,57,132,301,701 이고 이후는 밝혀지지 않았다.
}