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

	//����,���� ������ ������ �����ϱ� ���� ���� ������ �̿��Ͽ� �迭 �޺κ��� 
	//���� ���ڸ� �պκ����� ������ �̵���Ű�� ���ÿ� �պκ��� ū ���ڴ� �޺κ����� �̵���Ű��, ���� ���������� ���� ������ �����Ѵ�.
	//���� �ӵ��� ���� ������ ���� �¿�ȴ�. ���� ���� ������ ���̴� ������ 1,4,10,23,57,132,301,701 �̰� ���Ĵ� �������� �ʾҴ�.
}