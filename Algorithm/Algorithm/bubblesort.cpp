#include <iostream>
using namespace std;

int main() {
	int a[10] = { 0, };
	int n;
	cout << "�Է��Ͻÿ�:" << endl;
	cin >> n;

	cout << "�迭����ÿ�" << endl;
	for (int i = 0; i < n; i++) {
		cin >> a[i];
	}

	int brk = n;

	for (int i = 1; i <= n - 1; i++) {
		int cou = 0;
		for (int j = 1; j <= brk - 1; j++) {
			if (a[j - 1] > a[j]) {
				int temp = a[j - 1];
				a[j - 1] = a[j];
				a[j] = temp;

				cou = j;              //���ʿ��� �񱳸� ���ϱ� ���� �ش� �н����� ���������� swap�� �ε����� �����Ѵ�.
			}
		}
		brk = cou;
	}

	for (int i = 0; i < n; i++) {
		cout << a[i] << endl;
	}
	return 0;

	//�ð� ���⵵ O(n^2)
}